package com.rudzko.firstapp.hw_3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rudzko.firstapp.BuildConfig;
import com.rudzko.firstapp.R;
import com.squareup.picasso.Picasso;



/**
 * @author Olga Rudzko
 */

public class hw3_Activity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw3);
        Button show=(Button)findViewById(R.id.button_show);
        final EditText input=(EditText)findViewById(R.id.link);
        final ImageView image=(ImageView)findViewById(R.id.picture);
        final TextView painter=(TextView)findViewById(R.id.painter);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=input.getText().toString();
                Picasso.with(hw3_Activity.this).load(link).transform(new RoundPicture()).into(image);
                painter.setText(BuildConfig.API_ENDPOINT);
            }
        });
    }

}
