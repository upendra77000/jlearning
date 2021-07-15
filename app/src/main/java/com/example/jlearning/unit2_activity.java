package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class unit2_activity extends AppCompatActivity {

    private Button clobj;
    private Button gotoquiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        clobj=(Button)findViewById(R.id.Button4);
        gotoquiz=(Button)findViewById(R.id.btnQuiz);
        topicstyle.buttonEffect(clobj);
        gotoquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit2_activity.this,unit2_quiz.class));
            }
        });

        clobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit2_activity.this,unit2_content.class));
            }
        });
    }

}
