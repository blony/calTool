package com.example.koncaui.androidtabbar.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.koncaui.androidtabbar.R;



public class HomeFragment extends Fragment {
    private EditText l1,l2,l3,h,v1,v2,v3,m1,m2,m3;
    private Button btn_cal;
    private TextView result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        l1 = (EditText) getActivity().findViewById(R.id.r_et_l1);
        l2 = (EditText) getActivity().findViewById(R.id.r_et_l2);
        l3 = (EditText) getActivity().findViewById(R.id.r_et_l3);
        h = (EditText) getActivity().findViewById(R.id.r_et_h);
        v1 = (EditText) getActivity().findViewById(R.id.r_et_v1);
        v2 = (EditText) getActivity().findViewById(R.id.r_et_v2);
        v3 = (EditText) getActivity().findViewById(R.id.r_et_v3);
        m1 = (EditText) getActivity().findViewById(R.id.r_et_m1);
        m2 = (EditText) getActivity().findViewById(R.id.r_et_m2);
        m3 = (EditText) getActivity().findViewById(R.id.r_et_m3);
        btn_cal = (Button) getActivity().findViewById(R.id.r_btn_cal);
        result = (TextView) getActivity().findViewById(R.id.r_result);
        




        return inflater.inflate(R.layout.fragment_home,container,false);
    }


}
