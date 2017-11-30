package com.i034114.surveygame.Utilities;

/**
 * Created by IVANCHO on 29/11/2017.
 */

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO = "usuario";
    public static final String TABLA_FIELD_IDU = "id";
    public static final String TABLA_FIELD_NAME = "nombre";
    public static final String TABLA_FIELD_CC = "identificacion";
    public static final String TABLA_FIELD_PHONE = "telefono";
    public static final String TABLA_FIELD_EMAIL = "correo";
    public static final String TABLA_FIELD_PASS = "contrasena";
    public static final String CREAR_TABLA_USUARIO =
            "CREATE TABLE "+ TABLA_USUARIO+" ("+
                    TABLA_FIELD_IDU+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                    TABLA_FIELD_NAME+" TEXT NOT NULL UNIQUE, "+
                    TABLA_FIELD_CC+" TEXT NOT NULL, "+
                    TABLA_FIELD_PHONE+" TEXT NOT NULL, "+
                    TABLA_FIELD_EMAIL+" TEXT NOT NULL," +
                    TABLA_FIELD_PASS +" TEXT NOT NULL)";

    //Constantes campos tabla encuesta
    public static final String TABLA_ENCUESTA = "encuesta";
    public static final String TABLA_FIELD_IDE = "ide";
    public static final String TABLA_FIELD_TITLE = "title";
    public static final String TABLA_FIELD_DESCRIPTION = "description";
    public static final String CREAR_TABLA_ENCUESTA =
            "CREATE TABLE "+ TABLA_ENCUESTA+" ("+
                    TABLA_FIELD_IDE+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                    TABLA_FIELD_TITLE+" TEXT NOT NULL, "+
                    TABLA_FIELD_DESCRIPTION +" TEXT NOT NULL)";


    public static final String TABLA_NAME_FAVOURITE = "FAVOURITE";
    public static final String TABLA_FAVOURITE_ID = "ID";
    public static final String TABLA_FAVOURITE_ID_USER = "ID_USER";
    public static final String TABLA_FAVOURITE_ID_ENCU = "ID_ENCU";
    public static final String CREATE_TABLE_FAVOURITE =
            "CREATE TABLE " + TABLA_NAME_FAVOURITE + " (" +
                    TABLA_FAVOURITE_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    TABLA_FAVOURITE_ID_USER + " INTEGER NOT NULL, " +
                    TABLA_FAVOURITE_ID_ENCU + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(`ID_USER`) REFERENCES usuario, " +
                    "FOREIGN KEY(`ID_ENCU`) REFERENCES encuesta)"; 


    //Constantes campos tabla Pregunta
    /*public static final String TABLA_PREGUNTA = "pregunta";
    public static final String TABLA_FIELD_IDP = "idp";
    public static final String TABLA_FIELD_TITLEP = "titlep";
    public static final String CREAR_TABLA_PREGUNTA =
            "CREATE TABLE "+ TABLA_PREGUNTA+" ("+
                    TABLA_FIELD_IDP+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_TITLEP+" TEXT, ";

    //Constantes campos tabla Favorito_Encuesta
    public static final String TABLA_FAVORITOS = "favoritos";
    public static final String TABLA_FIELD_IDF = "idf";
    public static final String TABLA_FIELD_IDUSER = "id_usuario";
    public static final String TABLA_FIELD_IDENCUE = "id_encuesta";
    public static final String CREATE_TABLE_FAVORITOS =
            "CREATE TABLE "+ TABLA_FAVORITOS+" ("+
                    TABLA_FIELD_IDF+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_TITLE+" TEXT, "+
                    TABLA_FIELD_IDUSER+" INTEGER, "+
                    TABLA_FIELD_IDENCUE+" INTEGER)";


    //Constantes campos tabla Pregunta_Encuesta
    public static final String TABLA_ENCPRE = "encpre";
    public static final String TABLA_FIELD_IDRE = "idenc";
    public static final String TABLA_FIELD_IDPRE = "id_pregunta";
    public static final String TABLA_FIELD_IDENCU = "id_encuesta";
    public static final String CREATE_TABLE_ENCPRE =
            "CREATE TABLE "+ TABLA_ENCPRE+" ("+
                    TABLA_FIELD_IDRE+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_IDPRE+" INTEGER, "+
                    TABLA_FIELD_IDENCU+" INTEGER)";


    //Constantes campos tabla Usuarios_Respuesta
    public static final String TABLA_USURES = "usures";
    public static final String TABLA_FIELD_IDPR = "idusupre";
    public static final String TABLA_FIELD_VAL = "valor";
    public static final String TABLA_FIELD_IDPREG = "id_pregunta";
    public static final String TABLA_FIELD_IDUSUR = "id_usuario";
    public static final String CREATE_TABLE_USURES =
            "CREATE TABLE "+ TABLA_USURES+" ("+
                    TABLA_FIELD_IDPR+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    TABLA_FIELD_VAL+" INTEGER, "+
                    TABLA_FIELD_IDPREG+" INTEGER, "+
                    TABLA_FIELD_IDUSUR+" INTEGER)";

                    */



}
