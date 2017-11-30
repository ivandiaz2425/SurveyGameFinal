package com.i034114.surveygame.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.i034114.surveygame.Helpers.ConexionSQLiteHelper;
import com.i034114.surveygame.MainActivity;
import com.i034114.surveygame.R;
import com.i034114.surveygame.Utilities.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    public int id;
    Button btn_Register;
    EditText campoNombre,campoPassword;
    private Cursor fila;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        campoNombre= (EditText) findViewById(R.id.UserName);
        campoPassword= (EditText) findViewById(R.id.Password);

        btn_Register = (Button) findViewById(R.id.btn_Register);
        btn_Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void onClickLog(View view) {

        switch (view.getId()){
            case R.id.btn_Login:
                //consultarSql();
                login();
                break;

        }

    }

   /* private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoNombre.getText().toString()};
        String[] parametros1={campoPassword.getText().toString()};
        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+ Utilidades.TABLA_FIELD_NAME+","+Utilidades.TABLA_FIELD_PASS+
                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.TABLA_FIELD_NAME+"=? ",parametros);

            //Toast.makeText(getApplicationContext(),"El documento existe",Toast.LENGTH_LONG).show();

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoPassword.setText(cursor.getString(1));
            campoNombre.setText("");
            campoPassword.setText("");

            Intent intent = new Intent(this, Bienvenida_Encuesta.class);
            startActivity(intent);


        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_LONG).show();

        }

    }*/

    public boolean getUser(String name, Integer pass) {

        String selectQuery = "select * from  " + Utilidades.TABLA_USUARIO + " where " +
                Utilidades.TABLA_FIELD_NAME + " = " + "'" + name + "'" + " and " + Utilidades.TABLA_FIELD_PASS+ " = " + pass;

        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext()) {

            id = cursor.getInt(0);


            if (cursor.getCount() > 0) {

                return true;
            }

        }

        cursor.close();
        db.close();

        return false;
    }

    private void login() {


        Session a = new Session(this);
        String name = campoNombre.getText().toString();
        Integer pass = Integer.parseInt(campoPassword.getText().toString());


        if (getUser(name, pass)) {
            a.setLoggedin(true, name, pass);
            a.setId(id);
            Intent intent = new Intent(this, Bienvenida_Encuesta.class);

            startActivity(intent);



            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
        }
    }



}