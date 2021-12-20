package com.example.android.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Button Simple_t,custom_t;

    String[] cities ={"bangalore","mumbai","hyderabad","chennai","delhi","lucknow","kolkata","agra"};
    final Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                TextView editText= findViewById(R.id.datepickertextview);
                editText.setText(dayOfMonth+" "+monthOfYear +" "+year);
            }
        };

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                myCalendar.set(Calendar.MINUTE, minute);

                TextView tp1= findViewById(R.id.timepickertextView);
                tp1.setText(hourOfDay + ":" + minute );

            }
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> a= new ArrayAdapter<String>(this, android.R.layout.select_dialog_item,cities);

        AutoCompleteTextView a1 =(AutoCompleteTextView)findViewById(R.id.editTextTextPersoncity);

        a1.setThreshold(1);

        a1.setAdapter(a);

        a1.setTextColor(Color.RED);



        Button datePickerBtn=(Button) findViewById(R.id.date_picker);
        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=  new DatePickerDialog(MainActivity.this,R.style.MyDatePickerStyle, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

                TimePickerDialog timePickerDialog=  new TimePickerDialog(MainActivity.this,R.style.MyDatePickerStyle, timeSetListener, myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });

        Simple_t=(Button)findViewById(R.id.button3);
        custom_t=(Button)findViewById(R.id.button4);

        Simple_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hello this is simple",Toast.LENGTH_LONG).show();
            }
        });

        custom_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater i = getLayoutInflater();

                View layout= i.inflate(R.layout.custom_toast_layout,(ViewGroup)findViewById(R.id.customtoast));

                TextView t = layout.findViewById(R.id.textView5);
                ImageView img=layout.findViewById(R.id.imageView);

                t.setText("yo nigga");
                img.setImageResource(R.drawable.ic_launcher_background);

                Toast to = new Toast(getApplicationContext());
                to.setDuration(Toast.LENGTH_LONG);

                to.setView(layout);
                to.show();


            }
        });






    }


}