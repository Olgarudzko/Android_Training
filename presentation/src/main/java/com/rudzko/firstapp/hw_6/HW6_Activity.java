package com.rudzko.firstapp.hw_6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rudzko.firstapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Olga Rudzko
 */

public class HW6_Activity extends Activity {

    private String[] url = {
            "https://goo.gl/te1raa",
            "https://goo.gl/f8ornD",
            "https://goo.gl/R1icCT",
            "https://goo.gl/eHVFHy",
            "https://goo.gl/KUWfKZ",
            "https://goo.gl/QPyJTk",
            "https://goo.gl/Sxks8V",
            "https://goo.gl/uGkP1z",
            "https://goo.gl/f8UZpc",
            "https://goo.gl/vvrpr5",
            "https://goo.gl/PfoNnZ",
            "https://goo.gl/rsZHxR",
            "https://goo.gl/caLaa6",
            "https://goo.gl/yuYiGf",
            "https://goo.gl/dUVUYZ"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw6);
        RecyclerView gallery = (RecyclerView) findViewById(R.id.gallery);
        gallery.setLayoutManager(new GridLayoutManager(this, 3));


//        Scanner urlReader;
//        String s="C:\\Users\\Leta\\AndroidStudioProjects\\Android_Training\\app\\src\\main\\java\\com\\rudzko\\firstapp\\hw_6\\url.txt";
//        try {
//            urlReader=new Scanner(new File(s));
//            int length=urlReader.nextInt();
//            url=new String[length];
//            for (int i=0; i<length; i++){
//                url[i]=urlReader.nextLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        gallery.setAdapter(new GalleryAdapter(url));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
