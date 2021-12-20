package com.example.android.radio_button;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.radio_button.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RelativeLayout rl;
    RadioButton rb1,rb2;

    final CharSequence[] colors = { "Pink", "Red", "Yellow", "Blue" };
    ArrayList<Integer> slist = new ArrayList();
    boolean icount[] = new boolean[colors.length];
    String msg ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = new RadioGroup(this);
        rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);

        rb1.setText("Male");
        rb2.setText("Female");
        rg.addView(rb1);
        rg.addView(rb2);
        rg.setOrientation(RadioGroup.HORIZONTAL);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int)RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin =150;
        params.topMargin = 100;

        rg.setLayoutParams(params);
        rl.addView(rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });

        Button b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder obj = new AlertDialog.Builder(MainActivity.this);

                obj.setMessage("Close app");

                obj.setCancelable(true);
                obj.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                obj.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this,"Back to the APP",Toast.LENGTH_LONG).show();

                    }
                });

                obj.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Cancel clicked",Toast.LENGTH_LONG).show();
                    }
                });

                AlertDialog o= obj.create();
                o.show();



            }
        });
        
        
        Button b2=(Button)findViewById(R.id.button2);
        
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder obj1= new  AlertDialog.Builder(MainActivity.this);

                obj1.setTitle("Choose Color!");

                obj1.setMultiChoiceItems(colors, icount, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {

                            slist.add(i);
                        } else if (slist.contains(i)) {

                            slist.remove(Integer.valueOf(i));
                        }
                    }
                });
                obj1.setCancelable(true);
                obj1.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i1) {
                        msg = "";
                        for (int i = 0; i < slist.size(); i++)
                        {
                            msg = msg + "\n" + (i + 1) + " : " + colors[slist.get(i)];
                        }

                        Toast.makeText(getApplicationContext(), "Total " + slist.size() + " Items Selected.\n" + msg, Toast.LENGTH_SHORT).show();
                }});

                obj1.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog o1= obj1.create();

                o1.show();





            }
        });

    }
}
