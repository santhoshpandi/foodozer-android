package com.example.foodozer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {
    TextView t; Button b;

    String usname,fo,ci,qu,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        t = findViewById(R.id.textView2);
        b = findViewById(R.id.button);
        t.setMovementMethod(new ScrollingMovementMethod());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmationActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        Intent i = getIntent();
        Bundle bn = i.getExtras();

        if(bn!=null)
        {
            usname = bn.getString("uname");
            setTitle("Hi "+usname+" : Order Overview :)");
            ci = bn.getString("city");
            fo = bn.getString("food");
            qu = bn.getString("quantity");
            amount = bn.getString("amount");
        }
        String bill = "    @@ FoodDozers  @@    \n" +
                "    ---------------------------------\n" +
                "Name :        " +usname+
                "\n    ---------------------------------\n" +
                "City :        " + ci+
                "\n    ---------------------------------\n" +
                "Food :        " + fo+
                "\n    ---------------------------------\n" +
                "Total Amount    Rs."+amount+
                "\n    ---------------------------------\n";

        t.setText(bill);
    }
}