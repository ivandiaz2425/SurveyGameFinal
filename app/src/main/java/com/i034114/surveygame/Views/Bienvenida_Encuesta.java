package com.i034114.surveygame.Views;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.i034114.surveygame.Adapters.ListaPersonasAdapter;
import com.i034114.surveygame.Helpers.ConexionSQLiteHelper;
import com.i034114.surveygame.Models.Encuesta;
import com.i034114.surveygame.Models.Usuario;
import com.i034114.surveygame.R;
import com.i034114.surveygame.Utilities.Utilidades;

import java.util.ArrayList;

public class Bienvenida_Encuesta extends AppCompatActivity {

    ArrayList<Encuesta> listaUsuario = new ArrayList<>();
    ListaPersonasAdapter listaPersonasAdapter;
    RecyclerView recyclerViewUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida__encuesta);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        recyclerViewUsuarios= (RecyclerView) findViewById(R.id.recyclerPersonas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewUsuarios.setLayoutManager(linearLayoutManager);


        consultarListaPersonas();


    }
    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Encuesta usuario=null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ENCUESTA,null);

        while (cursor.moveToNext()){
            usuario=new Encuesta();
            usuario.setIde(cursor.getInt(0));
            usuario.setTitle(cursor.getString(1));
            usuario.setDescription(cursor.getString(2));
            //usuario.setTelefono(cursor.getString(3));
            //usuario.setCorreo(cursor.getString(4));
            //usuario.setContrasena(cursor.getString(2));

            listaUsuario.add(usuario);
        }
        cursor.close();

        if (listaUsuario.size() != 0){
            processData();
        }else{
            Toast.makeText(this, "Lista vacia", Toast.LENGTH_SHORT).show();
        }
    }

    public void processData(){
        listaPersonasAdapter = new ListaPersonasAdapter(listaUsuario, getApplicationContext());
        recyclerViewUsuarios.setAdapter(listaPersonasAdapter);
    }

}
