package com.rudzko.firstapp.cw_16;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rudzko.firstapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;

/**
 * @author Olga Rudzko
 */

public class CW16_Activity extends FragmentActivity {

    private Realm realm;

    @BindView(R.id.cw16_edit)
    public EditText editText;
    @BindView(R.id.cw16_save)
    public Button button;

    private UserDB user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw16);
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getDefaultInstance();
        loadData();
    }

    private void loadData() {

        //RealmResult<UserDB>=realm.where(UserDB.class).findAll();
        user = realm.where(UserDB.class).equalTo("id", 12).findFirst();
        if (user != null) {
            editText.setText(user.getName());
        }
        user.addChangeListener(new RealmChangeListener<RealmModel>() {
            @Override
            public void onChange(RealmModel realmModel) {
                editText.setText(user.getName());
            }
        });
    }

    private void saveData() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //to execute this code in new thread
            }
        });

        if (user == null) {
            user=new UserDB();
            realm.beginTransaction();
            user.setId(12);
            user=realm.copyToRealmOrUpdate(user);
//            user = realm.createObject(UserDB.class, new UserDB());
//            realm.beginTransaction();
            realm.commitTransaction();
        }
        realm.beginTransaction();
        user.setName(String.valueOf(editText.getText()));
        realm.commitTransaction();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (user!=null) user.removeAllChangeListeners();
        realm.close();
    }

}
