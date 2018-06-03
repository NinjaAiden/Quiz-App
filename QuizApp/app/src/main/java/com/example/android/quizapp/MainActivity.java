package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }


    public int score;
    public String scoreTotal;
    boolean moogle, choco, cactuar;
    boolean three, save, gauge, goal;

    public void onClicked3D(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_threeD_7:
                if (checked)
                    three = true;
                break;
        }
    }

    public void onClickedName(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_final_saved:
                if (checked)
                    save = true;
                break;
        }
    }

    public void onClickedGoals(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_villain:
                if (checked)
                    goal = true;
                break;
        }
    }

    public void onClickedGauge(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_ATB:
                if (checked)
                    gauge = true;
                break;
        }
    }

    public void onCheckedChoc(View view) {
        CheckBox mascot2 = findViewById(R.id.cb_chocobo);

        if (mascot2.isChecked()) {
            choco = true;
        } else {
            choco = false;
        }
    }

    public void onCheckedMoogle(View view) {
        CheckBox mascot1 = findViewById(R.id.cb_moogle);

        if (mascot1.isChecked()) {
            moogle = true;
        } else {
            moogle = false;
        }
    }

    public void onCheckedCactuar(View view) {
        CheckBox mascot3 = findViewById(R.id.cb_cactuar);

        if (mascot3.isChecked()) {
            cactuar = true;
        } else {
            cactuar = false;
        }
    }

    public void submit() {
        EditText answerField = findViewById(R.id.tf_engineer);
        String answer = answerField.getText().toString();
        answer = answer.trim();

        if (answer.equalsIgnoreCase("cid")) {
            score++;
        }

        if (three) {
            score++;
        }
        if (save) {
            score++;
        }
        if (gauge) {
            score++;
        }
        if (goal) {
            score++;
        }

        if (moogle && choco && !cactuar) {
            score++;
        }

        submitAnswers(score);
    }

    public void resetChecks() {

        CheckBox mascot1 = findViewById(R.id.cb_moogle);
        CheckBox mascot2 = findViewById(R.id.cb_chocobo);
        CheckBox mascot3 = findViewById(R.id.cb_cactuar);
        RadioButton save = findViewById(R.id.rb_final_saved);
        RadioButton three = findViewById(R.id.rb_threeD_7);
        RadioButton villain = findViewById(R.id.rb_villain);
        RadioButton ATB = findViewById(R.id.rb_ATB);

        if (mascot1.isChecked()) {
            mascot1.toggle();
        }
        if (mascot2.isChecked()) {
            mascot2.toggle();
        }
        if (mascot3.isChecked()) {
            mascot3.toggle();
        }
        if (save.isChecked()) {
            save.setChecked(false);
        }
        if (three.isChecked()) {
            three.setChecked(false);
        }
        if (villain.isChecked()) {
            villain.setChecked(false);
        }
        if (ATB.isChecked()) {
            ATB.setChecked(false);
        }
    }

    public void resetScore() {
        score = 0;
        three = false;
        save = false;
        gauge = false;
        goal = false;
    }

    private int scoreTotal() {

        return score;
    }

    public String submitAnswers(int score) {


        score = scoreTotal();
        if (score > 0) {
            scoreTotal = "Well done! You have got " + score;
            scoreTotal += " out of 6 correct.";
        } else {
            scoreTotal = "Not quite, try again!";
        }

        ShowResult();
        resetChecks();
        resetScore();

        return scoreTotal;
    }

    private void ShowResult() {
        Toast toast;
        CharSequence sequence = scoreTotal;
        int duration = Toast.LENGTH_LONG;

        toast = Toast.makeText(this, sequence, duration);
        toast.show();
    }
}