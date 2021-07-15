package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class unit2_content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_content);

        String url = "file:////android_asset/classAobj.html";
        WebView view = (WebView)this.findViewById(R.id.webView);
        view.loadUrl(url);
        view.setWebViewClient(new unit2_content.Myfile());
    }
    private class Myfile extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
