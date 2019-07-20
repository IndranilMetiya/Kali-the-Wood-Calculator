package com.example.indra.woodcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BillActivity extends AppCompatActivity {
    TextView name,shop,contactDealer,locationDealer,logrs;
    Button btnbill;
    String a,b,c,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        name=(TextView)findViewById(R.id.name);
        shop=(TextView)findViewById(R.id.shop);
        contactDealer=(TextView)findViewById(R.id.contactDealer);
        locationDealer=(TextView)findViewById(R.id.locationDealer);
        logrs=(TextView)findViewById(R.id.logrs);
        btnbill=(Button)findViewById(R.id.btnbill);


        btnbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    a=Registration.oname;
                    name.setText(Registration.sname);


                }
                catch (Exception e)
                {
                    Toast.makeText(BillActivity.this,"not find data",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
