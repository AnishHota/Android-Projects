package com.example.android.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA=0,scoreB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void threePointTeamA(View view)
    {
        scoreA+=3;
        displayForTeamA(scoreA);
    }
    public void twoPointTeamA(View view)
    {
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void onePointTeamA(View view)
    {
        scoreA+=1;
        displayForTeamA(scoreA);
    }
    /* FOR TEAM B */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void threePointTeamB(View view)
    {
        scoreB+=3;
        displayForTeamB(scoreB);
    }
    public void twoPointTeamB(View view)
    {
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void onePointTeamB(View view)
    {
        scoreB+=1;
        displayForTeamB(scoreB);
    }
    public void resetScores(View view)
    {
        scoreA=0;
        scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}

