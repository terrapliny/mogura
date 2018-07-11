package com.test.mogura.MoguraFrame;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public abstract class Mogura {
    protected int score;
    protected int duration;
    protected int IdDrawable;
    protected int IdAnimator;
    protected ImageView imageView;

    public void stickImage(ImageView iv, Drawable d){
        Drawable image = d;
        imageView = iv;
        imageView.setImageDrawable(image);
    };


    protected abstract void setAnimator(final Activity activity);

    protected abstract void setOnclick(final Activity activity);

    public abstract void startMogura(Activity activity, ImageView imageView);

    protected abstract AnimatorSet setAnimatorSet(Context context);
}
