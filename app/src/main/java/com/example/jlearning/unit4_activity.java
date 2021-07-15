package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class unit4_activity extends AppCompatActivity {

    private Button mult;
    private Button frame;
    private Button gotoquiz1;
    private Button gotoquiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit4_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        mult=(Button)findViewById(R.id.Button5);
        frame=(Button)findViewById(R.id.Button6);
        gotoquiz1=(Button)findViewById(R.id.btnQuiz);
        gotoquiz2=(Button)findViewById(R.id.btnQuiz1);

        topicstyle.buttonEffect(mult);
        topicstyle.buttonEffect(frame);

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit4_activity.this,unit4_content.class));
            }
        });

        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit4_activity.this,unit4_content1.class));
            }
        });
    }
}
