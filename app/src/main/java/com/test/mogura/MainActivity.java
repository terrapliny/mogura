package com.test.mogura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        MyUtils.setFont(this, (TextView) findViewById(R.id.main_title), R.string.font_ksosyo);
        MyUtils.setFont(this, (TextView) findViewById(R.id.scoreTable), R.string.font_ksosyo);
        MyUtils.setFont(this, (TextView) findViewById(R.id.buttonText), R.string.font_ksosyo);
    }

    public void onGameStart(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
