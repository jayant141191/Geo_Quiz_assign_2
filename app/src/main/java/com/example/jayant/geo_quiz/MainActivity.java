package com.example.jayant.geo_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvQues;
    Button btNext;
    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,radioButton3;
    String ques[] = {"What is your name?","What is Texas A&M University,Kingsville?"};
    String ans[] = {"Jayant","University"};
    String options[] = {"Jayant","Sughan","Pratik","Place","University","Country"};

    int cnt = 0;
    public static int marks,correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQues = (TextView)findViewById(R.id.tvQues);
        btNext = (Button)findViewById(R.id.btNext);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);

        tvQues.setText(ques[cnt]);
        radioButton1.setText(options[0]);
        radioButton2.setText(options[1]);
        radioButton3.setText(options[2]);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton answer = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                String strans = answer.getText().toString();

                if(strans.equalsIgnoreCase(ans[cnt])){

                    correct++;
                }
                else
                {
                    wrong++;
                }
                cnt++;

                if(cnt < ques.length){
                    tvQues.setText(ques[cnt]);
                    radioButton1.setText(options[cnt*3]);
                    radioButton2.setText(options[(cnt*3)+1]);
                    radioButton3.setText(options[(cnt*3)+2]);
                }
                else{

                    marks = correct;

                    Intent i = new Intent(getApplicationContext(),ScoreActivity.class);
                    startActivity(i);
                }
            }
        });

    }



}
