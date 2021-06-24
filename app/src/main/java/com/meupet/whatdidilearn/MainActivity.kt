package com.meupet.whatdidilearn


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.meupet.whatdidilearn.databinding.ActivityMainBinding
import com.meupet.whatdidilearn.view.LearnItemAdapter
import com.meupet.whatdidilearn.view.NewItemActivity
import com.meupet.whatdidilearn.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by  viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnTela = findViewById<FloatingActionButton>(R.id.fab)
        val recycler = binding.recyclerView
        val adapter = LearnItemAdapter()
        //adapter.learnedItem = LearnItemDatabase.getAll()
        recycler.adapter = adapter

        // contexto que complementa a injeçao sem o koin  esse trecho do codigo mostra como fazer injeçao de dependencia sem o koin
        /*val repository = (application as WhatdidILearnApplication).repository
        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)*/
        val items = viewModel.learnedItems
        items.observe(this, androidx.lifecycle.Observer {
            adapter.learnedItem = it

        })



        btnTela.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivities(arrayOf(intent))
        }

        //database.learnedItemDao().isnert(LearnedItem(name = "item teste ",description = "ola sou teste ",understandingLevel = UndestandingLevel.Low))
    }
}