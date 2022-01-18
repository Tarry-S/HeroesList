package com.example.heroeslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroeslist.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class HeroesListActivity : AppCompatActivity() {

    companion object {
    val TAG = "HeroesListActivity"
    }

    private lateinit var binding: ActivityHeroesListBinding
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: make a Hero.kt model class
        // TODO: load the heroes.json into a List<Hero>

        val inputStream = resources.openRawResource(R.raw.heroes)

        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "onCreate: $jsonText")

        val gson = Gson()
        val type = object : TypeToken<List<Hero>>() {}.type
        val heroesList = gson.fromJson<List<Hero>>(jsonText, type)
        Log.d(TAG, "onCreate: \n${heroesList}")

        adapter = HeroAdapter(heroesList)
        binding.recyclerViewHeroesList.adapter = adapter
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)
    }
}