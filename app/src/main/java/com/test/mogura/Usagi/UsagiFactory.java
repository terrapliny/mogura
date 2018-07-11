package com.test.mogura.Usagi;

import android.app.Activity;
import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MoguraParam;

public class UsagiFactory extends Factory{

    protected Mogura createMogura(ImageView imageView){

        return new Usagi(
                MoguraParam.usagiScore,
                MoguraParam.usagiDuration,
                MoguraParam.usagiIdDrawable,
                MoguraParam.usagiIdAnimator,
                imageView
        );
    }

}
