package com.test.mogura.Saru;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.R;

public class Saru extends Mogura {
    private final int score = 10;
    private final int duration = 1000;
    private Drawable image;
    private ImageView imageView;
    private Animation anim;
    private ObjectAnimator animator;

    Saru(){
    }

    @Override
    public void startMogura(final Context context, final ImageView imageView){
        setImage(context.getDrawable(R.drawable.ic_saru_mono));
        setImageView(imageView);
        stickImage(this.imageView, this.image);

        imageView.setVisibility(View.VISIBLE);

        Animator animator;

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


//        anim = AnimationUtils.loadAnimation(context, R.anim.up_down_anim);
//        anim.setRepeatMode(Animation.REVERSE);
//        anim.setRepeatCount(1);
//        anim.setDuration(500);
//        AnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationEnd(final Animation animation) {
////                removeImage(imageView);
//                imageView.setVisibility(View.GONE);
//                MyUtils.showToast(context, "end");
//            }
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                try {
//                    anim.wait(500);
//                    MyUtils.showToast(context, "re");
//                }catch (Exception e){
//                    Log.e("", "onAnimationRepeat: ", e);
//                }
//            }
//            @Override
//            public void onAnimationStart(Animation animation) {
//                MyUtils.showToast(context, "start");
//            }
//        });
//
//        imageView.startAnimation(anim);

    }

//    private Animator moguraAnimator(View tar){
//
//    }

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
