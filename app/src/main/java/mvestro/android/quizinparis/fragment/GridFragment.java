package mvestro.android.quizinparis.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mvestro.android.quizinparis.R;
import mvestro.android.quizinparis.Activity.GameActivity;

public class GridFragment extends Fragment {


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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_grid, container, false);

        mBtnP1 = (Button) view.findViewById(R.id.activity_paris_1);

        mBtnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gameActivityIntent = new Intent(getActivity(),GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
