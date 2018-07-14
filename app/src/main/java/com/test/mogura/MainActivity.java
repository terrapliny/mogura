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

//        AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                // USAGE_MEDIA
//                // USAGE_GAME
//                .setUsage(AudioAttributes.USAGE_GAME)
//                // CONTENT_TYPE_MUSIC
//                // CONTENT_TYPE_SPEECH, etc.
//                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
//                .build();
//
//        SoundPool soundPool = new SoundPool.Builder()
//                .setAudioAttributes(audioAttributes)
//                // ストリーム数に応じて
//                .setMaxStreams(2)
//                .build();
//        // one.wav をロードしておく
//        int soundOne = soundPool.load(this, R.raw.one, 1);
//
//        // two.wav をロードしておく
//        int soundTwo = soundPool.load(this, R.raw.two, 1);
//
//        soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);


        // assetsのファイルをオープン
//        try {
//            AssetFileDescriptor afdescripter = getAssets().openFd("game_maoudamashii_5_village08.mp3");
//
//// MediaPlayer のインスタンス生成
//            MediaPlayer mediaPlayer = new MediaPlayer();
//
//// 音楽ファイルをmediaplayerに設定
//            mediaPlayer.setDataSource(afdescripter.getFileDescriptor(),
//                    afdescripter.getStartOffset(), afdescripter.getLength());
//
//// 再生準備、再生可能状態になるまでブロック
//            mediaPlayer.prepare();
//
//// 再生開始
//            mediaPlayer.start();
//        }catch (Exception e){
//
//        }
    }

    public void onGameStart(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
