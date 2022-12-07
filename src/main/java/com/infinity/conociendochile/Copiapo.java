package com.infinity.conociendochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infinity.conociendochile.R;

public class Copiapo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copiapo);
    }

    public void Home (View view) {
        Intent home = new Intent(this, Principal_Activity.class);
        startActivity(home);
    }

    public void goToMap(View view){
        Intent intent = new Intent(Copiapo.this,MapsActivity.class);
        intent.putExtra("ciudad","copiapo");
        startActivity(intent);
    }
}