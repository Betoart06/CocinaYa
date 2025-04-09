package com.example.fcocinaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // ViewHolder para cada elemento de la lista
    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImage: ImageView = itemView.findViewById(R.id.recipeImage)
        val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        val btnViewRecipe: Button = itemView.findViewById(R.id.btnViewRecipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        // Inflar el layout de cada elemento de la lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        // Asignar los datos a cada elemento de la lista
        val recipe = recipes[position]
        holder.recipeName.text = recipe.name
        holder.recipeImage.setImageResource(recipe.imageResId) // Asignar la imagen de la receta
        holder.btnViewRecipe.setOnClickListener {
            // Aquí puedes implementar la lógica para ver la receta
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}