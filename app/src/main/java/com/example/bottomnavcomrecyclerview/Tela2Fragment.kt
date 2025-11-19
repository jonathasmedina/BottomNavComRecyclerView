package com.example.bottomnavcomrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tela2Fragment : Fragment() {

    private lateinit var searchView_: SearchView
    private lateinit var recyclerView_: RecyclerView

    private var arrayItens = ArrayList<Pessoa>()

    lateinit var meuRecyclerAdapter: MinhaClasseRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //mude o retorno para uma variável
        var view: View = inflater.inflate(R.layout.fragment_tela2, container, false)

        //... e use a variável
        searchView_ = view.findViewById(R.id.searchView)
        recyclerView_ = view.findViewById(R.id.recyclerView)

        searchView_.isIconified = false

        //busca com searchview
        searchView_.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false;
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                //Log.e("aqui","digitado: " + p0.toString())
                meuRecyclerAdapter.filtrar(p0.toString())
                return true;
            }
        })

        popularArrayList();

        configurarAdapter();

        return view;
    }

    private fun popularArrayList() {
        arrayItens.add(Pessoa("João da Silva", "CEO", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Maria José", "Desenvolvedor Senior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Pedro Paulo", "Desenvolvedor Junior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("João da Silva", "CEO", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Maria José", "Desenvolvedor Senior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Pedro Paulo", "Desenvolvedor Junior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("João da Silva", "CEO", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Maria José", "Desenvolvedor Senior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Pedro Paulo", "Desenvolvedor Junior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("João da Silva", "CEO", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Maria José", "Desenvolvedor Senior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Pedro Paulo", "Desenvolvedor Junior", R.drawable.aiphoto))
        arrayItens.add(Pessoa("João da Silva", "Desenvolvedor Pleno", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Francisca", "Full Stacker", R.drawable.aiphoto))
        arrayItens.add(Pessoa("Edilene Pereira", "Back-end Developer", R.drawable.aiphoto))
    }

    private fun configurarAdapter() {
        meuRecyclerAdapter = MinhaClasseRecyclerAdapter(arrayItens)

        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerView_.setLayoutManager(layoutManager)
        //companion object
        recyclerView_.setAdapter(meuRecyclerAdapter)

    }

}
