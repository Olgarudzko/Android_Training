package com.rudzko.firstapp.domain.interactions;

import android.content.Context;
import android.util.Log;

import com.rudzko.firstapp.data.database.DBManager;
import com.rudzko.firstapp.data.db_entity.DataMyCountry;
import com.rudzko.firstapp.data.db_entity.DataPerson;
import com.rudzko.firstapp.domain.entity.MyCountry;
import com.rudzko.firstapp.domain.entity.Person;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * @author Olga Rudzko
 */

public class GetPersonsFromDB extends UseCase<Context, List<Person>> {

    @Override
    protected Observable<List<Person>> buildUseCase(final Context context) {


        return Observable.create(new ObservableOnSubscribe<List<Person>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<List<Person>> e) throws Exception {

                DBManager manager = new DBManager(context);
                manager.openDB(false);
                List <DataPerson> list=manager.getPersons();
                manager.closeDB();
                if (list!=null){
                    Log.d("Start reading array", "from Data");
                    List<Person> ready= new ArrayList<>();
                    for (DataPerson user: list){
                        Log.d(user.getName(), user.getCountry().getName());
                        MyCountry country=new MyCountry(user.getCountry().getName(), user.getCountry().getCode());
                        Person person=new Person(user.getName(), country);
//                        Person person=new Person();
//                        person.setName(user.getName());

                        person.setId(user.getId());
                        ready.add(person);
                    }
                    e.onNext(ready);
                }
            }

        });
   }
}
