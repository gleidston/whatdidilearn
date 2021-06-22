package com.meupet.whatdidilearn


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.meupet.whatdidilearn.data.LearnItemDatabase
import com.meupet.whatdidilearn.databinding.ActivityMainBinding
import com.meupet.whatdidilearn.view.LearnItemAdapter
import com.meupet.whatdidilearn.view.NewItemActivity


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tela = findViewById<FloatingActionButton>(R.id.fab)
        val recycler= binding.recyclerView
        val adapter = LearnItemAdapter()
       adapter. learnedItem = LearnItemDatabase.getAll()
        recycler.adapter=adapter

     tela.setOnClickListener{
         val intent = Intent(this, NewItemActivity::class.java)
         startActivities(arrayOf(intent))
     }

    }
}