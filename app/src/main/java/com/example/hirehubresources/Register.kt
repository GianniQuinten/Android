package com.example.hirehubresources

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hirehubresources.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_register)

        // references the strings in the layout xml
        binding.email.hint = getString(R.string.email)
        binding.password.hint = getString(R.string.password)

        binding.registerBtn.setOnClickListener {
            // Get user input
            val userEmail = binding.email.text.toString()
            val userPassword = binding.password.text.toString()

            // If registration is successful,go to the register activity
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}