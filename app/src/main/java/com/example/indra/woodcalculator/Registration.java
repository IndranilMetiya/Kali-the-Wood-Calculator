package com.example.indra.woodcalculator;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText OwnerName,ShopName,Contact,Location;
    Button RegisterBtn;
    public static String oname,sname,contact,location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        OwnerName = (EditText) findViewById(R.id.OwnerName);
        ShopName = (EditText) findViewById(R.id.ShopName);
        Contact = (EditText) findViewById(R.id.Contact);
        Location = (EditText) findViewById(R.id.Location);
        RegisterBtn = (Button) findViewById(R.id.Register);
        oname=OwnerName.getText().toString();
        sname=ShopName.getText().toString();
        contact=Contact.getText().toString();
        location=Location.getText().toString();

        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall" , "");

        if (FirstTime.equals("Yes")) {

            Intent i = new Intent(Registration.this, MainActivity.class);
            startActivity(i);

        }
        else
        {
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();



            RegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i = new Intent(Registration.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(Registration.this, "Record was succesfully saved!", Toast.LENGTH_SHORT).show();


                }
            });


        }









    }


}
