package com.test.mogura.Saru;

import com.test.mogura.MoguraFrame.Factory;
import com.test.mogura.MoguraFrame.Mogura;

public class SaruFactory extends Factory {

    protected Mogura createMogura(){
        return new Saru();
    }

}
