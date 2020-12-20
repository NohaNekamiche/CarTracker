package com.example.cartracker.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartracker.R

class SliderAdapter(private val slides: List<SlideInfo>):
    RecyclerView.Adapter<SliderAdapter.SlideViewHolder>() {

    inner class SlideViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val title=view.findViewById<TextView>(R.id.titleSlide);
        private val description=view.findViewById<TextView>(R.id.descr);
        private val image=view.findViewById<ImageView>(R.id.imgurl);
        fun bind(slider: SlideInfo){
            title.text = slider.title;
            description.text = slider.descr;
            image.setImageResource(slider.imgurl);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        return  SlideViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.slide_container,parent,false
                ));
    }

    override fun getItemCount(): Int {
      return  slides.size;
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(slides[position])
    }
}