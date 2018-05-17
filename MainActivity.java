package com.example.user.baseballkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int innings = 1;
    int strikes = 0;
    int upToBat = 1;
    int scoreA = Integer.valueOf(R.id.scoreText_A);
    int scoreB = Integer.valueOf(R.id.scoreText_B);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.runButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score(upToBat);

            }
        });
        final Button button1 = findViewById(R.id.strikeButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strike(strikes, upToBat);

            }
        });
        final Button button2 = findViewById(R.id.resetButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(innings, strikes, upToBat, scoreA, scoreB);

            }
        });
    }


    /**
     * Determines which team is batting (Team A = 1, Team B = 2) and then scores the run accordingly and displays the score text
     *
     * @param upToBat determines which team is up to bat
     */

    public void score(int upToBat) {
        if (upToBat == 1) {
            scoreA = scoreA + 1;
            displayScoreA(scoreA);
        } else {
            scoreB = scoreB + 1;
            displayScoreB(scoreB);

        }
    }

    /**
     * Records a strike, then determines if three strikes have occurred. If Team A strikes out, it switches to Team B's turn. If Team B strikes out, it switches to Team A and increases the inning
     *
     * @param strikes determines how many stikes have occurred
     * @param upToBat determines which team is up to bat
     */
    public void strike(int strikes, int upToBat) {
        strikes = strikes + 1;
        if (strikes == 3) {
            if (upToBat == 1) {
                upToBat = 2;
                strikes = 0;
            } else {
                upToBat = 1;
                strikes = 0;
                innings = innings + 1;
            }
        } else {
            strikes = strikes;
        }

        TextView textView = findViewById(R.id.strikeText);
        textView.setText(strikes);


    }

    /**
     * Resets game stats
     *
     * @param innings determines the current inning
     * @param strikes determines how many strikes have occured
     * @param upToBat determines which team is up to bat
     * @param scoreA  stores the score for Team A
     * @param scoreB  stores the score for Team B
     */
    public void reset(int innings, int strikes, int upToBat, int scoreA, int scoreB) {
        innings = 1;
        strikes = 0;
        upToBat = 1;
        scoreA = 0;
        scoreB = 0;
        displayInnings(innings);
        displayStrikes(strikes);
        displayScoreA(scoreA);
        displayScoreB(scoreB);

    }

    private void displayScoreA(int number) {
        TextView quantityTextView = findViewById(R.id.scoreText_A);
        quantityTextView.setText(scoreA);
    }

    private void displayScoreB(int number) {
        TextView quantityTextView = findViewById(R.id.scoreText_B);
        quantityTextView.setText(scoreB);
    }

    private void displayStrikes(int number) {
        TextView quantityTextView = findViewById(R.id.strikeText);
        quantityTextView.setText(strikes);
    }

    private void displayInnings(int number) {
        TextView quantityTextView = findViewById(R.id.inningsText);
        quantityTextView.setText(innings);
    }
}

