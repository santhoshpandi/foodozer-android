package com.example.foodozer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText u,p; ImageButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        u=findViewById(R.id.editTextTextPersonName);
        p=findViewById(R.id.editTextTextPassword);
        b=findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this,MainActivity.class);
                Bundle bn = new Bundle();
                bn.putString("uname",u.getText().toString());
                bn.putString("pass",p.getText().toString());
                if(u.getText().toString().trim().equals("")||p.getText().toString().trim().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Invalid format :(",Toast.LENGTH_LONG).show();
                }
                else
                {
                    i.putExtras(bn);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Registered Successfully :)",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}