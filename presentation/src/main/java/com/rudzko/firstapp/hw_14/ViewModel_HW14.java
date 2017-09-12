package com.rudzko.firstapp.hw_14;

import android.util.Log;
import android.view.View;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.*;
import com.rudzko.firstapp.domain.entity.Person;
import com.rudzko.firstapp.domain.interactions.AddPersonToDB;
import com.rudzko.firstapp.domain.interactions.GetPersonsFromDB;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class ViewModel_HW14 implements BaseViewModel {

    String json = null;
    JSONArray array;
    HW14_Activity activity;
    ArrayList<MyCountry> codes = new ArrayList<>();
    AddPersonToDB addPerson = new AddPersonToDB();
    GetPersonsFromDB getAllPersons = new GetPersonsFromDB();

    public ViewModel_HW14(HW14_Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {
        try {
            InputStream reading = activity.getAssets().open("countries.json");
            int size = reading.available();
            byte[] buffer = new byte[size];
            reading.read(buffer);
            reading.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e("OnInputRead", json);
        }
        try {
            array = new JSONArray(json);
        } catch (JSONException e) {
            Log.e("Cant create JSONArray", json);
        }
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = null;
            try {
                obj = array.getJSONObject(i);
                codes.add(new MyCountry(obj.getString("name"), obj.getString("code")));
                Log.d(obj.getString("name"), obj.getString("code"));
            } catch (JSONException e) {
                Log.e("Finding object", "Cant get object " + i);
            }
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void release() {

    }

    @Override
    public void pause() {
        addPerson.dispose();
    }

    public void addToDB(View view) {
        String name = activity.binding.personName.getText().toString();
        // MyCountry country=activity.adapter.getChosen();
        MyCountry country = codes.get(activity.binding.worldSpinner.getSelectedItemPosition());
        Log.d("User chose country", country.getName());
        AddPerson ready = new AddPerson();
        ready.setContext(activity);
        ready.setPerson(new com.rudzko.firstapp.domain.entity.Person
                (name, new com.rudzko.firstapp.domain.entity.MyCountry(country.getName(), country.getCode())));
        Log.d("AddPerson created from", ready.getPerson().getCountry().getName());
        addPerson.execute(ready, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void showDB(View view) {
        getAllPersons.execute(activity, new DisposableObserver<List<com.rudzko.firstapp.domain.entity.Person>>() {
            @Override
            public void onNext(@NonNull List<Person> persons) {
                StringBuilder sb = new StringBuilder();
                for (Person one : persons) {
                    sb.append(one.getId()).append(". ").append(one.getName()).
                            append(" from ").append(one.getCountry().getName()).
                            append("\n");
                }
                activity.binding.allProfiles.setText(sb.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
