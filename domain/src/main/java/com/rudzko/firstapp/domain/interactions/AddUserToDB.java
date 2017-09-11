package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.data.database.DBManager;
import com.rudzko.firstapp.data.db_entity.Country;
import com.rudzko.firstapp.data.db_entity.User;
import com.rudzko.firstapp.domain.entity.AddUser;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * @author Olga Rudzko
 */

public class AddUserToDB extends UseCase<AddUser, Void> {

    @Override
    protected Observable<Void> buildUseCase(final AddUser user) {

        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DBManager manager=new DBManager(user.getContext());
                manager.openDB(true);
                manager.addUser(convert(user.getUser()));
                manager.closeDB();
            }
        }).just(null);
    }

    private User convert (com.rudzko.firstapp.domain.entity.User user){
        User userData=new User();
        userData.setName(user.getName());
        userData.setAge(user.getAge());
        userData.setCountry(convertCountry(user.getCountry()));

        return userData;
    }

    private Country convertCountry(com.rudzko.firstapp.domain.entity.Country country){
        return new Country(country.getId(), country.getName());
    }
}
