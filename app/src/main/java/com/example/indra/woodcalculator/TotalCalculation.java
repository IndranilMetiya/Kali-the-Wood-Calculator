package com.example.indra.woodcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TotalCalculation extends AppCompatActivity {
    EditText lenghth,thickness,width,price;
     TextView resultprice;
    Button calbtn;
    float a,b,c,d,e,re;
    String ans1,ans2,ans3,ans4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_calculation);
        lenghth=(EditText) findViewById(R.id.length);
        thickness=(EditText) findViewById(R.id.thick);
        width=(EditText) findViewById(R.id.width);
        resultprice=(TextView)findViewById(R.id.resultprice);
        price=(EditText)findViewById(R.id.price);
        calbtn=(Button)findViewById(R.id.calbtn);
       calbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               try {

                   ans1 = lenghth.getText().toString();
                   ans2 = thickness.getText().toString();
                   ans3 = width.getText().toString();
                   ans4 = price.getText().toString();
                   a = Float.parseFloat(ans1);
                   b = Float.parseFloat(ans2);
                   c = Float.parseFloat(ans3);
                   d = Float.parseFloat(ans4);
                   e = (a * b * c) / 144;
                   re = e * d;
                   resultprice.setText(Float.toString(re));
               }

               catch (Exception e)
               {
                   Toast.makeText(TotalCalculation.this,"Enter proper value",Toast.LENGTH_SHORT).show();

               }
           }
       });







    }
}
