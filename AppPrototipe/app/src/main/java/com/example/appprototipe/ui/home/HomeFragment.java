package com.example.appprototipe.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appprototipe.ui.articulos.Productos;
import com.example.appprototipe.R;
import com.example.appprototipe.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ReciclerViewAdapter.ItemClickListener {

    private FragmentHomeBinding binding;
    ReciclerViewAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<Productos> listaProductos = new ArrayList<>();
        listaProductos.add(new Productos("Producto 1", "Descripcion 1", 5));
        listaProductos.add(new Productos("Producto 2", "Descripcion 2", 0));
        listaProductos.add(new Productos("Producto 3", "Descripcion 3", 2));
        listaProductos.add(new Productos("Producto 4", "Descripcion 4", 4));
        listaProductos.add(new Productos("Producto 5", "Descripcion 5", 0));
        listaProductos.add(new Productos("Producto 6", "Descripcion 6", 1));
        listaProductos.add(new Productos("Producto 7", "Descripcion 7", 3));
        listaProductos.add(new Productos("Producto 8", "Descripcion 8", 5));

        final RecyclerView recyclerView = binding.rvActivityMain;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(binding.rvActivityMain.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ReciclerViewAdapter(binding.rvActivityMain.getContext(), listaProductos);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        adapter.setLongClickListener(this);
        registerForContextMenu(binding.rvActivityMain);
        AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition);
        binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));

        return root;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void OnItemClick(View activista, int position) {
        Toast.makeText(binding.rvActivityMain.getContext(), "Has pulsado en: " + adapter.getItemId(position) + "el elemento: " + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
            case 7:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionProducto);
                break;

            case 1:
            case 8:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionProducto02);

                break;

            case 2:
            case 6:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionProducto03);

                break;

            case 3:
            case 4:
            case 5:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionProducto04);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Override
    public void OnLongItemClick(View activista, int position) {
        Toast.makeText(binding.rvActivityMain.getContext(), "Has pulsado largo  en: " + adapter.getItemId(position) + "el elemento largo : " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}