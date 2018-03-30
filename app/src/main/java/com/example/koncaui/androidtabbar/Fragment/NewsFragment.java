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

public class NewsFragment extends Fragment {
    private EditText l1,l2,l3,h,v1,v2,v3,m1,m2,m3;
    private Button btn_cal;
    private TextView result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news,container,false);

        l1 = (EditText) view.findViewById(R.id.t_et_l1);
        l2 = (EditText) view.findViewById(R.id.t_et_l2);
        l3 = (EditText) view.findViewById(R.id.t_et_l3);
        h = (EditText) view.findViewById(R.id.t_et_h);
        v1 = (EditText) view.findViewById(R.id.t_et_v1);
        v2 = (EditText) view.findViewById(R.id.t_et_v2);
        v3 = (EditText) view.findViewById(R.id.t_et_v3);
        m1 = (EditText) view.findViewById(R.id.t_et_m1);
        m2 = (EditText) view.findViewById(R.id.t_et_m2);
        m3 = (EditText) view.findViewById(R.id.t_et_m3);
        btn_cal = (Button) view.findViewById(R.id.t_btn_cal);
        result = (TextView) view.findViewById(R.id.t_result);


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
                String sh = h.getText().toString().trim();
                String sv1 = v1.getText().toString().trim();
                String sv2 = v2.getText().toString().trim();
                String sv3 = v3.getText().toString().trim();
                String sm1 = m1.getText().toString().trim();
                String sm2 = m2.getText().toString().trim();
                String sm3 = m3.getText().toString().trim();

                //转换成double类型
                double dl1 = Double.parseDouble(sl1);
                double dl2 = Double.parseDouble(sl2);
                double dl3 = Double.parseDouble(sl3);
                double dh = Double.parseDouble(sh);
                double dv1 = Double.parseDouble(sv1);
                double dv2 = Double.parseDouble(sv2);
                double dv3 = Double.parseDouble(sv3);
                double dm1 = Double.parseDouble(sm1);
                double dm2 = Double.parseDouble(sm2);
                double dm3 = Double.parseDouble(sm3);

                double q,q1,q2,q3;
                q1 = mul(mul(dl1,dh),mul(dv1,dm1));
                q2 = mul(mul(dl2,dh),mul(dv2,dm2));
                q3 = mul(mul(dl3,dh),mul(dv3,dm3));
                //计算结果
                q =add(add(q1,q2),q3);

                result.setText(Double.toString(round(q,3))+"m³/s");


            }
        });
    }
}
