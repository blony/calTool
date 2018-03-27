package com.example.koncaui.androidtabbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button goTabbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        //去除标题栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }

    private void initViews() {
        goTabbar = findViewById(R.id.go_tabbar);
        goTabbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go_tabbar:
                ActivityUitl.startRadioGroupTabActivity(this);
                break;
            default:
                break;
        }
    }
}
