package com.test.mogura.Saru;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MyUtils;
import com.test.mogura.R;

public class Saru extends Mogura {
    private final int score = 10;
    private final int duration = 130;
    private Drawable image;
    private ImageView imageView;
    private Animation anim;
    private ObjectAnimator animator;

    Saru(){
    }

    @Override
    public void startMogura(final Activity activity, final ImageView imageView){
        final Context context = activity.getApplicationContext();
        setImage(context.getDrawable(R.drawable.ic_saru_mono));
        setImageView(imageView);
        stickImage(this.imageView, this.image);

        imageView.setVisibility(View.VISIBLE);

        setAnimator(context);

        setOnclick(activity);


    }

    private void setAnimator(Context context){

        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.up_down_animator);
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

    private void setOnclick(final Activity activity){
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
    protected void setImage(Drawable image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    protected void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void setAnim(Animation animation){
        this.anim = animation;
    }

    @Override
    protected void suplyScore(){

    };
}
