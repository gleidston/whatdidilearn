package com.meupet.whatdidilearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.meupet.whatdidilearn.data.LearnItemDatabase
import com.meupet.whatdidilearn.databinding.ActivityMainBinding
import com.meupet.whatdidilearn.view.LearnItemAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recycler= binding.recyclerView
        val adapter = LearnItemAdapter()
      //  adapter. learnedItem = LearnItemDatabase.getAll()
        recycler.adapter=adapter




    }
}