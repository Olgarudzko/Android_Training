package com.rudzko.firstapp.domain.interactions;

import android.util.Log;

import com.rudzko.firstapp.data.database.DBManager;
import com.rudzko.firstapp.data.db_entity.DataMyCountry;
import com.rudzko.firstapp.data.db_entity.DataPerson;
import com.rudzko.firstapp.domain.entity.AddPerson;
import com.rudzko.firstapp.domain.interactions.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * @author Olga Rudzko
 */

public class AddPersonToDB extends UseCase<AddPerson, Void> {

    @Override
    protected Observable<Void> buildUseCase(final AddPerson person) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DataMyCountry dataCountry = new DataMyCountry
                        (person.getPerson().getCountry().getName(), person.getPerson().getCountry().getCode());
                DataPerson dataPerson = new DataPerson(person.getPerson().getName(), dataCountry);
                DBManager manager = new DBManager(person.getContext());
                manager.openDB(true);
                manager.addPerson(dataPerson);
                manager.closeDB();
                Log.d("Sending to db", dataPerson.getName()+" from "+dataPerson.getCountry().getName());
            }
        }).just(null);
    }
}
