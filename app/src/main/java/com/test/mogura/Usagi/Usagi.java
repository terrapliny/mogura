package com.test.mogura.Usagi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.test.mogura.MoguraParam;
import com.test.mogura.MyUtils;
import com.test.mogura.R;
import com.test.mogura.Saru.Saru;

import java.util.Random;

public class Usagi extends Saru {
    protected int score;
    protected int duration;
    protected int IdDrawable;
    protected int IdAnimator;
    protected ImageView imageView;


    Usagi(int score, int duration, int IdDrawable, int IdAnimator, ImageView imageView){
        super(score, duration, IdDrawable, IdAnimator, imageView);
        this.score = score;
        this.duration = duration;
        this.IdDrawable = IdDrawable;
        this.IdAnimator = IdAnimator;
        this.imageView = imageView;
    }

    @Override
    public void startMogura(final Activity ac, final ImageView iv){
        super.startMogura(ac, iv);
//        MyUtils.addView((FrameLayout)imageView.getParent(), (View)ac.getLayoutInflater().inflate(R.layout.treasure, null));

    }

    @Override
    protected void setAnimator(final Activity activity){

        AnimatorSet set = setAnimatorSet(activity.getApplicationContext());
        set.setDuration(duration);
        set.setTarget(imageView);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator anim){}
            @Override
            public void onAnimationEnd(Animator anim){
                imageView.setVisibility(View.GONE);
                Random rand = new Random();
                if( rand.nextInt(MoguraParam.usagiNinjinprobability) == 1)
                    MyUtils.addView((FrameLayout)imageView.getParent(), (View)activity.getLayoutInflater().inflate(R.layout.treasure, null));
            }
            @Override
            public void onAnimationCancel(Animator anim){}
            @Override
            public void onAnimationRepeat(Animator anim){}

        });
    }

}
