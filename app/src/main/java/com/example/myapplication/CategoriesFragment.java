// Archivo: app/src/main/java/com/example/myapplication/CategoriesFragment.java
package com.example.myapplication;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento que muestra una lista horizontal de categorías de juegos
 * utilizando un RecyclerView.
 */
public class CategoriesFragment extends Fragment {

    private RecyclerView rvCategories; // Asegúrate de que el ID en tu fragment_categories.xml sea rvCategories
    private CategoryAdapter categoryAdapter;

    public CategoriesFragment() {
        // Constructor público vacío requerido por los fragmentos
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout para este fragmento
        // Asegúrate de que R.layout.fragment_categories exista y sea el correcto
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener referencia al RecyclerView del layout del fragmento
        rvCategories = view.findViewById(R.id.rvCategories);

        // Configurar el LayoutManager. Ya está definido en XML como horizontal,
        // pero puedes hacerlo programáticamente si lo prefieres.
        // Un LayoutManager horizontal es bueno para las categorías.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCategories.setLayoutManager(layoutManager);

        // Crear una lista de categorías de ejemplo
        List<Category> categories = getSampleCategories();

        // Inicializar y asignar el adaptador al RecyclerView
        categoryAdapter = new CategoryAdapter(categories);
        rvCategories.setAdapter(categoryAdapter);

        // Opcional: añadir decoración para espaciado entre elementos
        // Es una buena práctica añadir un espaciado entre los elementos del RecyclerView
        rvCategories.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                       @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                // Añade un margen a la derecha de cada elemento
                // Puedes definir item_horizontal_spacing en dimens.xml (e.g., <dimen name="item_horizontal_spacing">16dp</dimen>)
                // o usar un valor fijo en píxeles.
                outRect.right = getResources().getDimensionPixelSize(R.dimen.item_horizontal_spacing);
            }
        });
    }

    /**
     * Método de ejemplo para obtener una lista de categorías.
     * En una aplicación real, estos datos podrían venir de una base de datos o una API.
     * Asegúrate de tener las imágenes correspondientes en tu carpeta 'drawable'.
     */
    private List<Category> getSampleCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Arcade", "Juegos llenos de adrenalina y combate.", R.drawable.ic_action_category)); // Asegúrate de tener ic_action_category.png/xml en drawable
        categories.add(new Category("Aventura", "Explora mundos vastos y resuelve enigmas.", R.drawable.ic_adventure_category));
         categories.add(new Category("Estrategia", "Planifica tus movimientos para la victoria.", R.drawable.ic_strategy_category));
        categories.add(new Category("Carreras", "Velocidad y emoción en la pista.", R.drawable.ic_racing_category));
        return categories;
    }
}
