package com.project.android_kidstories;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.project.android_kidstories.sharePref.SharePref;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharePref sharePref = SharePref.getINSTANCE(getApplicationContext());
                boolean hasLaunchedBefore = sharePref.getBool(OnBoardingActivity.HAS_LAUNCHED_BEFORE);

                if (hasLaunchedBefore) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
            //the delay time is 3s
        }, 3000);

    }
}
