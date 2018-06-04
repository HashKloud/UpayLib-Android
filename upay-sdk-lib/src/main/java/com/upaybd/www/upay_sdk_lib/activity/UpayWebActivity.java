package com.upaybd.www.upay_sdk_lib.activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.upaybd.www.upay_sdk_lib.R;
import com.upaybd.www.upay_sdk_lib.Utils.Constant;
import com.upaybd.www.upay_sdk_lib.Utils.Utils;
import com.upaybd.www.upay_sdk_lib.builder.UpayWebBuilder;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import im.delight.android.webview.AdvancedWebView;

public final class UpayWebActivity extends AppCompatActivity implements AdvancedWebView.Listener {
    private AdvancedWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upay_web);
        openWebView();
    }

    private void openWebView() {
        mWebView = findViewById(R.id.webview);
        mWebView.setListener(this, this);
        try {
            String postData = "auth_token=" + URLEncoder.encode(UpayWebBuilder.getPurchaseInformation().getAuthToken(), "UTF-8")
                    + "&amount=" + URLEncoder.encode(String.valueOf(UpayWebBuilder.getPurchaseInformation().getAmount()), "UTF-8")
                    + "&cancel_url=" + URLEncoder.encode(Constant.CANCEL_URL, "UTF-8")
                    + "&success_url=" + URLEncoder.encode(Constant.SUCCESS_URL, "UTF-8");
            mWebView.postUrl(UpayWebBuilder.getRequestURL(), postData.getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        if (url.contains(Constant.SUCCESS_URL)) {
            if (UpayWebBuilder.getUpayListener() != null) {
                //  UpayWebBuilder.getUpayListener().onSuccess(processSuccessValues(url));
                try {
                    URL successURL = new URL(url);
                    UpayWebBuilder.getUpayListener().onSuccess(Utils.splitQuery(successURL));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            finish();
        }
        if (url.contains(Constant.CANCEL_URL)) {
            if (UpayWebBuilder.getUpayListener() != null) {
                try {
                    URL cancelURL = new URL(url);
                    UpayWebBuilder.getUpayListener().onFailure(Utils.splitQuery(cancelURL));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                finish();
            }
        }
    }


    /*  private HashMap<String,String> processSuccessValues(String url){

      }*/
    @Override
    public void onPageFinished(String url) {
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }
}
