package com.infinity.conociendochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.infinity.conociendochile.R;

public class Principal_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_principal);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Box_Menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void Arica (View view) {
        Intent arica = new Intent(this, Arica.class);
        startActivity(arica);
    }

    public void Iquique (View view) {
        Intent iquique = new Intent(this, Iquique.class);
        startActivity(iquique);
    }

    public void Antofagasta (View view) {
        Intent antofagasta = new Intent(this, Antofagasta.class);
        startActivity(antofagasta);
    }

    public void Copiapo (View view) {
        Intent copiapo = new Intent(this, Copiapo.class);
        startActivity(copiapo);
    }

    public void Laserena (View view) {
        Intent laserena = new Intent(this, LaSerena.class);
        startActivity(laserena);
    }

    public void Coquimbo (View view) {
        Intent coquimbo = new Intent(this, Coquimbo.class);
        startActivity(coquimbo);
    }

    public void VinaDelMar (View view) {
        Intent vinadelmar = new Intent(this, VinaDelMar.class);
        startActivity(vinadelmar);
    }

    public void Valparaiso (View view) {
        Intent valparaiso = new Intent(this, Valparaiso.class);
        startActivity(valparaiso);
    }

    public void Santiago (View view) {
        Intent Santiago = new Intent(this, Santiago.class);
        startActivity(Santiago);
    }

}
