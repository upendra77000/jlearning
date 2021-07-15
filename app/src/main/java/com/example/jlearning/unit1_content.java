package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class unit1_content extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_content);

        String url = "file:////android_asset/needoop.html";
        WebView view = (WebView)this.findViewById(R.id.webView);
        view.loadUrl(url);
        view.setWebViewClient(new unit1_content.Myfile());
    }
    private class Myfile extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
