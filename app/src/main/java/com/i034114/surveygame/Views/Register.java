package com.i034114.surveygame.Views;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.i034114.surveygame.Helpers.ConexionSQLiteHelper;
import com.i034114.surveygame.R;
import com.i034114.surveygame.Utilities.Utilidades;

public class Register extends AppCompatActivity {

    EditText campoNombre,campoCC,campoTelefono, campoCorreo, campoPassword;

    Button btn_Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        campoNombre= (EditText) findViewById(R.id.name);
        campoCC= (EditText) findViewById(R.id.Identificacion);
        campoTelefono= (EditText) findViewById(R.id.Phone);
        campoCorreo = (EditText) findViewById(R.id.email);
        campoPassword = (EditText) findViewById(R.id.password);


        btn_Return = (Button) findViewById(R.id.btn_Return);
        btn_Return.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Return();
            }
        });

    }

    private void Return() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void onClick(View view) {

        String stringName = campoNombre.getText().toString();
        String stringCC = campoCC.getText().toString();
        String stringPhone = campoTelefono.getText().toString();
        String stringEmail =  campoCorreo.getText().toString();
        String stringPass = campoPassword.getText().toString();

        if (TextUtils.isEmpty(stringName)){
            Toast.makeText(this, "El campo de nombre esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringCC)){
            Toast.makeText(this, "El campo de identificacion esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPhone)){
            Toast.makeText(this, "El campo de telefono esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringEmail)){
            Toast.makeText(this, "El campo de email esta vacio", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stringPass)){
            Toast.makeText(this, "El campo de password esta vacio", Toast.LENGTH_SHORT).show();
        }else{
            registrarUsuarios();
        }

        //registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+ Utilidades.TABLA_USUARIO
                +" ( " +Utilidades.TABLA_FIELD_NAME+","+Utilidades.TABLA_FIELD_CC+","+Utilidades.TABLA_FIELD_PHONE+","+Utilidades.TABLA_FIELD_EMAIL+","+Utilidades.TABLA_FIELD_PASS+")" +
                " VALUES ("+campoNombre.getText().toString()+", '"+campoCC.getText().toString()+"','"
                +campoTelefono.getText().toString()+"','"+campoCorreo.getText().toString()+"','"+campoPassword.getText().toString()+"')";

        db.execSQL(insert);


        db.close();
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.TABLA_FIELD_NAME,campoNombre.getText().toString());
        values.put(Utilidades.TABLA_FIELD_CC,campoCC.getText().toString());
        values.put(Utilidades.TABLA_FIELD_PHONE,campoTelefono.getText().toString());
        values.put(Utilidades.TABLA_FIELD_EMAIL,campoCorreo.getText().toString());
        values.put(Utilidades.TABLA_FIELD_PASS,campoPassword.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.TABLA_FIELD_IDU,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
