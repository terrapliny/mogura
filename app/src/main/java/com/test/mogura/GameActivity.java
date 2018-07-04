package com.test.mogura;

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

//    int period;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final ImageView saru[] = {
                findViewById(R.id.mogura_4), 
                findViewById(R.id.mogura_5),
                findViewById(R.id.mogura_6)
        };
        final int stageTime = 30000;
        final int interval = 1000;
        final int totalSaru = 3;
        
//        period = 1000;
        final Random rand = new Random();

        for (ImageView iv:saru) {
            iv.setVisibility(View.GONE);
        }

        new CountDownTimer(stageTime, interval) {

            public void onTick(long millisUntilFinished) {
                int period = (int) rand.nextInt(2000) ;

                new CountDownTimer(period, period) {
                    public void onTick(long millisUntilFinished) { }
                    public void onFinish() {
                        int pos = (int) rand.nextInt(totalSaru) ;
                        if(saru[pos].getVisibility() == View.GONE)
                            startNewSaru(saru[pos]);
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

    }

}
