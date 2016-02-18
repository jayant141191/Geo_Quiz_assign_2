package com.example.jayant.geo_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jayant on 2/17/2016.
 */
public class ScoreActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textView = (TextView)findViewById(R.id.tvScore);
        button= (Button)findViewById(R.id.btRes);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Correct Ans:"+MainActivity.correct);
        stringBuffer.append(" Wrong ans:"+MainActivity.wrong);
        stringBuffer.append(" Final Score:"+MainActivity.marks);
        textView.setText(stringBuffer);

        MainActivity.correct = 0;
        MainActivity.wrong = 0;
        MainActivity.marks =0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}

