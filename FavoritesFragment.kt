package com.example.fcocinaya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        // Configurar el RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true) // Mejora el rendimiento y la distribución

        // Crear y asignar el adaptador
        favoritesAdapter = FavoritesAdapter(getSampleFavorites())
        recyclerView.adapter = favoritesAdapter

        // Notificar cambios en los datos
        favoritesAdapter.notifyDataSetChanged()

        return view
    }

    // Método para obtener una lista de favoritos de ejemplo
    private fun getSampleFavorites(): List<Recipe> {
        return listOf(
            Recipe("Tostadas de frijoles negros y aguacate"),
            Recipe("Huevos en Purgatorio"),
            Recipe("Ensalada César")
        )
    }
}
