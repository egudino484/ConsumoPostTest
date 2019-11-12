package com.egudino.app.consumoposttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtemail, txtpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtemail = findViewById(R.id.txtusuario);
        txtpassword = findViewById(R.id.txtpassword);
        btnlogin= findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consumirServicio();

            }
        });


    }

    public void consumirServicio(){
        // ahora ejecutaremos el hilo creado
        String email= txtemail.getText().toString();
        String password= txtpassword.getText().toString();
        //URL----> https://reqres.in/api/login
        //request
        // {
        //    "email": "eve.holt@reqres.in",
        //    "password": "cityslicka"
        //}
        //response
        //{
        //    "email": "eve.holt@reqres.in",
        //    "password": "cityslicka"
        //}


        ServicioTask servicioTask= new ServicioTask(this,"https://reqres.in/api/login",email,password);
        servicioTask.execute();



    }
}
