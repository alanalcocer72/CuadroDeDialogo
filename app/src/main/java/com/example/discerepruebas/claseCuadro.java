package com.example.discerepruebas;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class claseCuadro extends AppCompatActivity {
    private String hora;
    private String minuto;
    private String Enviarfecha;
    private String Enviarnombre;
    private String hora2;
    private String minuto2;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuadrodialogo1);
        CalendarView c;









        //Spinners :V
        final Spinner sp11 = (Spinner) findViewById(R.id.sp1);
        final Spinner sp22 = (Spinner) findViewById(R.id.sp2);
        final Spinner nm = (Spinner) findViewById(R.id.nombrecitos);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.horas, android.R.layout.simple_spinner_item);
        sp11.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.minutos, android.R.layout.simple_spinner_item);
        sp22.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.nombresSp, android.R.layout.simple_spinner_item);
        nm.setAdapter(adapter3);


        // Capturar datos de los spinners xD
        sp11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String hor= sp11.getSelectedItem().toString();
                hora = hor;

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        sp22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(
        ) {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String min = sp22.getSelectedItem().toString();
                minuto = min;

                //Conversion String a Int
                int hora1 = Integer.parseInt(hora);
                int min1 = Integer.parseInt(min);

                if (min1 > 45){
                    int Nmin2 = (min1 + 15) - 60;

                    // If para agregar el 0 a los minutos
                    if(Nmin2 > 9){
                        String min2 = String.valueOf(Nmin2);
                        minuto2 = min2;
                    }
                    else{
                        String min2 = String.valueOf(Nmin2);
                        minuto2 ="0" + min2;
                    }


                    int Nhora2 = hora1 + 1;
                    // If para agregar el 0 a las horas
                    if(Nhora2 < 10){
                        String ho2 = String.valueOf(Nhora2);
                        hora2 ="0" + ho2;

                    }
                    else{
                        String ho2 = String.valueOf(Nhora2);
                        hora2 = ho2;
                    }



                } else {
                    int Nmin2 = min1 + 15;
                    // If para agregar el 0 a los minutos
                    if (Nmin2 < 10) {
                        String min2 = String.valueOf(Nmin2);
                        minuto2 = "0" + min2;
                    } else {
                        String min2 = String.valueOf(Nmin2);
                        minuto2 = min2;
                    }

                    int Nhora2 = hora1;
                    // If para agregar el 0 a las horas
                    if(Nhora2 < 10){
                        String ho2 = String.valueOf(Nhora2);
                        hora2 ="0" + ho2;
                    }
                    else{
                        String ho2 = String.valueOf(Nhora2);
                        hora2 = ho2;
                    }



                }




            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        nm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String nme= nm.getSelectedItem().toString();
               Enviarnombre = nme;
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Calendario :V
        c = (CalendarView) findViewById(R.id.calendarView);

        //Capturar datos del calendario :V
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int a, int m, int d) {
                String date = d + "/" + (m + 1) + "/" + a;
                Enviarfecha = date;



            }
        });




        Button btn2 = (Button) findViewById(R.id.arrojar);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(claseCuadro.this, dialogo.class);
                i.putExtra("Rnombre", Enviarnombre);
                i.putExtra("Rfecha", Enviarfecha);
                i.putExtra("Rhora", hora);
                i.putExtra("Rmin", minuto);
                i.putExtra("Rhora2" , hora2);
                i.putExtra("Rmin2", minuto2);


                startActivity(i);

            }
        });


    }


}