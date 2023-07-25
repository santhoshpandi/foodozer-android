package com.example.foodozer;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView t,ts; Spinner c,f;
    List<String> city;
    List<String> food;
    SeekBar quantity;
    int qu=1; long amount=0;
    String ci="",fo="";
    Button place;
    String usname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t=findViewById(R.id.textView7);
        ts=findViewById(R.id.textView3);
        c=findViewById(R.id.spinner);
        f=findViewById(R.id.spinner2);
        quantity=findViewById(R.id.seekBar);
        place=findViewById(R.id.button2);
        city=new ArrayList<>();
        food = new ArrayList<>();
        city.add("Madurai"); city.add("Chennai"); city.add("Trichy"); city.add("Coimbatore");
        food.add("Idli"); food.add("Dosa"); food.add("Pongal"); food.add("Poori");

        ArrayAdapter<String> c_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, city);
        c_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        c.setAdapter(c_adapter);

        ArrayAdapter<String> f_adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, food);
        f_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        f.setAdapter(f_adapter);

        Intent i = getIntent();
        Bundle bn = i.getExtras();
        if(bn!=null)
        {
             usname = bn.getString("uname");
            setTitle("Hello "+usname+" :)");
        }

        c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ci = (String) parent.getItemAtPosition(position);
               calc();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               fo = (String) parent.getItemAtPosition(position);
               calc();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        quantity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ts.setText(String.valueOf(progress));
                qu=progress;
                calc();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this,ConfirmationActivity.class);
                Bundle bn = new Bundle();

                bn.putString("uname",usname);
                bn.putString("city",ci);
                bn.putString("food",fo);
                bn.putString("quantity",String.valueOf(qu));
                bn.putString("amount",String.valueOf(amount));

                i.putExtras(bn);
                Toast.makeText(getApplicationContext(),"Order Placed Successfully :)",Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });





    }
    public void calc()
    {

        if(fo.equals("Idli")&&ci.equals("Madurai")) amount=qu*7;
        if(fo.equals("Idli")&&ci.equals("Trichy")) amount=qu*6;
        if(fo.equals("Idli")&&ci.equals("Chennai")) amount=qu*12;
        if(fo.equals("Idli")&&ci.equals("Coimbatore")) amount=qu*10;

        if(fo.equals("Pongal")&&ci.equals("Madurai")) amount=qu*35;
        if(fo.equals("Pongal")&&ci.equals("Trichy")) amount=qu*40;
        if(fo.equals("Pongal")&&ci.equals("Chennai")) amount=qu*45;
        if(fo.equals("Pongal")&&ci.equals("Coimbatore")) amount=qu*38;

        if(fo.equals("Dosa")&&ci.equals("Madurai")) amount=qu*27;
        if(fo.equals("Dosa")&&ci.equals("Trichy")) amount=qu*32;
        if(fo.equals("Dosa")&&ci.equals("Chennai")) amount=qu*50;
        if(fo.equals("Dosa")&&ci.equals("Coimbatore")) amount=qu*40;

        if(fo.equals("Poori")&&ci.equals("Madurai")) amount=qu*15;
        if(fo.equals("Poori")&&ci.equals("Trichy")) amount=qu*20;
        if(fo.equals("Poori")&&ci.equals("Chennai")) amount=qu*35;
        if(fo.equals("Poori")&&ci.equals("Coimbatore")) amount=qu*25;

        t.setText("Rs. "+amount);
    }
}