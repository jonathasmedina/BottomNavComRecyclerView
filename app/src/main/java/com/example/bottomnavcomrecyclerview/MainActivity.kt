package com.example.bottomnavcomrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mBottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBottomNavigationView = findViewById(R.id.bottomNavigationView)

        carregaFragment(Tela1Fragment())

        // Configuração do BottomNavigationView
        mBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    carregaFragment(Tela1Fragment())
                    true
                }

                R.id.ferramenta -> {
                    carregaFragment(Tela2Fragment())
                    true
                }

                R.id.cronograma -> {
                    carregaFragment(Tela3Fragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun carregaFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_TelaPrincipal, fragment)
            .commit()
    }
}