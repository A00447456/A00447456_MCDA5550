package com.example.hotelreservationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2800;

    //variables
    Animation topTextAnimation, bottomTextAnimation, mountainAnimation, hotelIconAnimation;
    TextView mainTittle, subTittle;
    ImageView mountain, hotelIcon, hotelIconshdw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topTextAnimation= AnimationUtils.loadAnimation(this,R.anim.top_text_animation);
        bottomTextAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_text_animation);
        mountainAnimation=AnimationUtils.loadAnimation(this,R.anim.top_montain_animation);
        hotelIconAnimation=AnimationUtils.loadAnimation(this,R.anim.hotel_icon_fade_animation);

        //Hooks
        mainTittle=findViewById(R.id.introTittle);
        subTittle=findViewById(R.id.introTittle2);
        mountain=findViewById(R.id.introMountain);
        hotelIcon=findViewById(R.id.introHotelImg);
        hotelIconshdw=findViewById(R.id.introHotelShdwImg);

        //setAnimations
        mainTittle.setAnimation(topTextAnimation);
        subTittle.setAnimation(bottomTextAnimation);
        mountain.setAnimation(mountainAnimation);
        hotelIcon.setAnimation(hotelIconAnimation);
        hotelIconshdw.setAnimation(hotelIconAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, WelcomeFragment.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}