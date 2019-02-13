package com.scowluga.android.avalon.Voting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.scowluga.android.avalon.CycleFragmentListener;
import com.scowluga.android.avalon.R;

public class VoteFragment extends Fragment {
    OnVoteListener mCallback;
    CycleFragmentListener cycleFragmentListener;

    public VoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.voting_vote, container, false);

        final Spinner spinner = (Spinner) v.findViewById(R.id.voting_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.vote_array,
                android.R.layout.simple_spinner_item
        );
        spinner.setAdapter(adapter);

        Button nextBtn = (Button) v.findViewById(R.id.voting_nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int spinnerItem = spinner.getSelectedItemPosition();
                if (spinnerItem == 0) {
                    Toast.makeText(getActivity(), "Select Vote", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Vote Registered", Toast.LENGTH_SHORT).show();

                    mCallback.onVote(spinnerItem == 1);
                    cycleFragmentListener.nextButtonPressed();
                }
                spinner.setSelection(0);
            }
        });

        return v;
    }

    public interface OnVoteListener {
        void onVote(boolean isPass);
    }
}
