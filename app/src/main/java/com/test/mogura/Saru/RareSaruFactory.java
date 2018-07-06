package com.test.mogura.Saru;

import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MoguraParam;

public class RareSaruFactory extends Factory {
    protected Mogura createMogura(ImageView imageView){
        return new Saru(
                MoguraParam.rareSaruScore,
                MoguraParam.rareSaruDuration,
                MoguraParam.rareSaruIdDrawable,
                MoguraParam.rareSaruIdAnimator,
                imageView
        );
    }
}
