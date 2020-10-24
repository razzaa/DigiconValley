package com.midmax.digiconvalley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText text;
    CheckBox checkBox1,checkBox2;
    Button back,submit;
    Intent recycle_intent;
    Model recycle_UserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        checkBox1=findViewById(R.id.high_blood_pressure);
        checkBox2=findViewById(R.id.diabets);
        back=findViewById(R.id.back_button);
        submit=findViewById(R.id.submit);
        text=findViewById(R.id.text);

        if(getIntent().getExtras() != null) {

            recycle_intent = getIntent();
            recycle_UserData = (Model) recycle_intent.getSerializableExtra("MyObject");
            try{
                if(recycle_UserData.getHigh_Blood_Pressure().equals("High Blood Pressure")){
                    checkBox1.setChecked(true);
                }
            }catch (NullPointerException e){

            }
            try{
                if(recycle_UserData.getDiabetes().equals("Diabetes")){
                    checkBox2.setChecked(true);
                }
            }catch (NullPointerException e){

            }

            if (text.getText().toString()!=null) {
                text.setText(recycle_UserData.getAllergies());
            }

        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean vitals = ((CheckBox) findViewById(R.id.high_blood_pressure)).isChecked();
                boolean diabets = ((CheckBox) findViewById(R.id.diabets)).isChecked();

                //Today Work 25 September
                Intent inte = new Intent(Activity2.this, Activity3.class);
                Intent intent = getIntent();
                Model UserData = (Model) intent.getSerializableExtra("MyObject");
                //get data from activity 1 object
               // Model Activity1Mode2 = new Model();

//                //Activity 0 Data
//                Activity1Mode2.setName(UserData.getName());
//                Activity1Mode2.setContact(UserData.getContact());
//                Activity1Mode2.setGender(UserData.getGender());
//                Activity1Mode2.setAge_Group(UserData.getAge_Group());
//                Activity1Mode2.setSpinner_Id(UserData.getSpinner_Id());
//                Activity1Mode2.setRadio_Button_Id(UserData.getRadio_Button_Id());
//
//                //Activity 1 data
//                Activity1Mode2.setFever(UserData.getFever());
//                Activity1Mode2.setHead_Ache(UserData.getHead_Ache());
//                Activity1Mode2.setSour_Throat(UserData.getSour_Throat());
//                Activity1Mode2.setAbdominal_Pain(UserData.getAbdominal_Pain());
//                Activity1Mode2.setFatigue(UserData.getFatigue());
//                Activity1Mode2.setAny_Other_Symtoms(UserData.getAny_Other_Symtoms());
//               //---------------------

                //Activity 3 Data
                if (vitals) {
                    UserData.setHigh_Blood_Pressure(checkBox1.getText().toString());
                }
                if (diabets) {
                    UserData.setDiabetes(checkBox2.getText().toString());
                }
                if(text.getText().length()>0){
                    UserData.setAllergies(text.getText().toString());
                }

                //------------------
                inte.putExtra("MyObject",UserData);
//                Toast.makeText(getApplicationContext(), UserData.getName().toString()+"set", Toast.LENGTH_SHORT).show();
                startActivity(inte);
                }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}