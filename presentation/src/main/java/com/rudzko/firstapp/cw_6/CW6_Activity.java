package com.rudzko.firstapp.cw_6;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rudzko.firstapp.R;

import java.util.ArrayList;

/**
 * @author Olga Rudzko
 */

public class CW6_Activity extends Activity {

    private String[] words = {"dream", "fire", "friend", "fun", "moon",
            "night", "sky", "star", "think", "wind"};
    private ArrayList<Drawable> characters = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw6);
        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager lM = new LinearLayoutManager(this);
        rv.setLayoutManager(lM);

        characters.add(getDrawable(R.drawable.dream));
        characters.add(getDrawable(R.drawable.fire));
        characters.add(getDrawable(R.drawable.friend));
        characters.add(getDrawable(R.drawable.fun));
        characters.add(getDrawable(R.drawable.moon));
        characters.add(getDrawable(R.drawable.night));
        characters.add(getDrawable(R.drawable.sky));
        characters.add(getDrawable(R.drawable.star));
        characters.add(getDrawable(R.drawable.think));
        characters.add(getDrawable(R.drawable.wind));

        MyAdapter adapter = new MyAdapter(words, characters);
        rv.setAdapter(adapter);
        adapter.setListener(new MyAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(String item) {
                onBackPressed();
                //action
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
