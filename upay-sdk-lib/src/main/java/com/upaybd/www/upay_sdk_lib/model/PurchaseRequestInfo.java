package com.upaybd.www.upay_sdk_lib.model;

public final class PurchaseRequestInfo {
    private String authToken;
    private int amount;

    public PurchaseRequestInfo(String authToken, int amount){
        this.authToken = authToken ;
        this.amount = amount;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
