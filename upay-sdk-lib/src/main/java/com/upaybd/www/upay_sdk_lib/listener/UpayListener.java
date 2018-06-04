package com.upaybd.www.upay_sdk_lib.listener;

import java.util.HashMap;

public  interface UpayListener {
    void onSuccess(HashMap<String, String>values);
    void onFailure(HashMap<String, String>values);
}
