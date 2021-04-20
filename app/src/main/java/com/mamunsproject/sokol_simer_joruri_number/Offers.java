package com.mamunsproject.sokol_simer_joruri_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import soup.neumorphism.NeumorphCardView;

public class Offers extends AppCompatActivity {

    NeumorphCardView bl,gp,robi,airtel,teletalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);




        bl=findViewById(R.id.banglalinkWeb);
        gp=findViewById(R.id.grameenWeb);
        robi=findViewById(R.id.robiWeb);
        airtel=findViewById(R.id.airtelWeb);
        teletalk=findViewById(R.id.teletalkWeb);



        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), WebView_.class);
                intent.putExtra("blw","https://www.banglalink.net/en/prepaid/internet");
                startActivity(intent);

            }
        });


        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebView_.class);
                intent.putExtra("blw","https://www.grameenphone.com/personal/plans-offers/offers");
                startActivity(intent);
            }
        });


        robi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebView_.class);
                intent.putExtra("blw","https://www.robi.com.bd/en/personal/offers");
                startActivity(intent);
            }
        });


        airtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebView_.class);
                intent.putExtra("blw","https://www.bd.airtel.com/en/personal/my-offer");
                startActivity(intent);
            }
        });


        teletalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), WebView_.class);
                intent.putExtra("blw","http://www.teletalk.com.bd/en/offer");
                startActivity(intent);
            }
        });



    }
}