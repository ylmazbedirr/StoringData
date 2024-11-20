package com.bedirhanyilmazs.storingdata2

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bedirhanyilmazs.storingdata2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPref: SharedPreferences

    var ageFromPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //SharedPref - xml - key-value
        sharedPref = this.getSharedPreferences("com.bedirhanyilmazs.storingdata2", MODE_PRIVATE)

        //
        ageFromPref = sharedPref.getInt("age", 0)
        if (ageFromPref == 0) {
            binding.textView.text = "Your age:"
        } else {
            binding.textView.text = "Your age: ${ageFromPref}"
        }
    }


    fun save(view : View) {
        val myAge = binding.editText.text.toString().toIntOrNull()

        if(myAge != null) {
            binding.textView.text = "Your age: ${myAge}"
            sharedPref.edit().putInt("age", myAge).apply()
        }

    }


    fun delete( view : View) {

        val ageFromPref = sharedPref.getInt("age", -1)
        if(ageFromPref != 0) {
            sharedPref.edit().remove("age").apply()
            binding.textView.text = "Your age:"
        }

    }
}