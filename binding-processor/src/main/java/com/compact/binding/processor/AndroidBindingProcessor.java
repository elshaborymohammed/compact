package com.compact.binding.processor;

import com.compact.binding.annotation.AndroidBinding;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import net.ltgt.gradle.incap.IncrementalAnnotationProcessor;
import net.ltgt.gradle.incap.IncrementalAnnotationProcessorType;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@IncrementalAnnotationProcessor(IncrementalAnnotationProcessorType.AGGREGATING)
@AutoService(Processor.class)
public class AndroidBindingProcessor extends AbstractProcessor {

    private Messager messager;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        TypeSpec.Builder classBuilder = TypeSpec
                .classBuilder("AndroidBindingModule")
                .addAnnotation(AnnotationSpec.builder(Module.class).addMember("includes", "$L.class", AndroidInjectionModule.class.getCanonicalName()).build())
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);

        for (Element element : roundEnvironment.getElementsAnnotatedWith(AndroidBinding.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                messager.printMessage(Diagnostic.Kind.ERROR, "Can be applied to Android components Activity, Fragment, Service, Receiver only.", element);
                return false;
            }

            MethodSpec intentMethod = MethodSpec
                    .methodBuilder("provides" + element.getSimpleName())
                    .addAnnotation(ContributesAndroidInjector.class)
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(TypeName.get(element.asType()))
                    .build();
            classBuilder.addMethod(intentMethod);
        }

        try {
            JavaFile.builder("com.compact.app.di.binding", classBuilder.build()).build().writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(AndroidBinding.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}