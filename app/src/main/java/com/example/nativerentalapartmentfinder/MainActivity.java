package com.example.nativerentalapartmentfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends Activity implements ViewTreeObserver.OnScrollChangedListener {
    public static final String EXTRA_MESSAGE = "heelo";

    // scrollview
    ScrollView scrollView;
    // radio button
    RadioGroup radioGroup;
    Button btnApply;
    // two buttons
    Button bt_submit;
    //initialize variable
    EditText propertyName,propertyAddress,propertyType,bedroom,datetime,monthlyPrice,note,nameReporter;
    // check all text fields
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //scrollview
        scrollView = findViewById(R.id.scrollview);
        scrollView.getViewTreeObserver().addOnScrollChangedListener(this);
        // radio
        radioGroup = findViewById(R.id.radioGroup);

        btnApply = findViewById(R.id.button_apply);

        int id =  radioGroup.getCheckedRadioButtonId();

        RadioButton radio = findViewById(id);
        String stringChoice = radio.getText().toString();

        Toast.makeText(this,"You choice : "+stringChoice,Toast.LENGTH_SHORT).show();
        /// check require
        bt_submit = findViewById(R.id.bt_submit);
        // handle the bt_submit button
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //Save the result and check  the information
                isAllFieldsChecked = CheckAllFields();

                if (isAllFieldsChecked)
                {
                    Intent  intent = new Intent(MainActivity.this, MainActivity2.class);
                    EditText editText = (EditText) findViewById(R.id.propertyname);
                    String message = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, message);

                    startActivity(intent);
                }
            }
        });
        //Assign variable
        propertyName = findViewById(R.id.propertyname);
        propertyAddress = findViewById(R.id.propertyaddress);
        propertyType = findViewById(R.id.propertytype);
        bedroom= findViewById(R.id.bedrooms);
        datetime= findViewById(R.id.datetime);
        monthlyPrice= findViewById(R.id.monthlyrentprice);
        note= findViewById(R.id.notes);
        nameReporter= findViewById(R.id.nameofthereporter);

        // Initialize val Style





    }

    public  void apply(View v){
        int id =  radioGroup.getCheckedRadioButtonId();

        RadioButton radio = findViewById(id);
        String stringChoice = radio.getText().toString();

        Toast.makeText(this,"You choice : "+stringChoice,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onScrollChanged() {
    }
    private boolean CheckAllFields() {
        if (propertyName.length() == 0) {
            propertyName.setError("Please fill in the information");
            return false;
        }

        if (propertyAddress.length() == 0) {
            propertyAddress.setError("Please fill in the information");
            return false;
        }

        if (propertyType.length() == 0) {
            propertyType.setError("Please fill in the information");
            return false;
        }

        if (bedroom.length() == 0) {
            bedroom.setError("Please fill in the information");
            return false;
        }
        if (datetime.length() == 0) {
            datetime.setError("Please fill in the information");
            return false;
        }
        if (monthlyPrice.length() == 0) {
            monthlyPrice.setError("Please fill in the information");
            return false;
        }

        if (note.length() == 0) {
            note.setError("Please fill in the information");
            return false;
        }
        if (nameReporter.length() == 0) {
            nameReporter.setError("Please fill in the information");
            return false;
        }
        return true;
    }
}