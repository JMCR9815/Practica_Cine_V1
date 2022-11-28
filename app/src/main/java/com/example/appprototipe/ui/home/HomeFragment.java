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

import com.example.appprototipe.R;
import com.example.appprototipe.databinding.FragmentHomeBinding;
import com.example.appprototipe.ui.articulos.Productos;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ReciclerViewAdapter.ItemClickListener {

    private FragmentHomeBinding binding;
    ReciclerViewAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        List<Productos> listaProductos = new ArrayList<>();
        addItems(listaProductos);
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

    private void addItems(List<Productos> listaProductos) {
        listaProductos.add(new Productos("Les Invasiones Barbares", "16:00", 5));
        listaProductos.add(new Productos("Happy go Lucky", "18:30", 0));
        listaProductos.add(new Productos("Joyeux Noel", "17:20", 2));
        listaProductos.add(new Productos("Central do Brasil", "18:00", 4));
        listaProductos.add(new Productos("Ex Machina", "20:00", 0));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void OnItemClick(View activista, int position) {
        Toast.makeText(binding.rvActivityMain.getContext(), "Has pulsado en: " + adapter.getItemId(position) + "el elemento: " + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionPelicula01);
                break;
            case 1:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionPelicula02);
                break;
            case 2:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionPelicula03);
                break;

            case 3:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionPelicula04);
                break;
            case 4:
                binding.scrollView2.setVisibility(View.VISIBLE);
                binding.scrollView2.setAnimation(AnimationUtils.loadAnimation(binding.rvActivityMain.getContext(), R.anim.fade_transition));
                binding.textDescription.setText(R.string.descripcionPelciula05);
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