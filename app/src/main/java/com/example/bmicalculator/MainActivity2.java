package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity2 extends AppCompatActivity {
    EditText weight, height;
    TextView resulttext, category, healthrisk,wu;
    String calculation, BMIresult, healthText, text,V1,V2;
    private Button button1;
    private Button button2;
    boolean cancel = false;
    float valueH, valueW;
    private static final String FILE1 = "heightData.txt";
    private static final String FILE2 = "weightData.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        weight = findViewById(R.id.weightedit);
        height = findViewById(R.id.heightedit);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.about);
        resulttext = findViewById(R.id.result);
        category = findViewById(R.id.category);
        healthrisk = findViewById(R.id.health);
        wu = findViewById(R.id.heightm);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity3();
            }
        });

        FileInputStream fis1 = null;

        try {
            fis1 = openFileInput(FILE1);
            InputStreamReader isr = new InputStreamReader(fis1);
            BufferedReader br = new BufferedReader(isr);
            String txt;

            while((txt = br.readLine()) != null){
                weight.setText(txt);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis1 != null){
                try {
                    fis1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileInputStream fis2 = null;

        try {
            fis2 = openFileInput(FILE2);
            InputStreamReader isr = new InputStreamReader(fis2);
            BufferedReader br = new BufferedReader(isr);
            String txt;

            while((txt = br.readLine()) != null){
                height.setText(txt);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis2 != null){
                try {
                    fis2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
        public void cm(View view){
            text = "Height (cm)";
            wu.setText(text);
            this.V1 = this.weight.getText().toString();
            this.V2 = this.height.getText().toString();
            this.valueW = Float.parseFloat(this.V1);
            this.valueH = Float.parseFloat(this.V2) / 100;
            cancel = true;
        }
        public void m(View view){
            text = "Height (m)";
            wu.setText(text);
            this.V1 = this.weight.getText().toString();
            this.V2 = this.height.getText().toString();
            this.valueW = Float.parseFloat(this.V1);
            this.valueH = Float.parseFloat(this.V2);
            cancel = true;
        }
    public void calculateBMI(View view){
        if (this.cancel == false)
        {
            this.V1 = this.weight.getText().toString();
            this.V2 = this.height.getText().toString();
            this.valueW = Float.parseFloat(this.V1);
            this.valueH = Float.parseFloat(this.V2);
        }

        float bmi = valueW / (valueH * valueH);

        if (bmi < 16) {
            BMIresult = "Severely Under Weight";

        } else if (bmi < 18.5) {
            BMIresult = "Under Weight";
            healthText = "Malnutrition risk";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            BMIresult = "Normal Weight";
            healthText = "low risk";
        } else if (bmi >= 25 && bmi <= 29.9) {
            BMIresult = "Overweight";
            healthText = "enchanced risk";
        } else {
            BMIresult = "Obese";
            healthText = "medium risk";

        }

        calculation = bmi + " kg/m²";
        category.setText(BMIresult);
        healthrisk.setText(healthText);
        resulttext.setText(calculation);
        String txt1 = weight.getText().toString();
        String txt2 = height.getText().toString();
        FileOutputStream fos1 = null;
        try {
            fos1 = openFileOutput(FILE1, MODE_PRIVATE);
            fos1.write(txt1.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos1!=null){
                try {
                    fos1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileOutputStream fos2 = null;
        try {
            fos2 = openFileOutput(FILE2, MODE_PRIVATE);
            fos2.write(txt2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos2!=null){
                try {
                    fos2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void openActivity3(){
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }


}


