package com.test.mogura;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.Saru.SaruFactory;

import java.util.HashMap;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final int stageTime = 30000;
    final int intervalTime = 1000;
    final int randomIntervalTime = 2000;

    private HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>(){};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final ImageView saru[] = {
                findViewById(R.id.mogura_1),
                findViewById(R.id.mogura_2),
                findViewById(R.id.mogura_3),
                findViewById(R.id.mogura_4),
                findViewById(R.id.mogura_5),
                findViewById(R.id.mogura_6),
                findViewById(R.id.mogura_7),
                findViewById(R.id.mogura_8),
                findViewById(R.id.mogura_9)
        };

        hashmap.put(R.id.mogura_1, R.id.explode_1);
        hashmap.put(R.id.mogura_2, R.id.explode_2);
        hashmap.put(R.id.mogura_3, R.id.explode_3);
        hashmap.put(R.id.mogura_4, R.id.explode_4);
        hashmap.put(R.id.mogura_5, R.id.explode_5);
        hashmap.put(R.id.mogura_6, R.id.explode_6);
        hashmap.put(R.id.mogura_7, R.id.explode_7);
        hashmap.put(R.id.mogura_8, R.id.explode_8);
        hashmap.put(R.id.mogura_9, R.id.explode_9);

//        period = 1000;
        final Random rand = new Random();

        for (ImageView iv:saru) {
            iv.setVisibility(View.GONE);
        }

        new CountDownTimer(stageTime, intervalTime) {

            public void onTick(long millisUntilFinished) {
                int period = (int) rand.nextInt(randomIntervalTime) ;

                new CountDownTimer(period, period) {
                    public void onTick(long millisUntilFinished) { }
                    public void onFinish() {
                        int pos = (int) rand.nextInt(saru.length) ;
                        while(true){
                            if(saru[pos].getVisibility() == View.GONE) {
                                startNewSaru(saru[pos]);
                                break;
                            }else{
                                pos = (int) rand.nextInt(saru.length) ;
                            }
                        }
                    }
                }.start() ;
            }

            public void onFinish() { }
        }.start();

    }

    public void startNewSaru(ImageView iv){
        Factory saruFactory = new SaruFactory();
        Mogura mogura = saruFactory.create();
        mogura.startMogura(this, iv);
    }

    public void onExplode(View v){
        v.setVisibility(View.GONE);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.explode_anim);
        final ImageView iv = findViewById(hashmap.get(v.getId()));
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

    @Override
    public void onBackPressed() {

    }

}
