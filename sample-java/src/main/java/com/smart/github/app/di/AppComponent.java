package com.smart.github.app.di;

import android.app.Application;
import com.compact.di.module.AuthenticatorModule;
import com.smart.github.app.App;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, ViewModelModule.class, AuthenticatorModule.class})
public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
