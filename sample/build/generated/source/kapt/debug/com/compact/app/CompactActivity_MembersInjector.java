package com.compact.app;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CompactActivity_MembersInjector implements MembersInjector<CompactActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  public CompactActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
  }

  public static MembersInjector<CompactActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider) {
    return new CompactActivity_MembersInjector(fragmentDispatchingAndroidInjectorProvider);
  }

  @Override
  public void injectMembers(CompactActivity instance) {
    injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
  }

  public static void injectFragmentDispatchingAndroidInjector(
      CompactActivity instance,
      DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector) {
    instance.fragmentDispatchingAndroidInjector = fragmentDispatchingAndroidInjector;
  }
}
