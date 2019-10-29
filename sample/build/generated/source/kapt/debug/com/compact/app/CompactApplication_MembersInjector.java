package com.compact.app;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CompactApplication_MembersInjector
    implements MembersInjector<CompactApplication> {
  private final Provider<DispatchingAndroidInjector<Activity>>
      activityDispatchingAndroidInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Service>>
      serviceDispatchingAndroidInjectorProvider;

  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>>
      broadcastReceiverDispatchingAndroidInjectorProvider;

  public CompactApplication_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>>
          broadcastReceiverDispatchingAndroidInjectorProvider) {
    this.activityDispatchingAndroidInjectorProvider = activityDispatchingAndroidInjectorProvider;
    this.serviceDispatchingAndroidInjectorProvider = serviceDispatchingAndroidInjectorProvider;
    this.broadcastReceiverDispatchingAndroidInjectorProvider =
        broadcastReceiverDispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<CompactApplication> create(
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceDispatchingAndroidInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>>
          broadcastReceiverDispatchingAndroidInjectorProvider) {
    return new CompactApplication_MembersInjector(
        activityDispatchingAndroidInjectorProvider,
        serviceDispatchingAndroidInjectorProvider,
        broadcastReceiverDispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(CompactApplication instance) {
    injectActivityDispatchingAndroidInjector(
        instance, activityDispatchingAndroidInjectorProvider.get());
    injectServiceDispatchingAndroidInjector(
        instance, serviceDispatchingAndroidInjectorProvider.get());
    injectBroadcastReceiverDispatchingAndroidInjector(
        instance, broadcastReceiverDispatchingAndroidInjectorProvider.get());
  }

  public static void injectActivityDispatchingAndroidInjector(
      CompactApplication instance,
      DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector) {
    instance.activityDispatchingAndroidInjector = activityDispatchingAndroidInjector;
  }

  public static void injectServiceDispatchingAndroidInjector(
      CompactApplication instance,
      DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector) {
    instance.serviceDispatchingAndroidInjector = serviceDispatchingAndroidInjector;
  }

  public static void injectBroadcastReceiverDispatchingAndroidInjector(
      CompactApplication instance,
      DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverDispatchingAndroidInjector) {
    instance.broadcastReceiverDispatchingAndroidInjector =
        broadcastReceiverDispatchingAndroidInjector;
  }
}
