package com.rudzko.firstapp.hw_7;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.rudzko.firstapp.R;
import com.rudzko.firstapp.databinding.ActivityHw7Binding;

/**
 * @author Olga Rudzko
 */

public class HW7_Activity extends Activity {

    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityHw7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_hw7);
        final User person = new User("https://goo.gl/M9jDLb", 1989, "Victoria Azarenka", false);
        binding.setUser(person);
        super.onCreate(savedInstanceState);
        final ImageView iv = (ImageView) findViewById(R.id.next);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setPhoto("https://goo.gl/D9mkJo");
                person.setName("Maxim Mirny");
                person.setBirthYear(1977);
                person.setMale(true);
                iv.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

//    @BindingAdapter({"bind:photo", "bind:listener"})
//    public static void addPhoto(ImageView view, String link, final ProgressBar prbar) {
//        Glide.with(view.getContext()).load(link).listener(new RequestListener<String, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                prbar.setVisibility(View.GONE);
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                prbar.setVisibility(View.GONE);
//                return false;
//            }
//        }).into(view);
//    }

    @BindingAdapter({"bind:photo"})
    public static void addPhoto(ImageView view, String link) {
        Glide.with(view.getContext()).load(link).into(view);
    }
}
