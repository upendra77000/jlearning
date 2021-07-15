package com.example.jlearning;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class unit3_quiz4 extends AppCompatActivity {

    private TextView question,qnoIndicator;
    private FloatingActionButton bookmarkbtn;
    private LinearLayout optioncontainer;
    private Button nextquestion;
    private int count=0;
    private List<QuestionModel> list;
    private int position=0;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_quiz4);

        question=(TextView)findViewById(R.id.questionView);
        qnoIndicator=(TextView)findViewById(R.id.qnoView);
        optioncontainer=(LinearLayout)findViewById(R.id.optionsLayout);
        nextquestion=(Button)findViewById(R.id.btnNext);

        list = new ArrayList<>();
        list.add(new QuestionModel("Java was originally developed by James Gosling at Sun Microsystems and released in ______","1991","1994","1995","1996","1995"));
        list.add(new QuestionModel("Which of the following is not a key concept of Object Oriented Programming language?","Polymorphism","Abstraction","Inheritance","Concurrency","Concurrency"));
        list.add(new QuestionModel("________ is the mechanism of hiding of data implementation by restricting access to public methods.","Data abstraction","Encapsulation","Inheritance","Polymorphism","Encapsulation"));
        list.add(new QuestionModel("Java uses __________","Compiler","Interpreter","both Compiler & Interpreter","None","both Compiler & Interpreter"));
        list.add(new QuestionModel("Which among the following describes Java?","Platform dependent language","Platform independent language","Platform co-dependent language","Requires Multiple platforms","Platform independent language"));
        list.add(new QuestionModel("JVM is a part of which of the following?","Java Run Time Environment (JRE)","Just InTime compiler","Java packages","Java Lang","Java Run Time Environment (JRE)"));
        list.add(new QuestionModel("What kind of files are formed by linker?",".class",".obj",".exe",".txt",".class"));
        list.add(new QuestionModel("_________ stores class structures like metadata, the constant runtime pool, and the code for methods.","Heap","Method Area","ClassLoader","PC Registers","Method Area"));
        list.add(new QuestionModel("Which of the following is not supported by Java?","method overloading","Multithreading","operater overloading","Interfaces","operater overloading"));
        list.add(new QuestionModel("Which of the following is not a Java features?","Dynamic","Architecture Neutral","Use of pointers","Object-oriented","Use of pointers"));
        for (int i=0;i<4;i++){
            optioncontainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    checkAnswer(((Button)v));
                }
            });
        }


        playAnime(question,0,list.get(position).getQuestion());
        nextquestion.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                nextquestion.setEnabled(false);
                nextquestion.setAlpha(0.7f);
                enableOption(true);
                position++;
                if(position == list.size()){
                    Intent scoreIntent = new Intent(unit3_quiz4.this,score.class);
                    scoreIntent.putExtra("score",score);
                    scoreIntent.putExtra("total",list.size());
                    startActivity(scoreIntent);
                    finish();
                    return;
                }
                count=0;
                playAnime(question,0,list.get(position).getQuestion());
            }
        });
    }

    private void playAnime(final View view, final int value, final String data) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(value == 0 && count<4){
                    String option="";
                    if(count == 0){
                        option = list.get(position).getOptionA();
                    }else if (count == 1){
                        option = list.get(position).getOptionB();
                    }else if (count == 2){
                        option = list.get(position).getOptionC();
                    }else if (count == 3){
                        option = list.get(position).getOptionD();
                    }
                    playAnime(optioncontainer.getChildAt(count),0,option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(value == 0){
                    try {
                        ((TextView)view).setText(data);
                        qnoIndicator.setText(position+1+"/"+list.size());
                    }catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    playAnime(view,1,data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkAnswer(Button selectedOption){
        enableOption(false);
        nextquestion.setEnabled(true);
        nextquestion.setAlpha(1);
        if(selectedOption.getText().toString().equals(list.get(position).getAnswer())){
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }else {
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            Button correctOption = (Button) optioncontainer.findViewWithTag(list.get(position).getAnswer());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void enableOption(boolean enable){
        for(int i=0;i<4;i++){
            optioncontainer.getChildAt(i).setEnabled(enable);
            if(enable){
                optioncontainer.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }
}
