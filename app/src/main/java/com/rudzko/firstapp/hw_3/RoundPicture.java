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

class RoundPicture implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader bs=new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bs);

        final Bitmap result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(result);
        canvas.drawOval(0, 0, source.getWidth(), source.getHeight(), paint);

        if (source != result)
            source.recycle();

        return result;
    }

    @Override
    public String key() {
        return "roundPicture";
    }
}
