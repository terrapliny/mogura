package com.test.mogura.ItemSaru;

import android.widget.ImageView;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;
import com.test.mogura.MoguraParam;

public class ItemSaruFactory extends Factory{

    protected Mogura createMogura(ImageView imageView){

        return new ItemSaru(
                MoguraParam.itemSaruScore,
                MoguraParam.itemSaruDuration,
                MoguraParam.itemSaruIdDrawable,
                MoguraParam.itemSaruIdAnimator,
                imageView
        );
    }

}
