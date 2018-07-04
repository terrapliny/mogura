package com.test.mogura;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.Saru.SaruFactory;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int period;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Handler handler = new Handler();
        final ImageView saru = findViewById(R.id.mogura_5);

        period = 1000;
        final Random rand = new Random();


        saru.setVisibility(View.GONE);
        new CountDownTimer(30000, 3000) {

            public void onTick(long millisUntilFinished) {
//                saru.setImageDrawable(null);
                period = (int) rand.nextInt(3000) ;
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
