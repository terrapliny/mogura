package com.test.mogura.Saru;

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
        this.mSet = MyUtils.setNormalAnimator(activity, imageView, IdAnimator, duration);
    }

    @Override
    protected void setOnclick(final Activity activity){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUtils.addScore(score);
                MyUtils.setScore(activity);

                v.setVisibility(View.GONE);
                final ImageView iv = activity.findViewById(MyUtils.idMap.get(v.getId()));
                iv.setVisibility(View.VISIBLE);
                MyUtils.setNormalAnimator(activity, iv, R.animator.explode_anim);
                if(mSet != null) mSet.cancel();
            }

        });
    }




}
