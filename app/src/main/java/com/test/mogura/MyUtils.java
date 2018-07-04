package com.test.mogura;

import android.content.Context;
import android.widget.Toast;

public class MyUtils {
    private static Toast toast;

    public static void showToast(Context context, String text) {
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
