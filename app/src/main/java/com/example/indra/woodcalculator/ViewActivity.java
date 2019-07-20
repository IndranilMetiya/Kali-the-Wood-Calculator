package com.example.indra.woodcalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView result;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        result = (TextView) findViewById(R.id.result);
        UserdbHelper user = new UserdbHelper(ViewActivity.this);

        db = user.getReadableDatabase();

        Cursor c = user.viewData(db);

        if (c.getCount() == 0) {
            result.setText("NO DATA FOUND");
        } else {
            c.moveToFirst();
            StringBuffer sb = new StringBuffer();
            do {

                sb.append("INPUT   " + c.getString(5) + " ");
                sb.append("        " + c.getString(3) + " ");
                sb.append("        " + c.getString(6) + "");
                sb.append("        " + c.getString(4) + "\n");
                sb.append("RESULT: " + c.getString(0) + " " );
                sb.append("        " + c.getString(1) + " ");
                sb.append("        " + c.getString(2) + "\n");


                sb.append("\n");








            } while (c.moveToNext());
            result.setMovementMethod(new ScrollingMovementMethod());
            result.setText(sb.toString());
        }
    }
}
