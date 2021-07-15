package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contentActivity extends AppCompatActivity {

    private Button unit1;
    private Button unit2;
    private Button unit3;
    private Button unit4;
    private Button unit5;
    private Button unit6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        unit1=(Button) findViewById(R.id.btnUnit1);
        unit2=(Button) findViewById(R.id.btnUnit2);
        unit3=(Button) findViewById(R.id.btnUnit3);
        unit4=(Button) findViewById(R.id.btnUnit4);
        unit5=(Button) findViewById(R.id.btnUnit5);
        unit6=(Button) findViewById(R.id.btnUnit6);

        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit1_activity.class));
            }
        });

        unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit2_activity.class));

            }
        });

        unit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit3_activity.class));

            }
        });

        unit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit4_activity.class));

            }
        });

        unit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit5_activity.class));

            }
        });

        unit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contentActivity.this,unit6_activity.class));

            }
        });
    }
}
