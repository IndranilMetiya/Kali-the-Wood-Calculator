package com.example.indra.woodcalculator;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float rs,mrs,b,c,d;
    TextView answer11,answer12,answer22,resultmain;
    EditText inch11,inch22,ft11,ft22,pricecc;
    Button btn1,histbtn,NormalCalcBtn,finalprice,bill;
    public static String rsmain;
    int tmp1,tmp2,tmp3;
    SQLiteDatabase db;
    double f22,i11,i22,ans1,ans2,a,f1,f2,i1,i2;
    String indra;
    String pinu;
    String tuhin;
    String adesh;

    @Override
    public void onBackPressed() {
        finishAffinity();
        //finishActivity(1);

        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer11=(TextView)findViewById(R.id.answer);
        answer12=(TextView)findViewById(R.id.answer1);
        answer22=(TextView)findViewById(R.id.answer2);
        resultmain=(TextView)findViewById(R.id.resultMain);

        inch11=(EditText) findViewById(R.id.inch1);
        inch22=(EditText) findViewById(R.id.inch2);
        ft11=(EditText) findViewById(R.id.ft1);
        ft22=(EditText) findViewById(R.id.ft2);
        pricecc=(EditText)findViewById(R.id.pricecc);

        //bill=(Button)findViewById(R.id.bill);
        btn1=(Button)findViewById(R.id.btn1);
        histbtn=(Button)findViewById(R.id.histbtn);
        NormalCalcBtn=(Button)findViewById(R.id.CalculateNormal);
        finalprice=(Button)findViewById(R.id.finalPrice);







        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                indra= String.valueOf(ft11.getText());
                pinu= String.valueOf((ft22.getText()));
                tuhin= String.valueOf((inch11.getText()));
                adesh= String.valueOf((inch22.getText()));


                try {
                    f1 =Integer.parseInt(indra);
                    f2 = Integer.parseInt(pinu);
                    i1 = Integer.parseInt(tuhin);
                    i2 = Integer.parseInt(adesh);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"please enter number",Toast.LENGTH_LONG).show();

                }


                f22=(f1/10)*0.833333334;
                i11=i1+f22;
                i22=i2*12;
                f22=i22+f2;
                f22=f22*f22;
                ans1= ((f22*i11)/2304.00);
                tmp1= (int) (ans1);
                ans2=(ans1-tmp1)*12;
                tmp2=(int) (ans2);
                a=((ans2-tmp2)*12)+0.52;
                tmp3=(int) (a);
                answer11.setText(Integer.toString(tmp1));
                answer12.setText(Integer.toString(tmp2));
                answer22.setText(Integer.toString(tmp3));





                UserdbHelper user=new UserdbHelper(MainActivity.this);

                db=user.getWritableDatabase();//give permisson to write
                user.inertData(answer11.getText().toString(), answer12.getText().toString(),
                        answer22.getText().toString(),ft11.getText().toString(), ft22.getText().toString(),inch11.getText().toString(),inch22.getText().toString(), db);
                Toast.makeText(MainActivity.this,"row inserted",Toast.LENGTH_SHORT).show();




            }
        });

        histbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);
            }
        });

        finalprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rp;
                try {
                    rp = pricecc.getText().toString();
                    String temp = String.valueOf(tmp2);
                    String temp1 = String.valueOf(tmp3);
                    String main = "." + temp + temp1;
                    c = Float.parseFloat(main);
                    rs = Float.parseFloat(rp);
                    b = rs * tmp1;
                    d = rs * c;
                    mrs = b + d;
                    resultmain.setText(Float.toString(mrs));
                    rsmain=resultmain.toString();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Enter proper value",Toast.LENGTH_SHORT).show();

                }
            }
        });
        NormalCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(MainActivity.this,TotalCalculation.class);
                startActivity(j);
            }
        });

       




    }
}

