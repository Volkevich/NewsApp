package com.vitalyv.newsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.vitalyv.newsapp.adapter.NewsAdapter
import com.vitalyv.newsapp.data.DataSourceFile
import com.vitalyv.newsapp.databinding.ActivityMainBinding
import com.vitalyv.newsapp.databinding.ListItemsBinding
import org.json.JSONObject


const val API_KEY = "3acc2fad546c6dbb7c93789857ba759b"


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var listBinding:ListItemsBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewId.layoutManager = LinearLayoutManager(this)
        //Фон приложения из Gif изображения.
        Glide.with(this).asGif().load(R.drawable.backgroundgif).into(binding.imageBackGround)
        binding.refreshButtonId.setOnClickListener {
            getNews()
        }
    }
    @SuppressLint("StringFormatInvalid")
    private fun getNews() {
        val myDataset = DataSourceFile().loadNews()

        binding.recyclerViewId.adapter = NewsAdapter(this, myDataset) { informationModel ->
            Log.d("My logs", "clicked on: ${getString(informationModel.titleView)}}")
            Toast.makeText(
                this,
                getString(informationModel.titleView),
                Toast.LENGTH_SHORT
            ).show()
        }
        val url = "https://gnews.io/api/v4/top-headlines?category=general&apikey=$API_KEY"

        Fuel.get(url)
            .responseString { _, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        val jsonObject = JSONObject(data)
                        val articles = jsonObject.getJSONArray("articles")
                        val arrayTitle = articles.getJSONObject(1)
                        val title = arrayTitle.get("title").toString()
                        val description = arrayTitle.get("description").toString()
                        val image = arrayTitle.get("image")
                        Log.d("TAG", "getNews success: $title")
                        Log.d("TAG", "getNews success: $description")
                        Log.d("TAG", "getNews success: $image")


                    }

                    is Result.Failure -> {
                        val error = result.getException()
                        Log.d("TAG", "getNews error: $error")
                    }
                }
            }
    }


}