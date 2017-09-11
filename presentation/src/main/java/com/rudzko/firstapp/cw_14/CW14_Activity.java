package com.rudzko.firstapp.cw_14;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rudzko.firstapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Olga Rudzko
 */

public class CW14_Activity extends FragmentActivity {

    @BindView(R.id.cw14edit)
    EditText text;

    @BindView(R.id.cw14button)
    Button button;

    SharedPreferences preferences;
    public static final String SHARED_PRFR="SHARED";
    public static final String KEY_NAME="KEY_NAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw14);
        ButterKnife.bind(this);
        button.setText("Save");
        preferences=getSharedPreferences(SHARED_PRFR, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=text.getText().toString();
                preferences.edit().putString(KEY_NAME, s).apply();
            }
        });

        text.setText(preferences.getString(KEY_NAME, null));
    }
}
