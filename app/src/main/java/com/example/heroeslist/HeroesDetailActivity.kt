package com.example.heroeslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroeslist.databinding.ActivityHeroesDetailBinding

class HeroesDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeroesDetailBinding

    companion object{
        val EXTRA_HERO = "The hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //extract Hero object from the intent
        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)
        //put each field of the Hero object into the respective widgets
        binding.textViewHeroesDetailName.text = hero?.name
        binding.textViewHeroesDetailDescriptionText.text = hero?.description
        binding.textViewHeroesDetailRankingText.text = hero?.ranking.toString()
        binding.textViewHeroesDetailSuperpowerText.text = hero?.superpower
        binding.imageViewHeroesDetailImage.setImageDrawable(
            getDrawable(resources.getIdentifier(hero?.image, "drawable", packageName))
        )
    }
}