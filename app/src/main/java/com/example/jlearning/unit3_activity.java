package com.example.jlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class unit3_activity extends AppCompatActivity {

    private Button inherit;
    private Button inter;
    private Button pack;
    private Button excep;
    private Button gotoquiz1;
    private Button gotoquiz2;
    private Button gotoquiz3;
    private Button gotoquiz4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_activity);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        inherit=(Button)findViewById(R.id.Button);
        inter=(Button)findViewById(R.id.Button2);
        pack=(Button)findViewById(R.id.Button3);
        excep=(Button)findViewById(R.id.Button4);
        gotoquiz1=(Button)findViewById(R.id.btnQuiz);
        gotoquiz2=(Button)findViewById(R.id.btnQuiz1);
        gotoquiz3=(Button)findViewById(R.id.btnQuiz2);
        gotoquiz4=(Button)findViewById(R.id.btnQuiz3);

        topicstyle.buttonEffect(inherit);
        topicstyle.buttonEffect(inter);
        topicstyle.buttonEffect(pack);
        topicstyle.buttonEffect(excep);

        inherit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_content.class));
            }
        });

        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_content2.class));
            }
        });

        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_content1.class));
            }
        });

        excep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_content3.class));
            }
        });

        gotoquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_quiz1.class));
            }
        });

        gotoquiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_quiz2.class));
            }
        });

        gotoquiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_quiz3.class));
            }
        });

        gotoquiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(unit3_activity.this,unit3_quiz4.class));
            }
        });
    }
}
