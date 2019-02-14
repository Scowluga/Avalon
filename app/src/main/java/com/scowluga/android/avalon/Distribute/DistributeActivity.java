package com.scowluga.android.avalon.Distribute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.scowluga.android.avalon.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistributeActivity extends AppCompatActivity {

    static ArrayList<String> total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribute);

        total = new ArrayList<>();

        final List<String> merlinNames = new ArrayList<>(Arrays.asList(
                "Merlin",
                "Percival",
                "Servant of Merlin",
                "Servant of Merlin",
                "Servant of Merlin",
                "Servant of Merlin"
        ));
        boolean[] showInitial = new boolean[]{
                true,
                true,
                true,
                true,
                false,
                false
        };
        final LinearLayout merlinLL = findViewById(R.id.distribute_ll_merlin);
        for (int i = 0; i < merlinNames.size(); i++) {
            final String s = merlinNames.get(i);
            final boolean init = showInitial[i];
            CheckBox cb = new CheckBox(DistributeActivity.this);
            cb.setText(s);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        total.add(s);
                    else
                        total.remove(s);

                }
            });
            if (init)
                cb.setChecked(true);

            merlinLL.addView(cb);
        }

        final List<String> mordredNames = new ArrayList<>(Arrays.asList(
                "Mordred",
                "Morgana",
                "Assassin",
                "Oberon",
                "Minion of Mordred",
                "Minion of Mordred"
        ));
        boolean[] showInitial2 = new boolean[]{
                false,
                true,
                true,
                false,
                true,
                false
        };
        final LinearLayout mordredLL = findViewById(R.id.distribute_ll_mordred);
        for (int i = 0; i < mordredNames.size(); i++) {
            final String s = mordredNames.get(i);
            final boolean init = showInitial2[i];
            CheckBox cb = new CheckBox(DistributeActivity.this);
            cb.setText(s);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b)
                        total.add(s);
                    else
                        total.remove(s);

                }
            });
            if (init)
                cb.setChecked(true);

            mordredLL.addView(cb);
        }

        Button startBtn = findViewById(R.id.distribute_startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(total);
                Collections.shuffle(total);
                Collections.shuffle(total);
                Collections.shuffle(total);
                Collections.shuffle(total);
                Collections.shuffle(total);
                Collections.shuffle(total);
                Intent intent = new Intent(DistributeActivity.this, RoleActivity.class);
                intent.putStringArrayListExtra("ROLES", total);
                startActivity(intent);
            }
        });
    }
}
