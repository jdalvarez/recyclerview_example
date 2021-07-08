package com.example.recyclerviewcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class HeroAdapter(private val superhero:List<SuperHero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int {
        return superhero.size
    }

    class HeroHolder(private val view:View):RecyclerView.ViewHolder(view){
        fun render(superhero : SuperHero){
            view.findViewById<TextView>(R.id.tvRealName).text = superhero.realName
            view.findViewById<TextView>(R.id.tvSuperHeroName).text = superhero.superHeroName
            view.findViewById<TextView>(R.id.tvPublisher).text = superhero.publisher
            Picasso.get().load(superhero.image).into(view.findViewById(R.id.ivHero) as ImageView)
            view.setOnClickListener{ Toast.makeText(view.context, "Chupala ${superhero.superHeroName}!!",Toast.LENGTH_SHORT).show()}
        }
    }

}