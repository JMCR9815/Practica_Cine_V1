package com.example.appprototipe;

import static android.content.SharedPreferences.Editor;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;
import static androidx.navigation.ui.NavigationUI.setupWithNavController;
import static com.example.appprototipe.R.id.action_compartir;
import static com.example.appprototipe.R.id.action_comprarEntradas;
import static com.example.appprototipe.R.id.action_verProducto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.appprototipe.databinding.ActivityMainBinding;
import com.example.appprototipe.ui.actionMenuItemsScreens.buyTicketActivity;
import com.example.appprototipe.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_shopping).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        setupActionBarWithNavController(this, navController, appBarConfiguration);
        setupWithNavController(binding.navView, navController);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.card_items_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        Editor editor = pref.edit();
        // Toast.makeText(this, String.valueOf(idItem), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case action_comprarEntradas:
                Intent intentoCompra = new Intent(MainActivity.this, buyTicketActivity.class);
                startActivity(intentoCompra);
                break;
            case action_compartir:
                Toast.makeText(getApplicationContext(), "Share Option Comming soon", Toast.LENGTH_SHORT).show();
                break;
            case action_verProducto:
                switch (pref.getInt("IdItem", -1)) {
                    case 0:
                        builderDialogIMDB("https://www.imdb.com/title/tt0338135/?ref_=nv_sr_srsg_0");
                        break;
                    case 1:
                        builderDialogIMDB("https://www.imdb.com/title/tt1045670/?ref_=fn_al_tt_1");
                        break;
                    case 2:
                        builderDialogIMDB("https://www.imdb.com/title/tt0424205/?ref_=fn_al_tt_1");
                        break;
                    case 3:
                        builderDialogIMDB("https://www.imdb.com/title/tt0140888/?ref_=fn_al_tt_1");
                        break;
                    case 4:
                        builderDialogIMDB("https://www.imdb.com/title/tt0470752/?ref_=fn_al_tt_1");
                        break;
                }
                break;
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    public void builderDialogIMDB(String enlace) {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
        builderDialog.setTitle(R.string.dialog_tittle);
        builderDialog.setMessage(R.string.mensaje_dialogWeb);
        builderDialog.setNegativeButton(R.string.decline_option, (dialog, which) -> Toast.makeText(MainActivity.this, R.string.decline_mensaje, Toast.LENGTH_SHORT).show());
        builderDialog.setPositiveButton(R.string.confim_option, (dialog, which) -> {
            Uri uri = Uri.parse(enlace);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            Toast.makeText(MainActivity.this, R.string.confirm_mensaje, Toast.LENGTH_SHORT).show();
        });
        builderDialog.show();

    }

}