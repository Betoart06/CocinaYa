package com.example.fcocinaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class YourRecipesAdapter(
    private val yourRecipes: List<Recipe>,
    private val onViewRecipeClick: (Recipe) -> Unit,
    private val onDeleteClick: (Recipe) -> Unit,
    private val onPublishClick: (Recipe) -> Unit
) : RecyclerView.Adapter<YourRecipesAdapter.YourRecipesViewHolder>() {

    // ViewHolder para cada elemento de la lista
    class YourRecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        val buttonViewRecipe: Button = itemView.findViewById(R.id.buttonViewRecipe)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)
        val buttonSubirReceta: Button = itemView.findViewById(R.id.buttonSubirReceta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourRecipesViewHolder {
        // Inflar el layout de cada elemento de la lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tus_receta, parent, false)

        // Modificar el ancho para que ocupe todo el espacio disponible
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = layoutParams

        return YourRecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: YourRecipesViewHolder, position: Int) {
        // Asignar los datos a cada elemento de la lista
        val recipe = yourRecipes[position]

        // Establecer el nombre de la receta
        holder.recipeName.text = recipe.name

        // Configurar los listeners de los botones
        holder.buttonViewRecipe.setOnClickListener {
            onViewRecipeClick(recipe)
        }

        holder.buttonDelete.setOnClickListener {
            onDeleteClick(recipe)
        }

        holder.buttonSubirReceta.setOnClickListener {
            onPublishClick(recipe)
        }
    }

    override fun getItemCount(): Int {
        return yourRecipes.size
    }
}