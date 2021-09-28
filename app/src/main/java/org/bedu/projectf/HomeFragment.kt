package org.bedu.projectf

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate del recycler view con la funcion getProducts

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val FragmentManager = requireFragmentManager()
        recycler.adapter = RecyclerAdapter(getProducts(requireActivity()), FragmentManager)



        return view
    }

    //funciones para acceder al JSON

    private fun getJsonDataFromAsset(context: Context, fileName: String = "productos.json"): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getProducts(context: Context): List<Producto> {
        val jsonString = getJsonDataFromAsset(context)
        val listProductType = object : TypeToken<List<Producto>>() {}.type
        return Gson().fromJson(jsonString, listProductType)
    }

}