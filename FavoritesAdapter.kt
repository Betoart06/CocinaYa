package com.example.fcocinaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritesAdapter(private val favorites: List<Recipe>) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    // ViewHolder para cada elemento de la lista
    class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        val buttonViewRecipe: Button = itemView.findViewById(R.id.buttonViewRecipe)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        // Inflar el layout de cada elemento de la lista (usando item_favoritos.xml)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favoritos, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        // Asignar los datos a cada elemento de la lista
        val recipe = favorites[position]
        holder.recipeName.text = recipe.name

        // Configurar el clic en el botón "Ver Receta"
        holder.buttonViewRecipe.setOnClickListener {
            // Aquí puedes agregar la lógica para ver la receta
            // Por ejemplo, abrir una nueva actividad o fragmento con los detalles de la receta
        }

        // Configurar el clic en el botón "Eliminar"
        holder.buttonDelete.setOnClickListener {
            // Aquí puedes agregar la lógica para eliminar la receta de favoritos
            // Por ejemplo, eliminar el ítem de la lista y notificar al adaptador
        }
    }

    override fun getItemCount(): Int {
        return favorites.size
    }
}