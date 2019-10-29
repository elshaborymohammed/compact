package com.smart.sample.app.di;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.compact.app.CompactActivity_MembersInjector;
import com.compact.app.CompactApplication_MembersInjector;
import com.compact.app.viewmodel.CompactViewModelProviderFactory;
import com.compact.app.viewmodel.CompactViewModelProviderFactory_Factory;
import com.compact.di.module.AuthenticatorModule;
import com.compact.di.module.AuthenticatorModule_ProvidesAuthenticatorFactory;
import com.compact.di.module.ContextModule;
import com.compact.di.module.ContextModule_ProvidesApplicationContextFactory;
import com.compact.di.module.GsonModule;
import com.compact.di.module.GsonModule_ProvidesGsonFactory;
import com.compact.di.module.NetworkModule;
import com.compact.di.module.NetworkModule_ProvideOkHttpCacheFactory;
import com.compact.di.module.NetworkModule_ProvideOkHttpClientCachedFactory;
import com.compact.di.module.NetworkModule_ProvidesBodyInterceptorsFactory;
import com.compact.di.module.NetworkModule_ProvidesProtocolHTTP1Factory;
import com.compact.di.module.NetworkModule_ProvidesProtocolHTTP2Factory;
import com.compact.di.module.RequestBuilderModule;
import com.compact.di.module.RequestBuilderModule_ProvidesRequestBuilderFactory;
import com.compact.di.module.RequestModule;
import com.compact.di.module.RequestModule_ProvidesRequestFactory;
import com.compact.di.module.SchedulerModule;
import com.compact.di.module.SchedulerModule_ProvidesMainThreadFactory;
import com.compact.di.module.SchedulerModule_ProvidesNetworkSchedulerFactory;
import com.compact.executor.AppExecutors;
import com.compact.executor.AppExecutors_Factory;
import com.compact.executor.MainThread;
import com.compact.executor.WorkerThread;
import com.google.gson.Gson;
import com.smart.sample.app.App;
import com.smart.sample.app.trend.TrendActivity;
import com.smart.sample.app.trend.TrendActivity_MembersInjector;
import com.smart.sample.app.trend.TrendViewModel;
import com.smart.sample.app.trend.TrendViewModel_Factory;
import com.smart.sample.data.api.RequesterTrendsApi;
import com.smart.sample.data.api.RequesterTrendsApi_Factory;
import com.smart.sample.data.module.ProtocolModule;
import com.smart.sample.data.module.ProtocolModule_ProvidesTrendsProtocolFactory;
import com.smart.sample.domain.protocol.ITrendsProtocol;
import com.smart.sample.domain.usecase.TrendsUseCase;
import com.smart.sample.domain.usecase.TrendsUseCase_Factory;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<ActivityModule_BindMainActivity.TrendActivitySubcomponent.Factory>
      trendActivitySubcomponentFactoryProvider;

  private Provider<String> providesDatePatternProvider;

  private Provider<Gson> providesGsonProvider;

  private Provider<Converter.Factory> providesGsonConverterFactory$sample_debugProvider;

  private Provider<Set<Converter.Factory>> setOfConverterFactoryProvider;

  private Provider<CallAdapter.Factory> providesCompactCallAdapterFactoryProvider;

  private Provider<Set<CallAdapter.Factory>> setOfCallAdapterFactoryProvider;

  private Provider<String> providesEndpointProvider;

  private Provider<Retrofit.Builder> providesRequestBuilderProvider;

  private Provider<Protocol> providesProtocolHTTP1Provider;

  private Provider<Protocol> providesProtocolHTTP2Provider;

  private Provider<Set<Protocol>> setOfProtocolProvider;

  private Provider<Interceptor> providesBodyInterceptorsProvider;

  private Provider<Set<Interceptor>> setOfInterceptorProvider;

  private Provider<Application> applicationProvider;

  private Provider<Context> providesApplicationContextProvider;

  private Provider<Cache> provideOkHttpCacheProvider;

  private Provider<Authenticator> providesAuthenticatorProvider;

  private Provider<OkHttpClient.Builder> provideOkHttpClientCachedProvider;

  private Provider<Retrofit> providesRequestProvider;

  private Provider<RequesterTrendsApi> requesterTrendsApiProvider;

  private Provider<ITrendsProtocol> providesTrendsProtocolProvider;

  private Provider<TrendsUseCase> trendsUseCaseProvider;

  private Provider<AppExecutors> appExecutorsProvider;

  private Provider<WorkerThread> providesNetworkSchedulerProvider;

  private Provider<MainThread> providesMainThreadProvider;

  private Provider<TrendViewModel> trendViewModelProvider;

  private Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>>
      mapOfClassOfAndProviderOfViewModelProvider;

  private Provider<CompactViewModelProviderFactory> compactViewModelProviderFactoryProvider;

  private DaggerAppComponent(
      NetworkModule networkModuleParam,
      ContextModule contextModuleParam,
      AppModule appModuleParam,
      GsonModule gsonModuleParam,
      RequestModule requestModuleParam,
      RequestBuilderModule requestBuilderModuleParam,
      ProtocolModule protocolModuleParam,
      SchedulerModule schedulerModuleParam,
      AuthenticatorModule authenticatorModuleParam,
      Application applicationParam) {

    initialize(
        networkModuleParam,
        contextModuleParam,
        appModuleParam,
        gsonModuleParam,
        requestModuleParam,
        requestBuilderModuleParam,
        protocolModuleParam,
        schedulerModuleParam,
        authenticatorModuleParam,
        applicationParam);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<?>, Provider<AndroidInjector.Factory<?>>>
      getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
    return Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>singletonMap(
        TrendActivity.class, (Provider) trendActivitySubcomponentFactoryProvider);
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<Service> getDispatchingAndroidInjectorOfService() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  private DispatchingAndroidInjector<BroadcastReceiver>
      getDispatchingAndroidInjectorOfBroadcastReceiver() {
    return DispatchingAndroidInjector_Factory.newInstance(
        getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
        Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
  }

  @SuppressWarnings("unchecked")
  private void initialize(
      final NetworkModule networkModuleParam,
      final ContextModule contextModuleParam,
      final AppModule appModuleParam,
      final GsonModule gsonModuleParam,
      final RequestModule requestModuleParam,
      final RequestBuilderModule requestBuilderModuleParam,
      final ProtocolModule protocolModuleParam,
      final SchedulerModule schedulerModuleParam,
      final AuthenticatorModule authenticatorModuleParam,
      final Application applicationParam) {
    this.trendActivitySubcomponentFactoryProvider =
        new Provider<ActivityModule_BindMainActivity.TrendActivitySubcomponent.Factory>() {
          @Override
          public ActivityModule_BindMainActivity.TrendActivitySubcomponent.Factory get() {
            return new TrendActivitySubcomponentFactory();
          }
        };
    this.providesDatePatternProvider =
        DoubleCheck.provider(AppModule_ProvidesDatePatternFactory.create(appModuleParam));
    this.providesGsonProvider =
        DoubleCheck.provider(
            GsonModule_ProvidesGsonFactory.create(gsonModuleParam, providesDatePatternProvider));
    this.providesGsonConverterFactory$sample_debugProvider =
        AppModule_ProvidesGsonConverterFactory$sample_debugFactory.create(
            appModuleParam, providesGsonProvider);
    this.setOfConverterFactoryProvider =
        SetFactory.<Converter.Factory>builder(1, 0)
            .addProvider(providesGsonConverterFactory$sample_debugProvider)
            .build();
    this.providesCompactCallAdapterFactoryProvider =
        AppModule_ProvidesCompactCallAdapterFactoryFactory.create(appModuleParam);
    this.setOfCallAdapterFactoryProvider =
        SetFactory.<CallAdapter.Factory>builder(1, 0)
            .addProvider(providesCompactCallAdapterFactoryProvider)
            .build();
    this.providesEndpointProvider =
        DoubleCheck.provider(AppModule_ProvidesEndpointFactory.create(appModuleParam));
    this.providesRequestBuilderProvider =
        DoubleCheck.provider(
            RequestBuilderModule_ProvidesRequestBuilderFactory.create(
                requestBuilderModuleParam,
                setOfConverterFactoryProvider,
                setOfCallAdapterFactoryProvider,
                providesEndpointProvider));
    this.providesProtocolHTTP1Provider =
        NetworkModule_ProvidesProtocolHTTP1Factory.create(networkModuleParam);
    this.providesProtocolHTTP2Provider =
        NetworkModule_ProvidesProtocolHTTP2Factory.create(networkModuleParam);
    this.setOfProtocolProvider =
        SetFactory.<Protocol>builder(2, 0)
            .addProvider(providesProtocolHTTP1Provider)
            .addProvider(providesProtocolHTTP2Provider)
            .build();
    this.providesBodyInterceptorsProvider =
        NetworkModule_ProvidesBodyInterceptorsFactory.create(networkModuleParam);
    this.setOfInterceptorProvider =
        SetFactory.<Interceptor>builder(1, 0).addProvider(providesBodyInterceptorsProvider).build();
    this.applicationProvider = InstanceFactory.create(applicationParam);
    this.providesApplicationContextProvider =
        DoubleCheck.provider(
            ContextModule_ProvidesApplicationContextFactory.create(
                contextModuleParam, applicationProvider));
    this.provideOkHttpCacheProvider =
        DoubleCheck.provider(
            NetworkModule_ProvideOkHttpCacheFactory.create(
                networkModuleParam, providesApplicationContextProvider));
    this.providesAuthenticatorProvider =
        DoubleCheck.provider(
            AuthenticatorModule_ProvidesAuthenticatorFactory.create(authenticatorModuleParam));
    this.provideOkHttpClientCachedProvider =
        DoubleCheck.provider(
            NetworkModule_ProvideOkHttpClientCachedFactory.create(
                networkModuleParam,
                setOfProtocolProvider,
                setOfInterceptorProvider,
                provideOkHttpCacheProvider,
                providesAuthenticatorProvider));
    this.providesRequestProvider =
        DoubleCheck.provider(
            RequestModule_ProvidesRequestFactory.create(
                requestModuleParam,
                providesRequestBuilderProvider,
                provideOkHttpClientCachedProvider));
    this.requesterTrendsApiProvider =
        DoubleCheck.provider(RequesterTrendsApi_Factory.create(providesRequestProvider));
    this.providesTrendsProtocolProvider =
        DoubleCheck.provider(
            ProtocolModule_ProvidesTrendsProtocolFactory.create(
                protocolModuleParam, requesterTrendsApiProvider));
    this.trendsUseCaseProvider =
        DoubleCheck.provider(TrendsUseCase_Factory.create(providesTrendsProtocolProvider));
    this.appExecutorsProvider = DoubleCheck.provider(AppExecutors_Factory.create());
    this.providesNetworkSchedulerProvider =
        DoubleCheck.provider(
            SchedulerModule_ProvidesNetworkSchedulerFactory.create(
                schedulerModuleParam, appExecutorsProvider));
    this.providesMainThreadProvider =
        DoubleCheck.provider(
            SchedulerModule_ProvidesMainThreadFactory.create(
                schedulerModuleParam, appExecutorsProvider));
    this.trendViewModelProvider =
        DoubleCheck.provider(
            TrendViewModel_Factory.create(
                trendsUseCaseProvider,
                providesNetworkSchedulerProvider,
                providesMainThreadProvider));
    this.mapOfClassOfAndProviderOfViewModelProvider =
        MapProviderFactory.<Class<? extends ViewModel>, ViewModel>builder(1)
            .put(TrendViewModel.class, (Provider) trendViewModelProvider)
            .build();
    this.compactViewModelProviderFactoryProvider =
        DoubleCheck.provider(
            CompactViewModelProviderFactory_Factory.create(
                mapOfClassOfAndProviderOfViewModelProvider));
  }

  @Override
  public void inject(App app) {
    injectApp(app);
  }

  private App injectApp(App instance) {
    CompactApplication_MembersInjector.injectActivityDispatchingAndroidInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    CompactApplication_MembersInjector.injectServiceDispatchingAndroidInjector(
        instance, getDispatchingAndroidInjectorOfService());
    CompactApplication_MembersInjector.injectBroadcastReceiverDispatchingAndroidInjector(
        instance, getDispatchingAndroidInjectorOfBroadcastReceiver());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerAppComponent(
          new NetworkModule(),
          new ContextModule(),
          new AppModule(),
          new GsonModule(),
          new RequestModule(),
          new RequestBuilderModule(),
          new ProtocolModule(),
          new SchedulerModule(),
          new AuthenticatorModule(),
          application);
    }
  }

  private final class TrendActivitySubcomponentFactory
      implements ActivityModule_BindMainActivity.TrendActivitySubcomponent.Factory {
    @Override
    public ActivityModule_BindMainActivity.TrendActivitySubcomponent create(TrendActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new TrendActivitySubcomponentImpl(arg0);
    }
  }

  private final class TrendActivitySubcomponentImpl
      implements ActivityModule_BindMainActivity.TrendActivitySubcomponent {
    private TrendActivitySubcomponentImpl(TrendActivity arg0) {}

    private DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjectorOfFragment() {
      return DispatchingAndroidInjector_Factory.newInstance(
          DaggerAppComponent.this.getMapOfClassOfAndProviderOfAndroidInjectorFactoryOf(),
          Collections.<String, Provider<AndroidInjector.Factory<?>>>emptyMap());
    }

    @Override
    public void inject(TrendActivity arg0) {
      injectTrendActivity(arg0);
    }

    private TrendActivity injectTrendActivity(TrendActivity instance) {
      CompactActivity_MembersInjector.injectFragmentDispatchingAndroidInjector(
          instance, getDispatchingAndroidInjectorOfFragment());
      TrendActivity_MembersInjector.injectFactory(
          instance, DaggerAppComponent.this.compactViewModelProviderFactoryProvider.get());
      return instance;
    }
  }
}
