package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutMe extends AppCompatActivity {
    TextView git, tube, mail;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        git = findViewById(R.id.mygithub);
        git.setMovementMethod(LinkMovementMethod.getInstance());
        tube = findViewById(R.id.myyt);
        tube.setMovementMethod(LinkMovementMethod.getInstance());
        mail = findViewById(R.id.myemail);
        mail.setMovementMethod(LinkMovementMethod.getInstance());
    }

}