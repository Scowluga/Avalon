package com.scowluga.android.avalon.Voting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.scowluga.android.avalon.CycleFragmentListener;
import com.scowluga.android.avalon.R;

public class StartFragment extends Fragment {
    OnNumberChangedListener mCallback;
    CycleFragmentListener cycleFragmentListener;

    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.voting_start, container, false);

        NumberPicker np = (NumberPicker)v.findViewById(R.id.voting_numberPicker);
        np.setMinValue(2);
        np.setMaxValue(12);
        np.setWrapSelectorWheel(false);
        np.setValue(3);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                mCallback.onNumberChanged(i1);
            }
        });

        Button nextBtn = (Button)v.findViewById(R.id.voting_nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cycleFragmentListener.nextButtonPressed();
            }
        });

        return v;
    }

    public interface OnNumberChangedListener {
        void onNumberChanged(int value);
    }
}
