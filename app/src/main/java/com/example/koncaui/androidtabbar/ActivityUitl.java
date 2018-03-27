package com.example.koncaui.androidtabbar;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by koncaui on 07/02/2018.
 */

public class ActivityUitl {
    public static void startRadioGroupTabActivity(Activity activity){
        Intent intent = new Intent(activity,RadioGroupTabActivity.class);
        activity.startActivity(intent);
    }
}
