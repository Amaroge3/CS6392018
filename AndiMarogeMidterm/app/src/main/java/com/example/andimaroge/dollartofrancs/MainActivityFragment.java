package com.example.andimaroge.dollartofrancs;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    public TextInputEditText userInputView;
    public Button convertButton;
    public TextView dollarTotalView;
    View view;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        view = inflater.inflate(R.layout.fragment_main, container, false);
//        convertButton = (Button) view.findViewById(R.id.convertButton);
//        convertButton.setOnClickListener(this);
//
//
//
//

        return inflater.inflate(R.layout.fragment_main, container, false);

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Your code here

        convertButton = (Button) getActivity().findViewById(R.id.convertButton);
        convertButton.setOnClickListener(this);

        userInputView = (TextInputEditText) getActivity().findViewById(R.id.userInput);
        dollarTotalView = (TextView) getActivity().findViewById(R.id.dollarTotalView);


    }

    @Override
    public void onClick(View view) {
        Double userInputDouble = 0.0;
       Double totalFrancs = 0.0;
        switch (view.getId()){
            case R.id.convertButton:{
                userInputDouble = parseDouble(userInputView.getText().toString());
                totalFrancs = userInputDouble * 439.36;
                dollarTotalView.setText(totalFrancs.toString());
                userInputView.setText("");

                break;
            }
        }

    }
}
