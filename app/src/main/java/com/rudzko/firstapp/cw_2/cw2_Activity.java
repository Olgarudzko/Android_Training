package com.rudzko.firstapp.cw_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.main.MainActivity;

/**
 * @author Olga Rudzko
 */

public class cw2_Activity extends Activity {

    private int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw2);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_got = name.getText().toString();
                if (!(name_got.trim().equals(""))) {
                    Intent intent = new Intent(cw2_Activity.this, MainActivity.class);
                    intent.putExtra(MainActivity.KEY_USERNAME, name.getText().toString());
                    intent.putExtra(MainActivity.KEY_PASSWORD, password.getText().toString());
                    startActivity(intent);
                } else {
                    StringBuilder sb =new StringBuilder(getString(R.string.type_name));
                    for (int y = 0; y <i ; y++) {
                        sb.append('!');
                    }
                    i++;
                    name.setHint(sb.toString());
                }
            }
        });
    }

}
