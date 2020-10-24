package com.midmax.digiconvalley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {
    EditText any_other;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Button button, back_button;
    Intent recycle_intent;
    Model recycle_UserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        any_other = findViewById(R.id.any_ohter);
        checkBox1 = findViewById(R.id.fever);
        checkBox2 = findViewById(R.id.headache);
        checkBox3 = findViewById(R.id.sour_throat);
        checkBox4 = findViewById(R.id.abdomainal_pain);
        checkBox5 = findViewById(R.id.fatigue);
        button = findViewById(R.id.next_button);
        back_button = findViewById(R.id.back_button);
        if (getIntent().getExtras() != null) {

            recycle_intent = getIntent();
            recycle_UserData = (Model) recycle_intent.getSerializableExtra("MyObject");
            if (recycle_UserData.getFever() != null) {
                checkBox1.setChecked(true);
            }
            if (recycle_UserData.getHead_Ache() != null) {
                checkBox2.setChecked(true);
            }
            if (recycle_UserData.getSour_Throat() != null) {
                checkBox3.setChecked(true);
            }
            if (recycle_UserData.getAbdominal_Pain() != null) {
                checkBox4.setChecked(true);
            }
            if (recycle_UserData.getFatigue() != null) {
                checkBox5.setChecked(true);
            }
            if(recycle_UserData.getAny_Other_Symtoms()!=null){
                any_other.setText(recycle_UserData.getAny_Other_Symtoms());
            }

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean fever = ((CheckBox) findViewById(R.id.fever)).isChecked();
                boolean headache = ((CheckBox) findViewById(R.id.headache)).isChecked();
                boolean sour_throat = ((CheckBox) findViewById(R.id.sour_throat)).isChecked();
                boolean abdomainal_pain = ((CheckBox) findViewById(R.id.abdomainal_pain)).isChecked();
                boolean fatigue = ((CheckBox) findViewById(R.id.fatigue)).isChecked();

                //Today Work 25 September 2020
                Intent inte = new Intent(Activity1.this, Activity2.class);
                Intent intent = getIntent();
                Model UserData = (Model) intent.getSerializableExtra("MyObject");
                //get data from activity 0 object
//                    Model Activity1Model = new Model();
                if (fever) {
                    UserData.setFever(checkBox1.getText().toString());
                }
                if (headache) {
                    UserData.setHead_Ache(checkBox2.getText().toString());
                }
                if (sour_throat) {
                    UserData.setSour_Throat(checkBox3.getText().toString());
                }
                if (abdomainal_pain) {
                    UserData.setAbdominal_Pain(checkBox4.getText().toString());
                }
                if (fatigue) {
                    UserData.setFatigue(checkBox5.getText().toString());
                }
                if (any_other.getText().length() > 0) {
                    UserData.setAny_Other_Symtoms(any_other.getText().toString());
                }
//                    Activity1Model.setName(UserData.getName());
//                    Activity1Model.setContact(UserData.getContact());
//                    Activity1Model.setGender(UserData.getGender());
//                    Activity1Model.setAge_Group(UserData.getAge_Group());
//                    Activity1Model.setSpinner_Id(UserData.getSpinner_Id());
//                    Activity1Model.setRadio_Button_Id(UserData.getRadio_Button_Id());
                inte.putExtra("MyObject", UserData);

                startActivity(inte);

            }
        });


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}