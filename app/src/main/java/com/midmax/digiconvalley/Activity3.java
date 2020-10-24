package com.midmax.digiconvalley;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    String HighBloodPressureTxt,DiabetesTxt;
    int radioButtonID,SpinnerId;
    TextView name,other_sy;
    TextView cont;
    TextView gen;
    TextView age;
    TextView basic_symt;
    TextView vitals;
    String other_symt;
    CheckBox checkBox1,checkBox2;
    Button editButton;
    String AllVitals;
    String Name,Contact_NO,Gender,AgeGroup,Vitals,Symtoms;
    String FeverTxt,HeadAcheTxt,SourThroatTxt,AbdominalPainTxt,FatigueTxt,Other_vitals;
    Intent intent;
    Model UserData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        editButton=findViewById(R.id.editButton);
        name=findViewById(R.id.name);
        cont=findViewById(R.id.ContactNo);
        gen=findViewById(R.id.Gender);
        age=findViewById(R.id.AgeGroup);
        basic_symt=findViewById(R.id.BasciSymtomsCheckBoxText);
        vitals=findViewById(R.id.VitalsIfChecked);
        other_sy=findViewById(R.id.other_smmm);

        intent = getIntent();
        UserData = (Model) intent.getSerializableExtra("MyObject");
        name.setText(UserData.getName());
        cont.setText(UserData.getContact());
        gen.setText(UserData.getGender());
        age.setText(UserData.getAge_Group());
        String AllSymt="";
        if(UserData.getFever()!=null){
             AllSymt+=UserData.getFever();
        }
        if(UserData.getHead_Ache()!=null){
            AllSymt+=UserData.getHead_Ache();
        }
        if(UserData.getSour_Throat()!=null){
            AllSymt+=UserData.getSour_Throat();
        }
        if(UserData.getFatigue()!=null){
            AllSymt+=UserData.getFatigue();
        }
        if(UserData.getAbdominal_Pain()!=null){
            AllSymt+=UserData.getAbdominal_Pain();
        }

        basic_symt.setText(AllSymt);
        String AllVitals="";
        if(UserData.getAllergies()!=null){
            AllVitals+=UserData.getAllergies();
        }
        if(UserData.getHigh_Blood_Pressure()!=null){
            AllVitals+=UserData.getHigh_Blood_Pressure();
        }
        if(AllVitals!=""){
            vitals.setText(AllVitals);
        }
        else{
            vitals.setText("");
        }
        if(UserData.getAny_Other_Symtoms()!=null){
            other_sy.setText(UserData.getAny_Other_Symtoms());
        }
        else{
            other_sy.setText("");
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Today Work 25 September
                Intent inte = new Intent(Activity3.this, Screen1.class);

                //------------------
                inte.putExtra("MyObject",UserData);
                startActivity(inte);
            }
        });

    }
}