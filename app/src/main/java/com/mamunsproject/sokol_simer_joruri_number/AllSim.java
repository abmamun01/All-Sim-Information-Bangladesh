package com.mamunsproject.sokol_simer_joruri_number;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllSim extends AppCompatActivity implements View.OnClickListener {

    CardView blCode, gpCodeid, robiCodeid, airtelCodeid, teletalkCodeid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sim);


        blCode = findViewById(R.id.blCodeid);
        gpCodeid = findViewById(R.id.gpCodeid);
        robiCodeid = findViewById(R.id.robiCodeid);
        airtelCodeid = findViewById(R.id.airtelCodeid);
        teletalkCodeid = findViewById(R.id.teletalkCodeid);


        blCode.setOnClickListener(this::onClick);
        gpCodeid.setOnClickListener(this::onClick);
        robiCodeid.setOnClickListener(this::onClick);
        airtelCodeid.setOnClickListener(this::onClick);
        teletalkCodeid.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.blCodeid:

                startActivity(new Intent(getApplicationContext(), BanglalinkCode.class));
                break;

            case R.id.gpCodeid:

                startActivity(new Intent(getApplicationContext(), GrameenCode.class));
                break;

            case R.id.robiCodeid:

                startActivity(new Intent(getApplicationContext(), RobiCode.class));
                break;

            case R.id.airtelCodeid:

                startActivity(new Intent(getApplicationContext(), AirtelCode.class));
                break;

            case R.id.teletalkCodeid:

                startActivity(new Intent(getApplicationContext(), TeletalkCode.class));
                break;


        }

    }
}