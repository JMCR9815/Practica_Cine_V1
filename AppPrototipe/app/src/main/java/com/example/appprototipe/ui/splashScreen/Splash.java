package com.example.appprototipe.ui.splashScreen;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appprototipe.MainActivity;
import com.example.appprototipe.R;

public class Splash extends Activity {
    Configuration configuration;
    TextView splashText1, splashText2, splashText3;
    ImageView splashLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        Animation animacionSplashUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation animacionSplashDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation animacionfade = AnimationUtils.loadAnimation(this, R.anim.fade_transition);
        splashText1 = findViewById(R.id.splashText1);
        splashText2 = findViewById(R.id.splashText2);
        splashText3 = findViewById(R.id.splashText3);
        splashLogo = findViewById(R.id.splashLogo);
        splashText1.setAnimation(animacionSplashDown);
        splashText2.setAnimation(animacionSplashDown);
        splashText3.setAnimation(animacionSplashDown);
        splashLogo.setAnimation(animacionSplashUp);
        configuration = getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            boolean nightModeActive = configuration.isNightModeActive();
            if (nightModeActive) {
                Toast.makeText(this, "EL modo noche esta activad", Toast.LENGTH_SHORT).show();
                splashLogo.setImageResource(R.mipmap.white_launcher_foreground);
            } else {
                Toast.makeText(this, "El modo noche no esta activado", Toast.LENGTH_SHORT).show();
                splashLogo.setImageResource(R.mipmap.carrt_launcher_foreground);
            }
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                setTheme(R.style.Theme_App_SplashScreen);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }


}

