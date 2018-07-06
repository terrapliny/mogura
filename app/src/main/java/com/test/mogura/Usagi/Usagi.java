package com.test.mogura.Usagi;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MyUtils;
import com.test.mogura.R;
import com.test.mogura.Saru.Saru;

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
        this.imageView = imageView;    }

    @Override
    public void startMogura(final Activity ac, final ImageView iv){
        super.startMogura(ac, iv);
    }

    @Override
    protected void setOnclick(final Activity activity){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUtils.addScore(score);
                MyUtils.setScore(activity);

                v.setVisibility(View.GONE);
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(activity.getApplicationContext(),
                        R.animator.explode_anim);
                final ImageView iv = activity.findViewById(MyUtils.idMap.get(v.getId()));

                iv.setVisibility(View.VISIBLE);
                set.setTarget(iv);
                set.start();
                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator anim){}
                    @Override
                    public void onAnimationEnd(Animator anim){
                        iv.setVisibility(View.GONE);
                    }
                    @Override
                    public void onAnimationCancel(Animator anim){}
                    @Override
                    public void onAnimationRepeat(Animator anim){}

                });
            }

        });
    }



}