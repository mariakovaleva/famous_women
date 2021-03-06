package com.example.android.miwok;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    float score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz); // Temporary -> use array adapt or show 5 questions by default?

        final ArrayList<QuizQuestion> questions = new ArrayList<QuizQuestion>();    // ArrayList of all quiz questions

        questions.add(new QuizQuestion("Question 1", "Answer 11", "Answer 12", "Answer 13", 1, 1));
        questions.add(new QuizQuestion("Question 2", "Answer 21", "Answer 22", "Answer 23", 2, 1));
        questions.add(new QuizQuestion("Question 3", "Answer 31", "Answer 32", "Answer 33", 3, 1));
        questions.add(new QuizQuestion("Question 4", "Answer 41", "Answer 42", "Answer 43", 1, 1));
        questions.add(new QuizQuestion("Question 5", "Answer 51", "Answer 52", "Answer 53", 1, 1));
        questions.add(new QuizQuestion("Question 6", "Answer 61", "Answer 62", "Answer 63", 1, 1));

        // Randomized questions
        Collections.shuffle(questions);

        // Temporary code
        // Find views
        // Question 1
        final TextView question1 = (TextView)findViewById(R.id.tv_question1);
        final RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg_question1);
        final TextView ans1_1 = (TextView)findViewById(R.id.rb_answer1_1);
        final TextView ans1_2 = (TextView)findViewById(R.id.rb_answer1_2);
        final TextView ans1_3 = (TextView)findViewById(R.id.rb_answer1_3);
        final TextView submit1 = (TextView) findViewById(R.id.tv_submit_1);
        // Question 2
        final TextView question2 = (TextView)findViewById(R.id.tv_question2);
        final RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg_question2);
        final TextView ans2_1 = (TextView)findViewById(R.id.rb_answer2_1);
        final TextView ans2_2 = (TextView)findViewById(R.id.rb_answer2_2);
        final TextView ans2_3 = (TextView)findViewById(R.id.rb_answer2_3);
        final TextView submit2 = (TextView) findViewById(R.id.tv_submit_2);
        // Question 3
        final TextView question3 = (TextView)findViewById(R.id.tv_question3);
        final RadioGroup rg3 = (RadioGroup)findViewById(R.id.rg_question3);
        final TextView ans3_1 = (TextView)findViewById(R.id.rb_answer3_1);
        final TextView ans3_2 = (TextView)findViewById(R.id.rb_answer3_2);
        final TextView ans3_3 = (TextView)findViewById(R.id.rb_answer3_3);
        final TextView submit3 = (TextView) findViewById(R.id.tv_submit_3);
        // Question 4
        final TextView question4= (TextView)findViewById(R.id.tv_question4);
        final RadioGroup rg4 = (RadioGroup)findViewById(R.id.rg_question4);
        final TextView ans4_1 = (TextView)findViewById(R.id.rb_answer4_1);
        final TextView ans4_2 = (TextView)findViewById(R.id.rb_answer4_2);
        final TextView ans4_3 = (TextView)findViewById(R.id.rb_answer4_3);
        final TextView submit4 = (TextView) findViewById(R.id.tv_submit_4);
        // Question 5
        final TextView question5 = (TextView)findViewById(R.id.tv_question5);
        final RadioGroup rg5 = (RadioGroup)findViewById(R.id.rg_question5);
        final TextView ans5_1 = (TextView)findViewById(R.id.rb_answer5_1);
        final TextView ans5_2 = (TextView)findViewById(R.id.rb_answer5_2);
        final TextView ans5_3 = (TextView)findViewById(R.id.rb_answer5_3);
        final TextView submit5 = (TextView) findViewById(R.id.tv_submit_5);
        // Result
        final TextView result = (TextView) findViewById(R.id.tv_result);

        // Display questions and answers
        question1.setText(questions.get(0).getQuestion());
        ans1_1.setText(questions.get(0).getAnswer1());
        ans1_2.setText(questions.get(0).getAnswer2());
        ans1_3.setText(questions.get(0).getAnswer3());

        question2.setText(questions.get(1).getQuestion());
        question2.setVisibility(View.INVISIBLE);
        rg2.setVisibility(View.INVISIBLE);
        ans2_1.setText(questions.get(1).getAnswer1());
        ans2_2.setText(questions.get(1).getAnswer2());
        ans2_3.setText(questions.get(1).getAnswer3());
        submit2.setVisibility(View.INVISIBLE);

        question3.setText(questions.get(2).getQuestion());
        question3.setVisibility(View.INVISIBLE);
        rg3.setVisibility(View.INVISIBLE);
        ans3_1.setText(questions.get(2).getAnswer1());
        ans3_2.setText(questions.get(2).getAnswer2());
        ans3_3.setText(questions.get(2).getAnswer3());
        submit3.setVisibility(View.INVISIBLE);

        question4.setText(questions.get(3).getQuestion());
        question4.setVisibility(View.INVISIBLE);
        rg4.setVisibility(View.INVISIBLE);
        ans4_1.setText(questions.get(3).getAnswer1());
        ans4_2.setText(questions.get(3).getAnswer2());
        ans4_3.setText(questions.get(3).getAnswer3());
        submit4.setVisibility(View.INVISIBLE);

        question5.setText(questions.get(4).getQuestion());
        question5.setVisibility(View.INVISIBLE);
        rg5.setVisibility(View.INVISIBLE);
        ans5_1.setText(questions.get(4).getAnswer1());
        ans5_2.setText(questions.get(4).getAnswer2());
        ans5_3.setText(questions.get(4).getAnswer3());
        submit5.setVisibility(View.INVISIBLE);


        // Question 1 submit
        if (submit1 != null) {
            // Set a click listener on that View
            submit1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg1.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg1.indexOfChild(findViewById(rg1.getCheckedRadioButtonId()));
                        View child = rg1.getChildAt(questions.get(0).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(0).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg1.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        } else {
                            score ++;
                        }
                        for (int i = 0; i < rg1.getChildCount(); i++) {
                            rg1.getChildAt(i).setEnabled(false);
                        }
                        question2.setVisibility(View.VISIBLE);
                        rg2.setVisibility(View.VISIBLE);
                        submit2.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        // Question 2 submit
        if (submit2 != null) {
            // Set a click listener on that View
            submit2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg2.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg2.indexOfChild(findViewById(rg2.getCheckedRadioButtonId()));
                        View child = rg2.getChildAt(questions.get(1).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(1).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg2.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        } else {
                            score ++;
                        }
                        for (int i = 0; i < rg2.getChildCount(); i++) {
                            rg2.getChildAt(i).setEnabled(false);
                        }
                        question3.setVisibility(View.VISIBLE);
                        rg3.setVisibility(View.VISIBLE);
                        submit3.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        // Question 3 submit
        if (submit3 != null) {
            // Set a click listener on that View
            submit3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg3.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg3.indexOfChild(findViewById(rg3.getCheckedRadioButtonId()));
                        View child = rg3.getChildAt(questions.get(2).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(2).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg3.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        } else {
                            score ++;
                        }
                        for (int i = 0; i < rg3.getChildCount(); i++) {
                            rg3.getChildAt(i).setEnabled(false);
                        }
                        question4.setVisibility(View.VISIBLE);
                        rg4.setVisibility(View.VISIBLE);
                        submit4.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        // Question 4 submit
        if (submit4 != null) {
            // Set a click listener on that View
            submit4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg4.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg4.indexOfChild(findViewById(rg4.getCheckedRadioButtonId()));
                        View child = rg4.getChildAt(questions.get(3).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(3).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg4.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        } else {
                            score ++;
                        }
                        for (int i = 0; i < rg4.getChildCount(); i++) {
                            rg4.getChildAt(i).setEnabled(false);
                        }
                        question5.setVisibility(View.VISIBLE);
                        rg5.setVisibility(View.VISIBLE);
                        submit5.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        // Question 5 submit
        if (submit5 != null) {
            // Set a click listener on that View
            submit5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rg5.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getBaseContext(), "Select answer!",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        int selectedRadioButtonID = rg5.indexOfChild(findViewById(rg5.getCheckedRadioButtonId()));
                        View child = rg5.getChildAt(questions.get(2).getCorrectAnswer());
                        child.setBackgroundColor(Color.GREEN);
                        if (questions.get(4).getCorrectAnswer() != selectedRadioButtonID){
                            View selected = rg5.getChildAt(selectedRadioButtonID);
                            selected.setBackgroundColor(Color.RED);
                        } else {
                            score ++;
                        }
                        for (int i = 0; i < rg5.getChildCount(); i++) {
                            rg5.getChildAt(i).setEnabled(false);
                        }

                        score = score / 5 * 100;
                        result.setText("Your score is: " + (int)score + "%");
                    }
                }
            });
        }
    }
}
