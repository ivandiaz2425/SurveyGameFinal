package com.i034114.surveygame.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.i034114.surveygame.Utilities.Utilidades;

/**
 * Created by IVANCHO on 29/11/2017.
 */

public class ConexionSQLiteHelper  extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_ENCUESTA);
        db.execSQL(Utilidades.CREATE_TABLE_FAVOURITE);

        //db.execSQL(Utilidades.CREAR_TABLA_PREGUNTA);
        //db.execSQL(Utilidades.CREATE_TABLE_FAVORITOS);
        //db.execSQL(Utilidades.CREATE_TABLE_ENCPRE);
        //db.execSQL(Utilidades.CREATE_TABLE_USURES);


        db.execSQL("INSERT INTO encuesta (title, description) VALUES ('Test de Personalidad','Medir las características físicas, genéticas y sociales que reúne un individuo.')");
        db.execSQL("INSERT INTO encuesta (title, description) VALUES ('Test de Autoconciencia','Medir las características de su propio ser como persona.')");
        db.execSQL("INSERT INTO encuesta (title, description) VALUES ('Test de Equilibrio Emotivo','Medir las características de las respuestas emocionales adecuadas que un individuo brinda hacia el entorno que lo rodea.')");
        db.execSQL("INSERT INTO encuesta (title, description) VALUES ('Test de Amistad','Medir las características de la relación de afecto, simpatía y confianza que se establece entre personas que no son familia.')");
        db.execSQL("INSERT INTO encuesta (title, description) VALUES ('Test de Manejo de Estres ','Medir las características del estado de cansancio mental.')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ENCUESTA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_NAME_FAVOURITE);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PREGUNTA);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_FAVORITOS);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ENCPRE);
        //db.execSQL("DROP TABLE IF EXISTS "+Utilidades.CREATE_TABLE_USURES);

        onCreate(db);
    }
}

