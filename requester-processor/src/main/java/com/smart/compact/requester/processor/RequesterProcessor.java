package com.smart.compact.requester.processor;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableSet;
import com.smart.compact.requester.annotation.Requester;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import retrofit2.Retrofit;

@AutoService(Processor.class)
public class RequesterProcessor extends AbstractProcessor {

    private Messager messager;
    private Filer filer;
    private Elements elements;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();
        elements = processingEnvironment.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Element element : roundEnvironment.getElementsAnnotatedWith(Requester.class)) {
            if (element.getKind() != ElementKind.INTERFACE) {
                messager.printMessage(Diagnostic.Kind.ERROR, "Can be applied to classes only.");
                return false;
            }

            String packageName = elements.getPackageOf(element).getQualifiedName().toString();
            String className = element.getSimpleName().toString();

            TypeSpec.Builder classBuilder = TypeSpec
                    .classBuilder("Requester" + className)
                    .addAnnotation(Singleton.class)
                    .addField(FieldSpec.builder(Retrofit.class, "request", Modifier.PRIVATE, Modifier.FINAL).build())
                    .addMethod(MethodSpec
                            .constructorBuilder()
                            .addAnnotation(Inject.class)
                            .addParameter(Retrofit.class, "request")
                            .addStatement("this.request = request")
                            .build())
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

            for (Element methodElement : element.getEnclosedElements()) {
                if (methodElement.getKind() != ElementKind.METHOD) {
                    continue;
                }

                ExecutableElement method = (ExecutableElement) methodElement;
                String parameters = "";
                List<ParameterSpec> parameterSpecs = new ArrayList<>();
                for (VariableElement next : method.getParameters()) {
                    parameterSpecs.add(ParameterSpec.get(next));
                    parameters += String.format("%s,", next.getSimpleName());
                }
                parameters = parameters.replaceAll(".$", "");

                MethodSpec intentMethod = MethodSpec
                        .methodBuilder(methodElement.getSimpleName().toString())
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .returns(TypeName.get(method.getReturnType()))
                        .addParameters(parameterSpecs)
                        .addStatement("return request.create($L.class).$L($L)"
                                , className
                                , method.getSimpleName().toString()
                                , parameters
                        )
                        .build();
                classBuilder.addMethod(intentMethod);
            }

            try {
                JavaFile.builder(packageName, classBuilder.build())
                        .build().writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return ImmutableSet.of(Requester.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}