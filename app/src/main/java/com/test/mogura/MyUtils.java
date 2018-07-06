package com.test.mogura;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MyUtils {
    protected static Toast toast;
    protected static int totalScore = 0;
    public static HashMap<Integer, Integer> idMap = new HashMap<Integer, Integer>(){
        {
            put(R.id.mogura_1, R.id.explode_1);
            put(R.id.mogura_2, R.id.explode_2);
            put(R.id.mogura_3, R.id.explode_3);
            put(R.id.mogura_4, R.id.explode_4);
            put(R.id.mogura_5, R.id.explode_5);
            put(R.id.mogura_6, R.id.explode_6);
            put(R.id.mogura_7, R.id.explode_7);
            put(R.id.mogura_8, R.id.explode_8);
            put(R.id.mogura_9, R.id.explode_9);
        }
    };


    public static void showToast(Context context, String text) {
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void addScore(int score){
        totalScore += score;
    }

    public static int getScore(){
        return totalScore;
    }

    public static void clearScore(){
        totalScore = 0;
    }

    public static void setScore(Activity activity){
        TextView tv = activity.findViewById(R.id.score);
        tv.setText(String.valueOf(totalScore) + "p");
    }

    public static void setTime(Activity activity, long time){
        TextView tv = activity.findViewById(R.id.time);
        tv.setText(String.valueOf(time) + "s");
    }
}
