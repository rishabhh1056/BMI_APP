package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText heightft ,heightinch,weight;
        Button btn;
        TextView Result;
        LinearLayout col;
        ImageView imageView;

      btn=  findViewById(R.id.btn);
      heightft=  findViewById(R.id.hightft);
      heightinch=  findViewById(R.id.hightinch);
      weight=  findViewById(R.id.weight);
      Result=  findViewById(R.id.result);
      col = findViewById(R.id.col);
      imageView=findViewById(R.id.imageView);

      btn.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
              double bmi=0;
              int inch=0;
              int wt =  Integer.parseInt( weight.getText().toString());
              int ft= Integer.parseInt(heightft.getText().toString());
              int in= Integer.parseInt(heightinch.getText().toString());


                          int totalInch = ft * 12 + inch;
                          double totalCm = totalInch * 2.53;
                          double totalMeter = totalCm / 100;

                          bmi = wt / (totalMeter * totalMeter);


              if (bmi>=30&&bmi<41) {
                  Result.setText("Abe! Dharti ke boj bjn ghta apna");
                  col.setBackgroundColor(getResources().getColor(R.color.colorOverWait2));
              }
             else if (bmi>=25&&bmi<30){
                  Result.setText("Abe! Mote kam khya kr");
                  col.setBackgroundColor(getResources().getColor(R.color.colorOverWait));
              }
              else if (bmi<25&&bmi>=17) {
                  Result.setText("Normal Hai tu.. ");
                  col.setBackgroundColor(getResources().getColor(R.color.colorNormal));
              }
              else if (bmi<17&&bmi>=14) {
                  Result.setText("abee! Muthal Bjan bda apna.. ");
                  col.setBackgroundColor(getResources().getColor(R.color.colorUnderWait));
              }
              else {
                  Result.setText("Abe Jhatu value shi daal..");
                  col.setBackgroundColor(getResources().getColor(R.color.colorHealthy));
              }


          }
      });

      imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Toast.makeText(MainActivity.this, "Abe! Lodu idhr udhr Ched Chad mat kr BMI Nap le chupchap..", Toast.LENGTH_SHORT).show();
          }
      });



    }
}