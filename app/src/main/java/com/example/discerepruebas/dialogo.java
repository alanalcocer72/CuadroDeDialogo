package com.example.discerepruebas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class dialogo extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cdialogo);

        recibirDatos();



        Button aceptar = (Button) findViewById(R.id.btnaceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast1 = Toast.makeText(getApplicationContext(), "Acepto la sesion", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0 ,-10);

                toast1.show();

            }
        });

        Button rechazar = (Button) findViewById(R.id.btncancel);
        rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast1 = Toast.makeText(getApplicationContext(), "Rechazo la sesion", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0 ,-10);

                toast1.show();

            }
        });


        Button ok = (Button) findViewById(R.id.btnok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               finish();

            }
        });


    }





    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String nombreF = extras.getString("Rnombre");
        String fecha = extras.getString("Rfecha");
        String horas = extras.getString("Rhora");
        String minutos = extras.getString("Rmin");
        String horas2 = extras.getString("Rhora2");
        String minutos2 = extras.getString("Rmin2");

        TextView date = (TextView) findViewById(R.id.date);
        TextView timeset = (TextView) findViewById(R.id.time);
        TextView namess = (TextView) findViewById(R.id.fellow);
        namess.setText("Fellow: " + nombreF);
        date.setText("Date: "+ fecha);
        timeset.setText("Time: " + horas + ":" + minutos + " - " + horas2 + ":" + minutos2 );
        }
}
