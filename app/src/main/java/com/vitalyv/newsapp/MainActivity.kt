package com.vitalyv.newsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.vitalyv.newsapp.adapter.NewsAdapter
import com.vitalyv.newsapp.data.DataSourceFile
import com.vitalyv.newsapp.databinding.ActivityMainBinding
import com.vitalyv.newsapp.service.NewsApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        Glide.with(this).asGif().load(R.drawable.backgroundgif).into(binding.imageBackGround)


        val myDataset = DataSourceFile().loadNews()
        binding.recyclerViewId.adapter = NewsAdapter(this, myDataset) { informationModel ->
            Log.d("My logs", "clicked on: ${getString(informationModel.titleView)}}")
            Toast.makeText(
                this,
                getString(informationModel.titleView),
                Toast.LENGTH_SHORT
            ).show()
        }




    }

}