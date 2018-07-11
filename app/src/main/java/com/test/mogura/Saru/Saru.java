package com.test.mogura.Saru;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MyUtils;
import com.test.mogura.R;

public class Saru extends Mogura {



    public Saru(int score, int duration, int IdDrawable, int IdAnimator, ImageView imageView){
        this.score = score;
        this.duration = duration;
        this.IdDrawable = IdDrawable;
        this.IdAnimator = IdAnimator;
        this.imageView = imageView;
    }


    @Override
    public void startMogura(final Activity ac, final ImageView iv){
        final Context context = ac.getApplicationContext();
        stickImage(imageView, context.getDrawable(IdDrawable));

        imageView.setVisibility(View.VISIBLE);

        setAnimator(ac);

        setOnclick(ac);

    }

    @Override
    protected void setAnimator(Activity activity){

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
            }
            @Override
            public void onAnimationCancel(Animator anim){}
            @Override
            public void onAnimationRepeat(Animator anim){}

        });
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

    @Override
    protected AnimatorSet setAnimatorSet(Context context){
        return (AnimatorSet) AnimatorInflater.loadAnimator(context,
                IdAnimator);
    }



}
