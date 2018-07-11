package com.test.mogura.Usagi;

import android.animation.Animator;
import android.animation.AnimatorInflater;
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

        this.mSet = (AnimatorSet) AnimatorInflater.loadAnimator(activity.getApplicationContext(), IdAnimator);
        mSet.setDuration(duration);
        mSet.setTarget(imageView);
        mSet.start();
        mSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator anim){}
            @Override
            public void onAnimationEnd(Animator anim){
                imageView.setVisibility(View.GONE);
                Random rand = new Random();
                if( rand.nextInt(MoguraParam.usagiNinjinProbability) == 1){
                    final View v = (View)activity.getLayoutInflater().inflate(R.layout.treasure, null);
                    MyUtils.setNormalAnimator(activity, v, R.animator.up_animator);
                    MyUtils.addView((FrameLayout)imageView.getParent(), v);
                    MyUtils.addScore(MoguraParam.usagiNinjinScore);
                    MyUtils.setScore(activity);
                }
            }
            @Override
            public void onAnimationCancel(Animator anim){
                MyUtils.showToast(activity.getApplicationContext(), "cansel");
            }
            @Override
            public void onAnimationRepeat(Animator anim){}

        });
    }

}
