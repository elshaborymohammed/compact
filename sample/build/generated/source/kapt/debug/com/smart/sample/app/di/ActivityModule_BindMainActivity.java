package com.smart.sample.app.di;

import com.smart.sample.app.trend.TrendActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.annotation.Generated;

@Module(subcomponents = ActivityModule_BindMainActivity.TrendActivitySubcomponent.class)
@Generated("dagger.android.processor.AndroidProcessor")
public abstract class ActivityModule_BindMainActivity {
  private ActivityModule_BindMainActivity() {}

  @Binds
  @IntoMap
  @ClassKey(TrendActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TrendActivitySubcomponent.Factory builder);

  @Subcomponent
  public interface TrendActivitySubcomponent extends AndroidInjector<TrendActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<TrendActivity> {}
  }
}
