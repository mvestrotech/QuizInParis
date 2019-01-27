package mvestro.android.quizinparis.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mvestro.android.quizinparis.R;

public class GridActivity extends AppCompatActivity {

    private Button mBtnP1;
    private Button mBtnP2;
    private Button mBtnP3;
    private Button mBtnP4;
    private Button mBtnP5;
    private Button mBtnP6;
    private Button mBtnP7;
    private Button mBtnP8;
    private Button mBtnP9;
    private Button mBtnP10;
    private Button mBtnP11;
    private Button mBtnP12;
    private Button mBtnP13;
    private Button mBtnP14;
    private Button mBtnP15;
    private Button mBtnP16;
    private Button mBtnP17;
    private Button mBtnP18;
    private Button mBtnP19;
    private Button mBtnP20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        mBtnP1 = (Button) findViewById(R.id.activity_paris_1);
        mBtnP2 = (Button) findViewById(R.id.activity_paris_2);
        mBtnP3 = (Button) findViewById(R.id.activity_paris_3);
        mBtnP4 = (Button) findViewById(R.id.activity_paris_4);
        mBtnP5 = (Button) findViewById(R.id.activity_paris_5);
        mBtnP6 = (Button) findViewById(R.id.activity_paris_6);
        mBtnP7 = (Button) findViewById(R.id.activity_paris_7);
        mBtnP8 = (Button) findViewById(R.id.activity_paris_8);
        mBtnP9 = (Button) findViewById(R.id.activity_paris_9);
        mBtnP10 = (Button) findViewById(R.id.activity_paris_10);
        mBtnP11 = (Button) findViewById(R.id.activity_paris_11);
        mBtnP12 = (Button) findViewById(R.id.activity_paris_12);
        mBtnP13 = (Button) findViewById(R.id.activity_paris_13);
        mBtnP14 = (Button) findViewById(R.id.activity_paris_14);
        mBtnP15 = (Button) findViewById(R.id.activity_paris_15);
        mBtnP16 = (Button) findViewById(R.id.activity_paris_16);
        mBtnP17 = (Button) findViewById(R.id.activity_paris_17);
        mBtnP18 = (Button) findViewById(R.id.activity_paris_18);
        mBtnP19 = (Button) findViewById(R.id.activity_paris_19);
        mBtnP20 = (Button) findViewById(R.id.activity_paris_20);

        mBtnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivityIntent = new Intent(GridActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}
