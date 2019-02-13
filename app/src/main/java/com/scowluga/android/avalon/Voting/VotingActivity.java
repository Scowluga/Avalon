package com.scowluga.android.avalon.Voting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.scowluga.android.avalon.CycleFragmentListener;
import com.scowluga.android.avalon.R;

public class VotingActivity extends AppCompatActivity implements
        CycleFragmentListener,
        StartFragment.OnNumberChangedListener,
        VoteFragment.OnVoteListener {

    static int numVotes = 3;

    static int passCount = 0;
    static int failCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        numVotes = 3;
        passCount = 0;
        failCount = 0;

        // Initial Start Fragment
        StartFragment fragment = new StartFragment();
        fragment.mCallback = this;
        fragment.cycleFragmentListener = this;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.voting_fragment, fragment)
                .commit();
    }

    // Start Fragment
    @Override
    public void onNumberChanged(int value) {
        numVotes = value;
    }

    // Vote Fragment
    @Override
    public void onVote(boolean isPass) {
        if (isPass)
            passCount++;
        else
            failCount++;
    }

    // General Cycling of Fragments
    @Override
    public void nextButtonPressed() {
        if (numVotes > 0) {
            VoteFragment fragment = new VoteFragment();
            fragment.mCallback = this;
            fragment.cycleFragmentListener = this;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.voting_fragment, fragment)
                    .commit();
            numVotes--;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(VotingActivity.this);
            builder.setTitle("Vote Results");
            builder.setMessage(String.format(
                "Pass: %d\nFail: %d", passCount, failCount
            ));
            builder.setCancelable(false);
            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            builder.create().show();
        }
    }
}
