// Archivo: app/src/main/java/com/example/myapplication/CategoryAdapter.java
package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast; // Para el ejemplo del click

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adaptador para el RecyclerView que muestra las categorías de juego.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * Crea nuevas vistas (llamado por el layout manager).
     */
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout de un solo elemento de categoría
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    /**
     * Reemplaza el contenido de una vista (llamado por el layout manager).
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        // Obtiene la categoría en la posición actual
        Category category = categoryList.get(position);

        // Establece los datos en las vistas del ViewHolder
        holder.categoryName.setText(category.getName());
        holder.categoryDescription.setText(category.getDescription());
        holder.categoryImage.setImageResource(category.getImageResId());

        // Configura un listener de clic para cada elemento
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Clic en la categoría: " + category.getName(), Toast.LENGTH_SHORT).show();
            // Aquí puedes añadir la lógica para cuando se hace clic en una categoría,
            // por ejemplo, iniciar una nueva actividad o fragmento para mostrar los juegos de esa categoría.
        });
    }

    /**
     * Retorna el número total de elementos en el conjunto de datos (llamado por el layout manager).
     */
    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    /**
     * ViewHolder interno que contiene las vistas de un solo elemento de categoría.
     */
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;
        TextView categoryDescription;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializa las vistas del layout item_category.xml
            categoryImage = itemView.findViewById(R.id.ivCategoryImage); // Cambiado de category_image a ivCategoryImage
            categoryName = itemView.findViewById(R.id.tvCategoryName); // Cambiado de category_name a tvCategoryName
            categoryDescription = itemView.findViewById(R.id.tvCategoryDescription); // Cambiado de category_description a tvCategoryDescription
        }
    }
}