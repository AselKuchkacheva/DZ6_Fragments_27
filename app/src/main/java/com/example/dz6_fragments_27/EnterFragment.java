package com.example.dz6_fragments_27;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EnterFragment extends Fragment {

    private EditText enterEditText;
    private Button enterButton;
    public IFragments textGet;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public EnterFragment() {
        // Required empty public constructor
    }

    public static EnterFragment newInstance(String param1, String param2) {
        EnterFragment fragment = new EnterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        textGet = (IFragments) getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);
        enterButton = view.findViewById(R.id.enterButton);
        enterEditText = view.findViewById(R.id.enterEditText);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textGet.onSendText(enterEditText.getText().toString());
            }
        });
        return view;

    }


}