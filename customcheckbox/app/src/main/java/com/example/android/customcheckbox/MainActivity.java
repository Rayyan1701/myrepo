package com.example.android.customcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    Button b;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        c4=(CheckBox)findViewById(R.id.checkBox4);


        b=(Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder res = new StringBuilder();
                if(c1.isChecked())
                {
                    res.append("Feedback : Excellent\n");
                }
                else if(c2.isChecked())
                {
                    res.append("Feedback : Good\n");
                }
                else if(c3.isChecked())
                {
                    res.append("Feedback : Fair\n");
                }
                else
                {
                    res.append("Feedback : poor\n");
                }
                res.append("Suggestions : \n");


                RadioGroup r=(RadioGroup)findViewById(R.id.radioGroup);

                int id= r.getCheckedRadioButtonId();

                RadioButton rb=(RadioButton)findViewById(id);

                if(id==-1)
                {
                    res.append("No suggestion!");
                }
                else
                {
                    res.append(rb.getText()+"\n");
                }





                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });





    }
}