package com.rudzko.firstapp.dagger_injection;

import com.rudzko.firstapp.cw_17.UI;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Olga Rudzko
 */


@Component (modules={AppModule.class})
@Singleton
public interface AppComponent {
    public void inject(UI ui);
}
