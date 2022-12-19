package com.example.appprototipe.ui.shopping;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprototipe.R;
import com.example.appprototipe.ui.actionMenuItemsScreens.Ticket;

import java.util.List;

public class ReciclerViewAdapter extends RecyclerView.Adapter<ReciclerViewAdapter.ViewHolder> {

    private final List<Ticket> myData;
    private final LayoutInflater myInflater;
    private static ItemClickListener myClickListener;


    public ReciclerViewAdapter(Context context, List<Ticket> myData) {
        this.myData = myData;
        this.myInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View parten = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(parten);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String nombreProducto = "Titulo: " + getString(holder, position).getNombrePelicula().toString();
        String numeroEntradas = "Entradas: " + getString(holder, position).getNumeroEntradas();
        String numeroFila = "Fila: " + getString(holder, position).getNumeroFila();
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(myInflater.getContext(), R.anim.fade_transition));

        holder.tituloPelicula.setText("fewwfw");


    }


    @NonNull
    private Ticket getString(@NonNull ViewHolder holder, int position) {
        Ticket ticket = myData.get(position);
        String peliculaTitulo = ticket.getNombrePelicula();
        /*switch (position) {
            case 0: {
                holder.imagen.setImageResource(R.mipmap.img_pelicula_uno);
                break;
            }
            case 1: {
                holder.imagen.setImageResource(R.mipmap.img_pelicula_dos);
                break;
            }
            case 2: {
                holder.imagen.setImageResource(R.mipmap.img_pelicula_tres);
                break;
            }
            case 3: {
                holder.imagen.setImageResource(R.mipmap.img_pelicula_cuatro);
                break;
            }
            case 4: {
                holder.imagen.setImageResource(R.mipmap.img_pelicula_cinco);
                break;
            }
        }*/
        return ticket;
    }


    @Override
    public int getItemCount() {
        return myData.size();
    }

    public Ticket getProductById(int itemId) {
        Ticket ticket = myData.get(itemId);
        return ticket;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final ImageView imagen;
        final TextView tituloPelicula;
        final TextView myTextView;
        final TextView textDescription;
        final CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_ticket);
            tituloPelicula = itemView.findViewById(R.id.tticket_titulo_pelicula);
            myTextView = itemView.findViewById(R.id.ticket_entradas);
            textDescription = itemView.findViewById(R.id.ticket_fila);
            cardView = itemView.findViewById(R.id.cardLayout);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (myClickListener != null) myClickListener.OnItemClick(v, getAdapterPosition());

        }


        @Override
        public boolean onLongClick(View v) {
            if (myClickListener != null) myClickListener.OnLongItemClick(v, getAdapterPosition());
            return false;
        }


    }

    void setClickListener(ItemClickListener itemClickListener) {
        myClickListener = itemClickListener;
    }

    void setLongClickListener(ItemClickListener itemClickListener) {
        myClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void OnItemClick(View activista, int position);

        void OnLongItemClick(View activista, int position);
    }

}
