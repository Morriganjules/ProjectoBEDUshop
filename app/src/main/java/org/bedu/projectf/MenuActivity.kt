package org.bedu.projectf

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.net.URI



class MenuActivity : AppCompatActivity() {
    private lateinit var bottom : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        /*metodos para funcionalidades NavBar*/


        val homeFragment = HomeFragment()
        val carritoFragment = CarritoFragment()
        val perfilFragment = PerfilFragment()
        makeCurrentFragment(homeFragment)

        bottom = findViewById(R.id.btmMenu)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> {
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                    makeCurrentFragment(homeFragment)
                    true
                }
                R.id.carritoFragment -> {
                    Toast.makeText(this, "Carrito", Toast.LENGTH_SHORT).show()
                    makeCurrentFragment(carritoFragment)
                    true
                }
                R.id.perfilFragment -> {
                    Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
                    makeCurrentFragment(perfilFragment)
                    true
                }

            }
            true

        }


    }


    /*metodo para funcionalidades AppBar */


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_top, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.buscar -> {
                Toast.makeText(this, "Opcion inhabilitada", Toast.LENGTH_SHORT).show()
                return true}
            R.id.url -> {
                val link : Uri? = Uri.parse("https://www.bedu.org")
                val intent: Intent = Intent(Intent.ACTION_VIEW, link)
                startActivity(intent)
                return true
            }


            else -> return true
        }

        return super.onOptionsItemSelected(item)
    }

    //function para poder generar la transaction en el Bottom navBar

    private fun makeCurrentFragment (fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragmentContainerView3, fragment)
        commit()
    }

}