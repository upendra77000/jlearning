package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class unit5_activity extends AppCompatActivity {

    private Button appl;
    private Button evhan;
    private Button gotoquiz1;
    private Button gotoquiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit5_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        appl=(Button)findViewById(R.id.Button7);
        evhan=(Button)findViewById(R.id.Button8);
        gotoquiz1=(Button)findViewById(R.id.btnQuiz);
        gotoquiz1=(Button)findViewById(R.id.btnQuiz1);

        topicstyle.buttonEffect(appl);
        topicstyle.buttonEffect(evhan);

        appl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit5_activity.this,unit5_content.class));
            }
        });

        evhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit5_activity.this,unit5_content1.class));
            }
        });
    }
}
