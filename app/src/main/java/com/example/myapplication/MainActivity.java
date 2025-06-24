// Archivo: app/src/main/java/com/example/myapplication/MainActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Este es tu activity_main.xml actual

        // Configurar la card de categorías como botón
        MaterialCardView cardCategories = findViewById(R.id.cardCategories);
        cardCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la NUEVA Activity que hospeda el fragmento de categorías
                Intent intent = new Intent(MainActivity.this, CategoriesListActivity.class); // <-- CAMBIO AQUÍ
                startActivity(intent);
            }
        });

        // Tu lógica para la card de información (cardInfo) permanece igual

        /*
        MaterialCardView cardInfo = findViewById(R.id.cardInfo);
        cardInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la pantalla de información
                Intent intent = new Intent(MainActivity.this, activity_info.class); // Asumiendo que InfoActivity existe
                startActivity(intent);
            }
        });
         */

    }
}
