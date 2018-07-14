package com.test.mogura.Usagi;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MoguraParam;
import com.test.mogura.MyUtils;
import com.test.mogura.R;

import java.util.Random;

public class Usagi extends Mogura {

    Usagi(int score, int duration, int IdDrawable, int IdAnimator, ImageView imageView){
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
    protected void setAnimator(final Activity activity){

        this.mSet = (AnimatorSet) AnimatorInflater.loadAnimator(activity.getApplicationContext(), IdAnimator);
        mSet.setDuration(duration);
        mSet.setTarget(imageView);
        mSet.start();
        mSet.addListener(new Animator.AnimatorListener() {
            boolean touchFlag = false;

            @Override
            public void onAnimationStart(Animator anim){}
            @Override
            public void onAnimationEnd(Animator anim){
                imageView.setVisibility(View.GONE);
                Random rand = new Random();
                if( rand.nextInt(MoguraParam.usagiNinjinProbability) == 0 && touchFlag == false){
                    final View v = (View)activity.getLayoutInflater().inflate(R.layout.treasure, null);
                    MyUtils.setNormalAnimator(activity, v, R.animator.up_animator);
                    MyUtils.addView((FrameLayout)imageView.getParent(), v);
                    MyUtils.addScore(MoguraParam.usagiNinjinScore);
                    MyUtils.setScore(activity);
                }
            }
            @Override
            public void onAnimationCancel(Animator anim){
                touchFlag = true;
            }
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

                View iv = (View)activity.getLayoutInflater().inflate(R.layout.cry, null);
                MyUtils.addView((FrameLayout)imageView.getParent(), iv);

                v.setVisibility(View.GONE);
                MyUtils.setNormalAnimator(activity, iv, R.animator.explode_anim);
                if(mSet != null) mSet.cancel();
            }

        });
    }

}
