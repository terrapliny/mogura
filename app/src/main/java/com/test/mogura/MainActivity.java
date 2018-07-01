package com.test.mogura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView saru = findViewById(R.id.mogura_5);
        saru.startAnimation(AnimationUtils.loadAnimation(this, R.anim.up_down_anim));
    }

    @Override
    public void onBackPressed() {

    }
}
