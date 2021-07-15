package com.example.jlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class syllabus_activity extends AppCompatActivity {

    private Button next;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_activity);

        firebaseAuth = FirebaseAuth.getInstance();
        next=(Button)findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(syllabus_activity.this,contentActivity.class));
            }
        });
        String url = "file:////android_asset/syllabus.html";
        WebView view = (WebView)this.findViewById(R.id.webView);
        view.setBackgroundColor(Color.TRANSPARENT);
        view.loadUrl(url);
        view.setWebViewClient(new Myfile());
    }
    private class Myfile extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(syllabus_activity.this,MainActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}