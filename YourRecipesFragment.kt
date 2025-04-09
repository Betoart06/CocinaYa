package com.example.fcocinaya

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class YourRecipesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var yourRecipesAdapter: YourRecipesAdapter
    private lateinit var btnAddRecipe: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_your_recipes, container, false)

        // Configurar el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewYourRecipes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Obtener referencia al botón y configurar su listener
        btnAddRecipe = view.findViewById(R.id.btnAddRecipe)
        btnAddRecipe.setOnClickListener {
            // Iniciar la actividad AddRecipeActivity
            val intent = Intent(requireContext(), AddRecipeActivity::class.java)
            startActivity(intent)
        }

        // Crear y asignar el adaptador con los callbacks para manejo de clics
        yourRecipesAdapter = YourRecipesAdapter(
            getSampleYourRecipes(),
            onViewRecipeClick = { recipe ->
                // Abrir la actividad de detalle de receta
                val intent = Intent(requireContext(), RecipeDetailActivity::class.java)
                intent.putExtra("recipe_name", recipe.name)
                startActivity(intent)
            },
            onDeleteClick = { recipe ->
                Toast.makeText(requireContext(), "Eliminar receta: ${recipe.name}", Toast.LENGTH_SHORT).show()
            },
            onPublishClick = { recipe ->
                Toast.makeText(requireContext(), "Publicar receta: ${recipe.name}", Toast.LENGTH_SHORT).show()
            }
        )
        recyclerView.adapter = yourRecipesAdapter

        return view
    }

    // Método para obtener una lista de "Tus Recetas" de ejemplo
    private fun getSampleYourRecipes(): List<Recipe> {
        return listOf(
            Recipe("Milanesas con arroz"),
            Recipe("Ensaladilla de patata con mayonesa de limón y mostaza"),
            Recipe("Tortilla española")
        )
    }
}