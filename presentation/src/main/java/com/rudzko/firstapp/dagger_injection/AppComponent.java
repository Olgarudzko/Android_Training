package com.rudzko.firstapp.dagger_injection;

import com.rudzko.firstapp.cw_17.UI;
import com.rudzko.firstapp.hw_10.HW10_ViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Olga Rudzko
 */


@Component (modules={AppModule.class})
@Singleton
public interface AppComponent {
    void inject(UI ui);
    void injectViewModel(HW10_ViewModel model);
}
