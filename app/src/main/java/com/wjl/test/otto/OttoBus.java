package com.wjl.test.otto;

import com.squareup.otto.Bus;

/**
 * author: WuJinLi
 * time  : 2018/12/18
 * desc  :
 */
public class OttoBus {


    private static Bus instance = null;

    private OttoBus() {
    }


    public static Bus getInstance() {
        synchronized (OttoBus.class) {
            if (instance == null) {
                synchronized (OttoBus.class) {
                    if (instance == null) {
                        instance = new Bus();
                    }
                }
            }
        }

        return instance;
    }
}
