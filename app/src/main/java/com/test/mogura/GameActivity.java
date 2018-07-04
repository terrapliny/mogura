package com.test.mogura;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.Saru.SaruFactory;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final int stageTime = 30000;
    final int intervalTime = 250;
    final int randomIntervalTime = 1500;
    final Activity gameActivity = this;




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



//        period = 1000;
        final Random rand = new Random();

        for (ImageView iv:saru) {
            iv.setVisibility(View.GONE);
        }

        new CountDownTimer(stageTime, intervalTime) {

            public void onTick(long millisUntilFinished) {
                int period = (int) rand.nextInt((int)millisUntilFinished/10) ;
                MyUtils.setTime(gameActivity, millisUntilFinished/1000);

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



    @Override
    public void onBackPressed() {
        MyUtils.clearScore();
        super.onBackPressed();
    }

}
