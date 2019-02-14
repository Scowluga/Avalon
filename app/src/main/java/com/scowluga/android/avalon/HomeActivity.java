package com.scowluga.android.avalon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scowluga.android.avalon.Distribute.DistributeActivity;
import com.scowluga.android.avalon.Voting.VotingActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button distributeBtn = findViewById(R.id.home_distributeBtn);
        distributeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DistributeActivity.class);
                startActivity(intent);
            }
        });

        Button votingBtn = findViewById(R.id.home_voteBtn);
        votingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, VotingActivity.class);
                startActivity(intent);
            }
        });
    }
}
