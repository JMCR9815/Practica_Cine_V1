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
        productosDashBoard.add(new Productos("Producto 1", "Descripcion 1", 5));
        productosDashBoard.add(new Productos("Producto 2", "Descripcion 2", 0));
        productosDashBoard.add(new Productos("Producto 3", "Descripcion 3", 2));
        productosDashBoard.add(new Productos("Producto 4", "Descripcion 4", 4));
        productosDashBoard.add(new Productos("Producto 5", "Descripcion 5", 0));
        productosDashBoard.add(new Productos("Producto 6", "Descripcion 6", 1));
        productosDashBoard.add(new Productos("Producto 7", "Descripcion 7", 3));
        productosDashBoard.add(new Productos("Producto 8", "Descripcion 8", 5));

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