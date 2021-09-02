package com.example.homeflixapplication
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeflixapplication.activity.FilmItemActivity
import com.example.homeflixapplication.models.FilmGlobalData

class RecAdapter(var items: List<FilmGlobalData>):RecyclerView.Adapter<RecAdapter.ViewHolder>() {


    inner class ViewHolder internal constructor(view:View):RecyclerView.ViewHolder(view){
        val imgSmall: ImageView = view.findViewById<ImageView>(R.id.smallImg)
        val filmName = view.findViewById<TextView>(R.id.filmName)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rec_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.imgSmall.context).load(items[0].listOfFilmItem[0].filmSmallImg).into(holder.imgSmall)
        holder.itemView.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            activity.startActivityForResult(Intent(v!!.context, FilmItemActivity::class.java),1)
        }
    }

}