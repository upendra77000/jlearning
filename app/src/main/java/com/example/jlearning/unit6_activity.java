package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class unit6_activity extends AppCompatActivity {

    private Button awt;
    private Button swin;
    private Button gotoquiz1;
    private Button gotoquiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit6_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        awt=(Button)findViewById(R.id.Button9);
        swin=(Button)findViewById(R.id.Button10);
        gotoquiz1=(Button)findViewById(R.id.btnQuiz);
        gotoquiz2=(Button)findViewById(R.id.btnQuiz2);

        topicstyle.buttonEffect(awt);
        topicstyle.buttonEffect(swin);

        awt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit6_activity.this,unit6_content.class));
            }
        });

        swin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit6_activity.this,unit6_content1.class));
            }
        });

    }
}
