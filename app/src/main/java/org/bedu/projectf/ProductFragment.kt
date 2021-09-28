package org.bedu.projectf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import org.bedu.projectf.databinding.FragmentProductBinding
import org.bedu.projectf.databinding.ProductRecyclerBinding

class ProductFragment : Fragment() {

    companion object {

        fun newInstance(product: Producto) = ProductFragment().apply {
            arguments = Bundle().apply {
                putString("title",product.title)
                putString("category",product.category)
                putString("image",product.image)
                putString("description", product.description)
                putFloat("rate", product.rate)
                putDouble("price", product.price)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    private var _binding: ProductRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       //val view = inflater.inflate(R.layout.fragment_product, container, false)

        //binding producto con recycler

        _binding = ProductRecyclerBinding.inflate(inflater, container, false)
        val view:View = binding.root
        binding.nombreProduct.setText(arguments?.getString("title"))
        binding.stock.setText(arguments?.getString("category"))
        binding.ratingBar.rating = arguments?.getFloat("rate")!!
        binding.precio.setText(arguments?.getDouble("price").toString())
        binding.precioCuotas.setText(arguments?.getDouble("price").toString())
        binding.descripcion.setText(arguments?.getString("description"))
        Picasso.get().load(arguments?.getString("image").toString()).into(binding.imgProducto)


        //funcionalidad boton en description product

        binding.btnCarrito.setOnClickListener() {

           findNavController().navigate(R.id.action_productFragment_to_carritoFragment, null)

        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}