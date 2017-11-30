package com.i034114.surveygame.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.i034114.surveygame.MainActivity;
import com.i034114.surveygame.Models.Encuesta;
import com.i034114.surveygame.Models.Usuario;
import com.i034114.surveygame.R;
import com.i034114.surveygame.Views.Register;

import java.util.ArrayList;

/**
 * Created by IVANCHO on 29/11/2017.
 */

public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder> {

    ArrayList<Encuesta> listaUsuario;
    Context context;

    public ListaPersonasAdapter(ArrayList<Encuesta> listaUsuario,Context context) {
        this.listaUsuario = listaUsuario;
        this.context = context;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_encuestas,null,false);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, final int position) {
        //holder.id.setText(listaUsuario.get(position).getIde().toString());
        holder.nombre.setText(listaUsuario.get(position).getTitle());
        holder.identificacion.setText(listaUsuario.get(position).getDescription());
        //holder.telefono.setText(listaUsuario.get(position).getTelefono());
        //holder.correo.setText(listaUsuario.get(position).getCorreo());
        //holder.password.setText(listaUsuario.get(position).getContrasena());
        holder.buttonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.buttonAllComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,identificacion;
        //,telefono,correo,password;
        Button buttonComment;
        Button buttonAllComment;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            //documento = (TextView) itemView.findViewById(R.id.textDocumento);
            nombre = (TextView) itemView.findViewById(R.id.title);
            identificacion = (TextView) itemView.findViewById(R.id.descripcion);
            //telefono = (TextView) itemView.findViewById(R.id.telefono);
            //correo = (TextView) itemView.findViewById(R.id.correo);
            //password = (TextView) itemView.findViewById(R.id.contraseña);
            buttonComment = (Button) itemView.findViewById(R.id.Preguntas);
            buttonAllComment = (Button) itemView.findViewById(R.id.Favoritos);

        }
    }
}
