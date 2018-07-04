package com.test.mogura.MoguraFrame;

public abstract class Factory {
    public final Mogura create(){
        Mogura mogura = createMogura();
        return mogura;
    }
    protected abstract Mogura createMogura();
//    protected abstract Mogura registerMogura();
}
