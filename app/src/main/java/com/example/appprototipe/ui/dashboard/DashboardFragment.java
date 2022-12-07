package com.example.appprototipe.ui.dashboard;

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
import com.example.appprototipe.databinding.FragmentDashboardBinding;
import com.example.appprototipe.ui.articulos.Productos;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements ReciclerViewAdapterDashBoard.ItemClickListener {

    private FragmentDashboardBinding binding;
    private List<Productos> productosDashBoard;
    ReciclerViewAdapterDashBoard adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final RecyclerView recyclerView = binding.rvActivityDash;
        recyclerView.setHasFixedSize(true);
        productosDashBoard = new ArrayList<>();
        productosDashBoard.add(new Productos("Les Invasiones Barbares", "16:00", 5,R.mipmap.img_pelicula_uno));
        productosDashBoard.add(new Productos("Happy go Lucky", "18:30", 0,R.mipmap.img_pelicula_dos));
        productosDashBoard.add(new Productos("Joyeux Noel", "17:20", 2,R.mipmap.img_pelicula_tres));
        productosDashBoard.add(new Productos("Central do Brasil", "18:00", 4,R.mipmap.img_pelicula_cuatro));
        productosDashBoard.add(new Productos("Ex Machina", "20:00", 0,R.mipmap.img_pelicula_cinco));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(binding.rvActivityDash.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ReciclerViewAdapterDashBoard(binding.rvActivityDash.getContext(), productosDashBoard);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        adapter.setLongClickListener(this);
        registerForContextMenu(binding.rvActivityDash);
        AnimationUtils.loadAnimation(binding.rvActivityDash.getContext(), R.anim.fade_transition);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);


        return root;
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