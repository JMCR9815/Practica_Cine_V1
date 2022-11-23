package com.example.appprototipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appprototipe.ui.splashScreen.Splash;

public class MainClass extends AppCompatActivity {
    ImageButton imagenInstituto, imagenClassRoom, imagenRayuela, imagenCine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_class);
        imagenInstituto = findViewById(R.id.imageButtonInstituto);
        imagenClassRoom = findViewById(R.id.imageButtonClassRoom);
        imagenRayuela = findViewById(R.id.imageButtonRayuela);
        imagenCine = findViewById(R.id.imageButtonCine);

        imagenInstituto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builderDialogInstituto();
            }
        });

        imagenRayuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApps("es.educarex.rayuela");
            }
        });

        imagenClassRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openApps("com.google.android.apps.classroom");
            }
        });

        imagenCine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainClass.this, Splash.class);
                startActivity(intent);
                Toast.makeText(MainClass.this, "Accedienado al cine ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openApps(String appPackageName) {
        try {
            startActivity(getPackageManager().getLaunchIntentForPackage(appPackageName));
            //ComponentName name = new ComponentName(appPackageName,
            //        appPackageName + ".MainActivity");
            //Intent intent = new Intent(Intent.ACTION_MAIN);

            //intent.addCategory(Intent.CATEGORY_LAUNCHER);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
            //       Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            //intent.setComponent(name);
            //startActivity(intent);

            Toast.makeText(MainClass.this, "Intentando abrir la App", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(MainClass.this, "No se ha podido abrir", Toast.LENGTH_SHORT).show();
            builderDialogApp(appPackageName);
        }
    }


    public void builderDialogApp(String appPackageName) {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
        builderDialog.setTitle(R.string.dialog_tittle);
        builderDialog.setMessage(R.string.mensaje_AppNotExist);
        builderDialog.setNegativeButton(R.string.decline_optionAplicacion, (dialog, which) -> Toast.makeText(MainClass.this, R.string.decline_mensaje, Toast.LENGTH_SHORT).show());
        builderDialog.setPositiveButton(R.string.confim_optionAplicacion, (dialog, which) -> {

            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                Toast.makeText(MainClass.this, "Abriendo Play Store", Toast.LENGTH_SHORT).show();
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });
        builderDialog.show();

    }

    public void builderDialogInstituto() {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(this);
        builderDialog.setTitle(R.string.dialog_tittle);
        builderDialog.setMessage(R.string.mensaje_dialogWeb);
        builderDialog.setNegativeButton(R.string.decline_option, (dialog, which) -> Toast.makeText(MainClass.this, R.string.decline_mensaje, Toast.LENGTH_SHORT).show());
        builderDialog.setPositiveButton(R.string.confim_option, (dialog, which) -> {
            Uri uri = Uri.parse("https://iesarroyoharnina.educarex.es/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            Toast.makeText(MainClass.this, R.string.confirm_mensaje, Toast.LENGTH_SHORT).show();
        });
        builderDialog.show();

    }
}
