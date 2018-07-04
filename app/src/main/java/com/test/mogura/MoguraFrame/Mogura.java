package com.test.mogura.MoguraFrame;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;

public abstract class Mogura {
    private int score;
    private int speed;
    private int duration;
    private Drawable image;
    private ImageView imageView;

    public void stickImage(ImageView iv, Drawable d){
        image = d;
        imageView = iv;
        imageView.setImageDrawable(image);
    };

    public void removeImage(ImageView imageView){
        imageView.setImageDrawable(null);
    };
    public abstract void startMogura(Context context, ImageView imageView);

    protected abstract void suplyScore();

    protected abstract void setImage(Drawable image);

    protected abstract void setImageView(ImageView imageView);

    protected abstract void setAnim(Animation animation);
}
