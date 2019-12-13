package com.akash.lottedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends Activity {

    LottieAnimationView thumbUp;
    LottieAnimationView thumbDown;
    LottieAnimationView toggle;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        thumbUp=findViewById(R.id.lav_thumbUp);
        thumbDown=findViewById(R.id.lav_thumbDown);
        toggle=findViewById(R.id.lav_toggle);

        thumbUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thumbDown.setProgress(0);
                thumbDown.pauseAnimation();
                thumbUp.playAnimation();
                Toast.makeText(MainActivity.this,"Cheers!",Toast.LENGTH_SHORT).show();
            }
        });
        thumbDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thumbUp.setProgress(0);
                thumbUp.pauseAnimation();
                thumbDown.playAnimation();
                Toast.makeText(MainActivity.this, "Boo!", Toast.LENGTH_SHORT).show();
            }
        });
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState();
            }
        });
    }

    private void changeState() {
        if(flag==0){
            toggle.setMinAndMaxProgress(0f,0.43f); //Here, calculation is done on the basis of start and stop frame divided by the total number of frames
            toggle.playAnimation();
            flag=1;
            Toast.makeText(MainActivity.this,"flag=1",Toast.LENGTH_SHORT).show();
        }else{
            toggle.setMinAndMaxProgress(0.5f,1f);
            toggle.playAnimation();
            flag=0;
            Toast.makeText(MainActivity.this,"flag=0",Toast.LENGTH_SHORT).show();
        }
    }
}
