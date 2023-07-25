package com.example.foodozer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText u; EditText p; ImageButton bt,bt4;
    String uname,pass;
    static Map<String,String> login = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        u=findViewById(R.id.uname);
        p = findViewById(R.id.pass);
        bt =findViewById(R.id.imageButton2);
        bt4=findViewById(R.id.imageButton4);

        Intent i = getIntent();
        Bundle bn = i.getExtras();
        if(bn!=null)
        {
            uname=bn.getString("uname");
            pass = bn.getString("pass");
            login.put(uname,pass);
        }

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent a = new Intent(MainActivity.this,SignupActivity.class);
                    startActivity(a);

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,HomeActivity.class);
                boolean f=true;
                for(Map.Entry<String,String> entry: login.entrySet())
                {
                    if(p.getText().toString().equals(entry.getValue())&&u.getText().toString().equals(entry.getKey()))
                    {
                        Bundle b = new Bundle();
                        b.putString("uname",u.getText().toString());
                        i.putExtras(b);
                        f=false;
                        Toast.makeText(getApplicationContext(),"Login Successfully :)",Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    }
                }
                if(f)Toast.makeText(getApplicationContext(),"Credential Invalid!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}