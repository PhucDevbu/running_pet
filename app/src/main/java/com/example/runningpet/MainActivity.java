package com.example.runningpet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    ImageButton btn;
    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);

        txtDiem.setText(String.valueOf(soDiem));
        CountDownTimer countDownTimer = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if (sb1.getProgress()>=sb1.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Pet 1 win", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    if (cb1.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(String.valueOf(soDiem));
                    EnableCheckBox();
                }
                if (sb2.getProgress()>=sb2.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Pet 2 win", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    if (cb2.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(String.valueOf(soDiem));
                    EnableCheckBox();
                }
                if (sb3.getProgress()>=sb3.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Pet 3 win", Toast.LENGTH_SHORT).show();
                    btn.setVisibility(View.VISIBLE);
                    if (cb3.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(String.valueOf(soDiem));
                    EnableCheckBox();
                }
                sb1.setProgress(sb1.getProgress()+one);
                sb2.setProgress(sb2.getProgress()+two);
                sb3.setProgress(sb3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked()||cb2.isChecked()||cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    btn.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }else {
                    Toast.makeText(MainActivity.this, "Please check before start", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    private void AnhXa() {
        txtDiem = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        sb1 = findViewById(R.id.sb1);
        sb2 = findViewById(R.id.sb2);
        sb3 = findViewById(R.id.sb3);
    }

}