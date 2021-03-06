package com.test.mogura.Saru;

import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MoguraParam;

public class SaruFactory extends Factory {

    protected Mogura createMogura(ImageView imageView){
        return new Saru(
                MoguraParam.saruScore,
                MoguraParam.saruDuration,
                MoguraParam.saruIdDrawable,
                MoguraParam.saruIdAnimator,
                imageView
        );
    }

}
