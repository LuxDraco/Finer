package com.smartti.finer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Datos extends AppCompatActivity {

    private EditText dEmail;
    private CheckBox cNegocio, cIndividual;
    private Button bFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        dEmail = findViewById(R.id.datosEmail);
        cNegocio = findViewById(R.id.datosCheckNegocio);
        cIndividual = findViewById(R.id.datosCheckIndividual);
        bFinalizar = findViewById(R.id.datosBtnFinalizar);



        //Email On text Changed
        dEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isValidEmail(s)) {
                    dEmail.setTextColor(getApplicationContext().getColor(R.color.verdeMat));
                }else {
                    dEmail.setTextColor(getApplicationContext().getColor(R.color.rojoMat));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Checkbox Negocio Checked
        cNegocio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(cIndividual.isChecked()) {
                        cIndividual.setChecked(false);
                    }
                }
            }
        });

        //Checkbox Individual Checked
        cIndividual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(cNegocio.isChecked()) {
                        cNegocio.setChecked(false);
                    }
                }
            }
        });

        //Finalizar on Click
        bFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Facial.class);
                startActivity(intent);
            }
        });

    }//Fin On Create

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
