package com.company;
//Test-and-Set
public final class TsUtil {
    public TsUtil(){ }
    public boolean TS(boolean lock){
        boolean old;
        old = lock;
        lock = true;
        return old;
    }
}
