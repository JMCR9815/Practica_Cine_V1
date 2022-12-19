package com.example.appprototipe.ui.shopping;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprototipe.R;
import com.example.appprototipe.databinding.FragmentShopsBinding;
import com.example.appprototipe.ui.actionMenuItemsScreens.Ticket;

import java.util.ArrayList;

public class ShoppingFragment extends Fragment implements ReciclerViewAdapter.ItemClickListener {

    private FragmentShopsBinding binding;
    ArrayList<Ticket> listaTickets = new ArrayList<>();
    ReciclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ShoppsViewModel notificationsViewModel = new ViewModelProvider(this).get(ShoppsViewModel.class);

        binding = FragmentShopsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final RecyclerView recyclerView = binding.rvShppingFragment;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(binding.rvShppingFragment.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ReciclerViewAdapter(binding.rvShppingFragment.getContext(), listaTickets);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        adapter.setLongClickListener(this);
        AnimationUtils.loadAnimation(binding.rvShppingFragment.getContext(), R.anim.fade_transition);
        Ticket ticket = generateTicket();
        listaTickets.add(ticket);

        return root;
    }

    public Ticket generateTicket() {
        SharedPreferences pref = ShoppingFragment.this.requireContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        String nombrePelicula = pref.getString("peliculaName", "");
        int numeroEntradas = pref.getInt("NumeroEntradas", 0);
        int numeroFila = pref.getInt("NumeroFila", 0);

        return new Ticket(nombrePelicula, numeroEntradas, numeroFila);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void OnItemClick(View activista, int position) {

    }

    @Override
    public void OnLongItemClick(View activista, int position) {

    }
}