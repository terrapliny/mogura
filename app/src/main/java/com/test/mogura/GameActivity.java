package com.test.mogura;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.test.mogura.ItemSaru.ItemSaruFactory;
import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.Saru.RareSaruFactory;
import com.test.mogura.Saru.SaruFactory;
import com.test.mogura.Usagi.UsagiFactory;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final int stageTime = 31000;
    final int intervalTime = 250;
    final int randomIntervalTime = 1500;
    final int rareProbability = 40;
    final Activity gameActivity = this;

    public static boolean feverTime = false;



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



//        FrameLayout frameLayout1 = findViewById(R.id.b);
//
//        View V1 = this.getLayoutInflater().inflate(R.layout.treasure, null);
//        MyUtils.addView(frameLayout1,V1);

//        period = 1000;
        final Random rand = new Random();

        for (ImageView iv:saru) {
            iv.setVisibility(View.GONE);
        }

        new CountDownTimer(stageTime, intervalTime) {

            public void onTick(long millisUntilFinished) {
                int bound = (int) millisUntilFinished/10;
                if (bound <1) bound = 1;  //bound はpositiveでないといけない。
                final int period = (int) rand.nextInt(bound);
                MyUtils.setTime(gameActivity, millisUntilFinished/1000);

                new CountDownTimer(period, period) {
                    public void onTick(long millisUntilFinished) { }
                    public void onFinish() {
                        int pos = (int) rand.nextInt(saru.length) ;
                        int loopCnt = 0;
                        while(true){
                            if(saru[pos].getVisibility() == View.GONE) {
                                if(period%rareProbability < 8) startNewUsagi(saru[pos]);
                                else if(period%rareProbability >= 8 && period%rareProbability <= 10) startNewRareSaru(saru[pos]);
                                else if(period%rareProbability == 20) startNewItemSaru(saru[pos]);
                                else startNewSaru(saru[pos]);
                                break;
                            }else{
                                pos = (int) rand.nextInt(saru.length) ;
                                //whileから必ず抜けれるように
                                if(loopCnt >= 15) break;
                                loopCnt++;
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
        Mogura mogura = saruFactory.create(iv);
        mogura.startMogura(this, iv);
    }

    public void startNewRareSaru(ImageView iv){
        Factory rareSaruFactory = new RareSaruFactory();
        Mogura mogura = rareSaruFactory .create(iv);
        mogura.startMogura(this, iv);
    }

    public void startNewUsagi(ImageView iv){
        Factory usagiFactory = new UsagiFactory();
        Mogura mogura = usagiFactory.create(iv);
        mogura.startMogura(this, iv);
    }

    public void startNewItemSaru(ImageView iv){
        Factory itemSaruFactory = new ItemSaruFactory();
        Mogura mogura = itemSaruFactory.create(iv);
        mogura.startMogura(this, iv);
    }

    @Override
    public void onBackPressed() {
        MyUtils.clearScore();
        super.onBackPressed();
    }

}
