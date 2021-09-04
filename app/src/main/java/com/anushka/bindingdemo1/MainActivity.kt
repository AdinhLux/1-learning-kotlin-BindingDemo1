package com.anushka.bindingdemo1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.anushka.bindingdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /*
     * Object binding to activity_main.xml layout
     *
     * lateinit is used for creating a variable but you don't want to initialize it
     * at the time of declaration/creation of the variable
     * because you are sure that the variable will be initialized before its access/usage.
     *
     * var means your 'binding' is a mutable variable (contrary to 'val')
     */
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // From activity_main.xml, id = 'submit_button'
        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayGreeting() {
        // Reduce the repetition of the name of the data binding object
        binding.apply {
            greetingTextView.text = "Hello! " + nameEditText.text
        }
    }
}
