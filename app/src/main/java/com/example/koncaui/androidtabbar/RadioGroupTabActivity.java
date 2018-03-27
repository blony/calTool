package com.example.koncaui.androidtabbar;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.koncaui.androidtabbar.Fragment.HomeFragment;
import com.example.koncaui.androidtabbar.Fragment.MeFragment;
import com.example.koncaui.androidtabbar.Fragment.NewsFragment;

public class RadioGroupTabActivity extends AppCompatActivity implements RadioGroup
        .OnCheckedChangeListener {

    private RadioGroup radioGroup;

    private RadioButton homeButton,newsButton,meButton;

    private Fragment homeFragment,newsFragment,meFragment;
    private Fragment mFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_radio_group_tab);
        initViews();
    }

    private void initViews() {


        radioGroup = findViewById(R.id.tab_radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        homeButton = findViewById(R.id.tab_home_button);
        newsButton = findViewById(R.id.tab_news_button);
        meButton = findViewById(R.id.tab_me_button);

        changeImageSize(homeButton,R.drawable.cal_selector);
        changeImageSize(newsButton,R.drawable.cal_selector);
        changeImageSize(meButton,R.drawable.cal_selector);


        homeFragment = new HomeFragment();
        newsFragment = new NewsFragment();
        meFragment = new MeFragment();


        //先加载HomeFragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_content,homeFragment).commit();
        mFragment = homeFragment;




    }

    //自定义RaidoButton_ImageSize
    private void changeImageSize(RadioButton radioButton,int id){
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0,0,30,30);
        radioButton.setCompoundDrawables(null,drawable,null,null);
    }


    private void switchFragment(Fragment fragment) {


        //判断当前显示的Fragment是不是切换的Fragment

        if (mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment).add(R.id.fragment_content, fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            case R.id.tab_home_button:
                switchFragment(homeFragment);
                break;
            case R.id.tab_news_button:
                switchFragment(newsFragment);
                break;
            case R.id.tab_me_button:
                switchFragment(meFragment);
                break;
            default:
                break;
        }
    }
}
