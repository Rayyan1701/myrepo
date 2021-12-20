package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton b;
    Button b1;
    EditText e;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onCreate invoked");

        e=(EditText)findViewById(R.id.editTextTextPersonName);
        b1=(Button)findViewById(R.id.button);
        t=(TextView)findViewById(R.id.textView);

        b=(ImageButton)findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setBackground(getResources().getDrawable(R.drawable.dragonballz));
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();


                CharSequence s=  e.getText();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
               // t.setText(getResources().getString(R.string.app_name));
                t.setText(s);


            }
        });

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onStart invoked");
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onResume invoked");
    }



    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onPause invoked");
    }



    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onStop invoked");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "Destroy", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onDestroy invoked");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this, "Re-Start", Toast.LENGTH_SHORT).show();
        Log.d("lifecycle","onRestart invoked");
    }


}