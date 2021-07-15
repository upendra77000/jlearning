package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class unit1_activity extends AppCompatActivity {

    private Button gotoquiz,gotoquiz2,oop,progcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        oop=(Button)findViewById(R.id.Button2);
        progcon=(Button)findViewById(R.id.Button3);
        gotoquiz=(Button)findViewById(R.id.btnQuiz);
        gotoquiz2=(Button)findViewById(R.id.btnQuiz2);

        topicstyle.buttonEffect(oop);
        topicstyle.buttonEffect(progcon);

        gotoquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit1_activity.this,unit1quiz.class));
            }
        });

        gotoquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit1_activity.this,unit1_quiz2.class));
            }
        });

        oop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit1_activity.this,unit1_content.class));
            }
        });

        progcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit1_activity.this,unit1_content1.class));
            }
        });
    }
}
