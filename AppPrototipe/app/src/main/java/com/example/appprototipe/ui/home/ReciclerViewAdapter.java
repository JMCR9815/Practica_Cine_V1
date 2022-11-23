package com.example.appprototipe.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprototipe.R;
import com.example.appprototipe.ui.articulos.Productos;

import java.util.List;

public class ReciclerViewAdapter extends RecyclerView.Adapter<ReciclerViewAdapter.ViewHolder> {

    private final List<Productos> myData;
    private final LayoutInflater myInflater;
    private static ItemClickListener myClickListener;


    public ReciclerViewAdapter(Context context, List<Productos> myData) {
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

        String nombreProducto = getString(holder, position).getNombre();
        String descripcionProducto = getString(holder, position).getDescripcion();
        int calificacionProducto = getString(holder, position).getCalificacion();
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(myInflater.getContext(), R.anim.fade_transition));

        holder.myTextView.setText(nombreProducto);
        holder.descripcionProducto.setText(descripcionProducto);
        holder.calificacionProducto.setNumStars(5);
        holder.calificacionProducto.setRating(calificacionProducto);

    }


    @NonNull
    private Productos getString(@NonNull ViewHolder holder, int position) {
        Productos producto = myData.get(position);
        holder.imagen.setImageResource(R.mipmap.producto_prueba_launcher_foreground);
        return producto;
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final ImageView imagen;
        final TextView myTextView;
        final TextView descripcionProducto;
        final RatingBar calificacionProducto;
        final TextView textDescription;
        final CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenProducto1);
            myTextView = itemView.findViewById(R.id.nombreProducto1);
            descripcionProducto = itemView.findViewById(R.id.descripcionProducto);
            calificacionProducto = itemView.findViewById(R.id.calificacionProducto);
            textDescription = itemView.findViewById(R.id.textDescription);
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
