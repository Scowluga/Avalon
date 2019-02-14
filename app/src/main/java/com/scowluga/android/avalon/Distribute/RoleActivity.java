package com.scowluga.android.avalon.Distribute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.scowluga.android.avalon.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;
import java.util.List;

public class RoleActivity extends AppCompatActivity {

    static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        // Read in list
        final List<String> roles = getIntent().getStringArrayListExtra("ROLES");

        // Set up flipview
        EasyFlipView flipView = findViewById(R.id.role_flip);
        flipView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                if (newCurrentSide == EasyFlipView.FlipState.FRONT_SIDE) {
                    if (roles.size() == 0) {
                        finish();
                    }
                    if (tv != null) {
                        tv.setText("");
                    }
                } else {
                    if (roles.size() == 0) {

                    } else {
                        tv = easyFlipView.findViewById(R.id.role_text);
                        String role = roles.remove(0);
                        tv.setText("Your role is: " + role);
                    }
                }
            }
        });
    }
}
