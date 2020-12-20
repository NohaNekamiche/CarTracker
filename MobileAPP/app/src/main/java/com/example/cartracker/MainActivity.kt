package com.example.cartracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.core.view.plusAssign
import androidx.viewpager2.widget.ViewPager2
import com.example.cartracker.authentification.login_page
import com.example.cartracker.model.SlideInfo
import com.example.cartracker.model.SliderAdapter
import java.util.*


class MainActivity : AppCompatActivity() {

    var next:TextView?=null
    var ignorer:TextView?=null
    var position =0
    private val sliderAdapter =SliderAdapter(
        listOf(
            SlideInfo("Driver Informations",
                "Le driver doit entre tout ces informations (nom, prénom,permis....)",R.drawable.slide1

            ),
            SlideInfo("Maintenance de vehicule",
                "Le driver doit entre tout ces informations (nom, prénom,permis....)",R.drawable.slide2),
            SlideInfo("consommation du carburant",
                "En assure le suivie de votre consommation du carburant",R.drawable.slide3)

        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slide_intro_activity)
        val introSlideViewPager = findViewById<ViewPager2>(R.id.introSlideViewPager)
        introSlideViewPager.adapter =sliderAdapter
        setupIndicators()
        setCurrentIndicators(0)
        introSlideViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position)
            }
        })
        val btnNext = findViewById<TextView>(R.id.next)
        btnNext.setOnClickListener {
            if(introSlideViewPager.currentItem +1 < sliderAdapter.itemCount){
                introSlideViewPager.currentItem += 1
            }else{
                val intent = Intent(this, login_page::class.java)
                startActivity(intent)
                finish()
            }

        }
        val btnIgnore = findViewById<TextView>(R.id.ignore)
        btnIgnore.setOnClickListener {
            val intent = Intent(this, login_page::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(sliderAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(8,0,8,0)
        for(i : Int in  indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,R.drawable.unselected
                    )
                )
                this?.layoutParams = layoutParams
            }
            val indicatorsContainer = findViewById<LinearLayout>(R.id.indicatorContainer)
            indicatorsContainer.addView(indicators[i])
        }

    }
    private fun setCurrentIndicators(index :Int){
        val indicatorsContainer = findViewById<LinearLayout>(R.id.indicatorContainer)
        val childCurrent:Int = indicatorsContainer.childCount
        for(i : Int in  0 until childCurrent){
            val imageView = indicatorsContainer[i] as ImageView
            if(i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,
                    R.drawable.selected))
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,
                        R.drawable.unselected))

            }
        }
    }
}