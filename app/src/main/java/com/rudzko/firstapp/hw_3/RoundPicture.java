package com.rudzko.firstapp.hw_3;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * @author Olga Rudzko
 */

public class RoundPicture implements Transformation {
    @Override
    public Bitmap transform(Bitmap round) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader bs=new BitmapShader(round, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bs);

        final Bitmap result = Bitmap.createBitmap(round.getWidth(), round.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(result);
        canvas.drawCircle(round.getWidth() / 2, round.getHeight() / 2, round.getWidth() / 2, paint);

        if (round != result)
            round.recycle();

        return result;
    }

    @Override
    public String key() {
        return "round";
    }
}
