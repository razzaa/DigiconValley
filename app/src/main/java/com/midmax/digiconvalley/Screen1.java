package com.midmax.digiconvalley;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.autofill.UserData;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Screen1 extends AppCompatActivity {
    int radioButtonID, selectedId, SpinnerId, spid;
    Button btn;
    TextView Name, Contact_NO;
    private RadioGroup radioGroup;
    private RadioButton radioButton, radiobtn1, radiobtn2;
    Spinner spinner;
    Intent recycle_intent;
    Model recycle_UserData,mymodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_screen1);
        btn = findViewById(R.id.button);
        Name = findViewById(R.id.editTextTextPersonName);
        Contact_NO = findViewById(R.id.editTextTextPersonName2);
        Contact_NO.setInputType(InputType.TYPE_CLASS_NUMBER);
        radioGroup = findViewById(R.id.radio_group);
        spinner = findViewById(R.id.spinner);
        radiobtn1 = findViewById(R.id.male);
        radiobtn2 = findViewById(R.id.female);
        spinner = findViewById(R.id.spinner);


        if(getIntent().getExtras() != null) {

            recycle_intent = getIntent();
            recycle_UserData = (Model) recycle_intent.getSerializableExtra("MyObject");
            Name.setText(recycle_UserData.getName());
            Contact_NO.setText(recycle_UserData.getContact());
            radioButton =  findViewById(recycle_UserData.getRadio_Button_Id());
            ((RadioButton)radioGroup.getChildAt(recycle_UserData.getRadio_Button_Id())).setChecked(true);
            spinner.setSelection(recycle_UserData.getSpinner_Id());
        }

//        print value end
        btn.setOnClickListener(new View.OnClickListener() {
            //        int checked=radioGroup.getCheckedRadioButtonId();
            @Override
            public void onClick(View view) {
                //Today Work
                if(getIntent().getExtras() != null){
                     mymodel =  (Model) recycle_intent.getSerializableExtra("MyObject");
                }else{
                     mymodel = new Model();
                }
                mymodel.setName(Name.getText().toString());
                mymodel.setContact(Contact_NO.getText().toString());
                //Get Selected Radio Button
                selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                int position = radioGroup.indexOfChild(radioButton);
                mymodel.setRadio_Button_Id(position);
                mymodel.setGender(radioButton.getText().toString());
                mymodel.setAge_Group(spinner.getSelectedItem().toString());
                mymodel.setSpinner_Id(spinner.getSelectedItemPosition());
                Intent intent = new Intent(Screen1.this, Activity1.class);
                intent.putExtra("MyObject",mymodel);
//                Toast.makeText(getApplicationContext(),mymodel.getFever(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}