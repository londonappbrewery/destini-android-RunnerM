package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mTopButton;
    private Button mBottomButton;
    private TextView mStoryTextView;
    private int mStoryIndex = 1;
    private Button mExitButton;
    private Button mRestartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);
        mRestartButton = findViewById(R.id.restart_button);
        mExitButton = findViewById(R.id.exit_button);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIndex(true);
                updateText(mStoryIndex);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIndex(false);
                updateText(mStoryIndex);
            }
        });

        mRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


    }

    private void updateIndex(boolean TopOrBottom) { // TopOrBottom--> true==top, false=bottom
        switch (mStoryIndex) {
            case 1:
                if (TopOrBottom) {
                    mStoryIndex = 3;
                } else {
                    mStoryIndex = 2;
                }
                break;
            case 2:
                if (TopOrBottom) {
                    mStoryIndex = 3;
                } else {
                    mStoryIndex = 4;
                }
                break;
            case 3:
                if (TopOrBottom) {
                    mStoryIndex = 6;
                } else {
                    mStoryIndex = 5;
                }
                break;

        }
    }

    private void updateText(int index) {
        switch (index) {
            case 1:
                mStoryTextView.setText(R.string.T1_Story);
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);
                break;
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                mExitButton.setVisibility(View.VISIBLE);
                mRestartButton.setVisibility(View.VISIBLE);
                break;
            case 5:
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                mExitButton.setVisibility(View.VISIBLE);
                mRestartButton.setVisibility(View.VISIBLE);
                break;
            case 6:
                mStoryTextView.setText(R.string.T5_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                mExitButton.setVisibility(View.VISIBLE);
                mRestartButton.setVisibility(View.VISIBLE);
                break;
        }
    }
}
