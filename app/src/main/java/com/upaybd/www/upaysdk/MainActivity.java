package com.upaybd.www.upaysdk;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.upaybd.www.upay_sdk_lib.model.PurchaseRequestInfo;
import com.upaybd.www.upay_sdk_lib.listener.UpayListener;
import com.upaybd.www.upay_sdk_lib.builder.UpayWebBuilder;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements UpayListener {
    private static final String TOKEN = "b464ff4e3a2b1019ad4f3bbb625727a5cf279148c7c24a754c7ddcc9a6b3c1ae8ce9e9d58d138205955bb57535792f495645858964fd406c727b6c8d67c7e4ef ";
    private TextView txtStatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtStatus = findViewById(R.id.status);
    }

    @Override
    public void onSuccess(HashMap<String, String> values) {
        setValueToTextView(values);
    }


    @Override
    public void onFailure(HashMap<String,String> values) {
        setValueToTextView(values);
    }

    private void setValueToTextView(HashMap<String, String> values) {
        String message ="";
        for(String key: values.keySet()){
            String value = values.get(key);
            message =   message.concat( "KEY: "+key+" VALUE: "+value+" \n");
        }
        txtStatus.setText(message);
    }

    public void paymentOnclick(View view) {
        UpayWebBuilder upayWebBuilder = new UpayWebBuilder(this);
        upayWebBuilder.upayOnDeliveryRequest(true, new PurchaseRequestInfo(TOKEN,500),this);
    }
}
