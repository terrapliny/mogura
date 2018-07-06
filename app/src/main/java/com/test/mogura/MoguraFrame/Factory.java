package com.test.mogura.MoguraFrame;

import android.widget.ImageView;

public abstract class Factory {

    public final Mogura create(ImageView imageView){
        Mogura mogura = createMogura(imageView);
        return mogura;
    }
    protected abstract Mogura createMogura(ImageView imageView);
//    protected abstract Mogura registerMogura();
}
