package com.example.hirehubresources


import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.hirehubresources.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Database initialization
        val database = DatabaseProvider.getDatabase(this)
        userDao = database.userDao()

        // binding setter
        val editTextEmail = binding.email
        val editTextPassword = binding.password
        val buttonReg = binding.registerBtn
        val progressBar = binding.progressBar

        // register button functionality
        buttonReg.setOnClickListener {
            progressBar.isVisible = true

            // Get user input
            val userEmail = editTextEmail.text.toString()
            val userPassword = editTextPassword.text.toString()

            // Registration empty handler
            if (TextUtils.isEmpty(userEmail)) {
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(userPassword)) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create a User object and insert it into the database
            val user = User(email = userEmail, password = userPassword)
            insertUser(user)
        }
    }

    private fun insertUser(user: User) {
        // Insert the user into the Room database
        userDao.insert(user)

        // Handle successful registration (update your UI as needed)
        Toast.makeText(this, "Registration successful.", Toast.LENGTH_SHORT).show()
        // Update your UI or navigate to another screen
    }
}

