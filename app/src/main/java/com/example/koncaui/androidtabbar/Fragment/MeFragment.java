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

import static com.example.koncaui.androidtabbar.CalculateUtils.*;

/**
 * Created by jue on 28/03/2018.
 */

public class MeFragment extends Fragment {
    private EditText l0,l1,l2,l3,h0,h1,v1,v2,v3,m1,m2,m3;
    private Button btn_cal;
    private TextView result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me,container,false);

        l1 = (EditText) view.findViewById(R.id.u_et_l1);
        l2 = (EditText) view.findViewById(R.id.u_et_l2);
        l3 = (EditText) view.findViewById(R.id.u_et_l3);
        h1 = (EditText) view.findViewById(R.id.u_et_h1);
        v1 = (EditText) view.findViewById(R.id.u_et_v1);
        v2 = (EditText) view.findViewById(R.id.u_et_v2);
        v3 = (EditText) view.findViewById(R.id.u_et_v3);
        m1 = (EditText) view.findViewById(R.id.u_et_m1);
        m2 = (EditText) view.findViewById(R.id.u_et_m2);
        m3 = (EditText) view.findViewById(R.id.u_et_m3);

        l0 = (EditText) view.findViewById(R.id.u_et_l0);
        h0 = (EditText) view.findViewById(R.id.u_et_h0);

        btn_cal = (Button) view.findViewById(R.id.u_btn_cal);
        result = (TextView) view.findViewById(R.id.u_result);


        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 获取控件中的值
                String sl1 = l1.getText().toString().trim();
                String sl2 = l2.getText().toString().trim();
                String sl3 = l3.getText().toString().trim();
                String sh1 = h1.getText().toString().trim();
                String sv1 = v1.getText().toString().trim();
                String sv2 = v2.getText().toString().trim();
                String sv3 = v3.getText().toString().trim();
                String sm1 = m1.getText().toString().trim();
                String sm2 = m2.getText().toString().trim();
                String sm3 = m3.getText().toString().trim();

                String sl0 = l0.getText().toString().trim();
                String sh0 = h0.getText().toString().trim();
                //转换成double类型
                double dl1 = Double.parseDouble(sl1);
                double dl2 = Double.parseDouble(sl2);
                double dl3 = Double.parseDouble(sl3);
                double dh1 = Double.parseDouble(sh1);
                double dv1 = Double.parseDouble(sv1);
                double dv2 = Double.parseDouble(sv2);
                double dv3 = Double.parseDouble(sv3);
                double dm1 = Double.parseDouble(sm1);
                double dm2 = Double.parseDouble(sm2);
                double dm3 = Double.parseDouble(sm3);

                double dl0 = Double.parseDouble(sl0);
                double dh0 = Double.parseDouble(sh0);

                double q,qt,q1,q2,q3,q0,r0,s0;


                //u型部分计算结果
                r0 = add(div(Math.pow(dl0,2),mul(8,dh0),3),div(dh0,2,3));
                s0 = sub(div(mul(mul(Math.PI,mul(r0,r0)),Math.asin(div(dl0,add(r0,r0),3))),180,3),div(mul(dl0,sub(r0,dh0)),2,3));
                q0 = mul(s0,dv2);

                if (sh1.isEmpty()){
                    result.setText(Double.toString(round(q0,3))+"m³/s");
                } else {

                    //梯型部分计算结果
                    q1 = mul(mul(dl1,dh1),mul(dv1,dm1));
                    q2 = mul(mul(dl2,dh1),mul(dv2,dm2));
                    q3 = mul(mul(dl3,dh1),mul(dv3,dm3));
                    qt =add(add(q1,q2),q3);

                    q = add(q0,qt);
                    result.setText(Double.toString(round(q,3))+"m³/s");
                }



            }
        });
    }
}
