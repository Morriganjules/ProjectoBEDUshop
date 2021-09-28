package org.bedu.projectf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerAdapter (val productos : List<Producto>, fm: FragmentManager) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var fManager: FragmentManager = fm
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.nameProduct)
        val rate = view.findViewById<RatingBar>(R.id.rateProduct)
        val stock = view.findViewById<TextView>(R.id.stockProduct)
        val imagen = view.findViewById<ImageView>(R.id.imgProduct)
        val precio = view.findViewById<TextView>(R.id.priceProduct)


        fun bind (producto: Producto){
                title.text = producto.title
                rate.rating = producto.rate
                stock.text = producto.category
                precio.text = producto.price.toString()
                Picasso.get().load(producto.image).into(imagen)
                producto.description

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.shop_recycler,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val product = productos[position]
        holder.bind(product)
        val datos = Producto(holder.title.text.toString(),holder.rate.rating,holder.stock.text.toString(),holder.imagen.toString(),holder.precio.text.toString().toDouble(),product.description)
        holder.itemView.setOnClickListener {
            val newFragment: ProductFragment = ProductFragment.newInstance(datos)
            val transaction = fManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView3, newFragment).addToBackStack(null)
                .commit()

        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }


}