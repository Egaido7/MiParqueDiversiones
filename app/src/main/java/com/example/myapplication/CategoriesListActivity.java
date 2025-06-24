// Archivo: app/src/main/java/com/example/myapplication/CategoriesListActivity.java
package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Actividad que sirve como contenedor para CategoriesFragment.
 * Esta actividad será lanzada desde MainActivity cuando el usuario
 * seleccione la opción de ver categorías.
 */
public class CategoriesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece un layout simple para esta actividad que contenga un FrameLayout
        // donde se pueda insertar el fragmento.
        // Crea un nuevo archivo XML: activity_categories_list.xml en res/layout/
        setContentView(R.layout.activity_categories_list);

        // Opcional: Mostrar un botón de "Atrás" en la barra de acción
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Explorar Categorías"); // Puedes cambiar el título
        }

        // Solo añade el fragmento si no se ha añadido ya (ej. después de un cambio de configuración)
        if (savedInstanceState == null) {
            // Obtener el FragmentManager
            FragmentManager fragmentManager = getSupportFragmentManager();
            // Iniciar una transacción de fragmentos
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Crear una instancia de tu CategoriesFragment
            CategoriesFragment categoriesFragment = new CategoriesFragment();

            // Añadir el fragmento al FrameLayout en tu activity_categories_list.xml
            // El ID 'fragment_container_categories' debe existir en activity_categories_list.xml
            fragmentTransaction.add(R.id.fragment_container_categories, categoriesFragment);

            // Confirmar la transacción
            fragmentTransaction.commit();
        }
    }

    // Manejar el botón de "Atrás" en la barra de acción
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
