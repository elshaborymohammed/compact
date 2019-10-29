package com.smart.sample.app;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import com.compact.app.CompactApplication_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<DispatchingAndroidInjector<Activity>>
      activityDispatchingAndroidInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Service>>
      serviceDispatchingAndroidInjectorProvider;

  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>>
      broadcastReceiverDispatchingAndroidInjectorProvider;

  public App_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>>
          broadcastReceiverDispatchingAndroidInjectorProvider) {
    this.activityDispatchingAndroidInjectorProvider = activityDispatchingAndroidInjectorProvider;
    this.serviceDispatchingAndroidInjectorProvider = serviceDispatchingAndroidInjectorProvider;
    this.broadcastReceiverDispatchingAndroidInjectorProvider =
        broadcastReceiverDispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<App> create(
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>>
          broadcastReceiverDispatchingAndroidInjectorProvider) {
    return new App_MembersInjector(
        activityDispatchingAndroidInjectorProvider,
        serviceDispatchingAndroidInjectorProvider,
        broadcastReceiverDispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(App instance) {
    CompactApplication_MembersInjector.injectActivityDispatchingAndroidInjector(
        instance, activityDispatchingAndroidInjectorProvider.get());
    CompactApplication_MembersInjector.injectServiceDispatchingAndroidInjector(
        instance, serviceDispatchingAndroidInjectorProvider.get());
    CompactApplication_MembersInjector.injectBroadcastReceiverDispatchingAndroidInjector(
        instance, broadcastReceiverDispatchingAndroidInjectorProvider.get());
  }
}
