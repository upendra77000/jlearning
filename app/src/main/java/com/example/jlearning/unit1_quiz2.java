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


import java.util.ArrayList;
import java.util.List;

public class unit1_quiz2 extends AppCompatActivity {

    private TextView question,qnoIndicator;
    private LinearLayout optioncontainer;
    private Button nextquestion;
    private int count=0;
    private List<QuestionModel> list;
    private int position=0;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_quiz2);

        question=(TextView)findViewById(R.id.questionView);
        qnoIndicator=(TextView)findViewById(R.id.qnoView);
        optioncontainer=(LinearLayout)findViewById(R.id.optionsLayout);
        nextquestion=(Button)findViewById(R.id.btnNext);


        list = new ArrayList<>();
        list.add(new QuestionModel("What is the size in bits for a 'byte' data type.","8 bits","4 bits","16 bits","1 bit","8 bits"));
        list.add(new QuestionModel("What is the supported range for short data type.","-128 to 127","0 to 255","-32,768 to 32,767","0 to 65535","-32,768 to 32,767"));
        list.add(new QuestionModel("Which of these is long data type literal?","0x99fffL","ABCDEFG","0x99fffa","99671246","0x99fffL"));
        list.add(new QuestionModel("Which of these can not be used for a variable name in Java?","identifier","keyword","identifier & keyword","None","keyword"));
        list.add(new QuestionModel("What will be the output of the following Java program?\n" +
                "\n" +
                "    class variable_scope \n" +
                "    {\n" +
                "        public static void main(String args[]) \n" +
                "        {\n" +
                "            int x;\n" +
                "            x = 5;\n" +
                "            {\n" +
                "\t        int y = 6;\n" +
                "\t        System.out.print(x + \" \" + y);\n" +
                "            }\n" +
                "            System.out.println(x + \" \" + y);\n" +
                "        } \n" +
                "    }","5 6 5 6","5 6 5","Runtime error","Compilation error","Compilation error"));
        list.add(new QuestionModel("“123geeks” is a valid identifier or not?","Yes","No","Can't Say","None","No"));
        list.add(new QuestionModel("What is the incorrect statement about non-primitive data types or user-defined data types.","Non-primitive data types can be created using the primitive data types.","Non-primitive data types can contain only primitive data types. They can not contain other non-primitive/user-defined data types in them.","Non-primitive data types can contain both primitive data types and other non-primitive/user-defined data types.","None of the above","Non-primitive data types can contain only primitive data types. They can not contain other non-primitive/user-defined data types in them."));
        list.add(new QuestionModel(".What is the size in bits for an 'int' variable.","32 bits","4 bits","16 bits","8 bits","32 bits"));
        list.add(new QuestionModel("If the range of the values for a certain information is 100 to 500, which integer data type should we use.","byte","short","long","int","short"));
        list.add(new QuestionModel("What is the largest integer group data type?","byte","short","long","int","long"));
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
                    Intent scoreIntent = new Intent(unit1_quiz2.this,score.class);
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
