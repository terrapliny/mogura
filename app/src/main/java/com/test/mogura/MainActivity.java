package com.test.mogura;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.Saru.SaruFactory;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    boolean wait = false;
int period;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();
        final ImageView saru = findViewById(R.id.mogura_5);

        final Timer timer = new Timer();
        Timer timer2 = new Timer();
        period = 1000;
        final Random rand = new Random();

//        timer2.scheduleAtFixedRate(
//                new TimerTask() {
//                    @Override
//                    public void run() {
//                        timer.scheduleAtFixedRate(
//                                new TimerTask() {
//                                    @Override
//                                    public void run() {
//                                        startNewSaru(saru);
//                                        period = (int) rand.nextInt(2000) + 200;
//                                    }
//                                }, period, period);
//                    }
//                    }, period, period);
saru.setVisibility(View.GONE);
        new CountDownTimer(30000, 500) {

            public void onTick(long millisUntilFinished) {
//                saru.setImageDrawable(null);
                period = (int) rand.nextInt(2000) + 200;
                new CountDownTimer(period, period) {
                    public void onTick(long millisUntilFinished) { }
                    public void onFinish() {
                        if(saru.getVisibility() == View.GONE)
                            startNewSaru(saru);
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
