package com.example.sharedpreferencesdemo

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getSharedPreferences : can share among all the activities
        //getPreferences : only for this activity
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        binding.btnSet.setOnClickListener() {
            // if it unable to find the value with the string name, it will return empty string
            val value = sharedPreferences.getString("Username", "")
            binding.tvResult.text = value
        }

        binding.btnGet.setOnClickListener() {
            val editor = sharedPreferences.edit()

            editor.putString("Username", "Ali")

            editor.commit()
        }
    }
}