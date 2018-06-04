package com.upaybd.www.upay_sdk_lib.builder;

import android.content.Context;
import android.content.Intent;

import com.upaybd.www.upay_sdk_lib.listener.UpayListener;
import com.upaybd.www.upay_sdk_lib.activity.UpayWebActivity;
import com.upaybd.www.upay_sdk_lib.Utils.Constant;
import com.upaybd.www.upay_sdk_lib.model.PurchaseRequestInfo;

public class UpayWebBuilder {
    private static UpayListener listener;
    private static PurchaseRequestInfo purchaseInfo;
    private Context context;
    private static String requestURL;

    /**
     * Constructor
     *
     * @param  context
     **/
    public UpayWebBuilder(Context context) {
        this.context = context;
    }

    /** This method is use to send a upay on delivery request from the client side.
     *  @param  sandBoxMode - boolean , true means sanbox or test mode is enable , false means production environment.
     *  @param  purchaseRequestInfo -  Object, takes two parameters from client side , @param TOKEN for verify the client  & @param Amount for purchase.
     *  @param  upayListener - Interface,  responsible  for   success & failure callback.
     * **/
    public void upayOnDeliveryRequest(boolean sandBoxMode, PurchaseRequestInfo purchaseRequestInfo, UpayListener upayListener) {
        setUpayListener(upayListener);
        setPurchaseInformation(purchaseRequestInfo);
        setRequestURL(sandBoxMode);
        startWebViewActivity();
    }


    private void setPurchaseInformation(PurchaseRequestInfo purchaseRequestInfo) {
        purchaseInfo = purchaseRequestInfo;
    }

    public static PurchaseRequestInfo getPurchaseInformation() {
        return purchaseInfo;
    }

    private void startWebViewActivity() {
        if (listener != null) {
            /** Start Web View Here **/
            Intent intent = new Intent(context, UpayWebActivity.class);
            context.startActivity(intent);
        }
    }


    private void setUpayListener(UpayListener upayListener) {
        listener = upayListener;
    }

    public static UpayListener getUpayListener() {
        return listener;
    }

    private void setRequestURL(boolean sanboxMode) {
        if (sanboxMode) {
            requestURL = Constant.UAT_URL;
        } else {
            requestURL = Constant.PRODUCTION_URL;
        }
    }

    public static String getRequestURL() {
        return requestURL;
    }

}
