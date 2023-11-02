package com.example.hirehubresources

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hirehubresources.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // initialises the database
        val database = DatabaseProvider.getDatabase(this)
        userDao = database.userDao()

        //  UI elements
        val emailEditText = binding.email
        val passwordEditText = binding.password
        val loginButton = binding.loginBtn

        loginButton.setOnClickListener {
            val userEmail = emailEditText.text.toString()
            val userPassword = passwordEditText.text.toString()

            // credential checker
            if (userEmail.isEmpty() || userPassword.isEmpty()) {
                Toast.makeText(this, "Both email and password are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            fun isValidEmail(email: String): Boolean {
                val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
                return email.matches(emailPattern.toRegex())
            }

            //email validation
            if (!isValidEmail(userEmail)) {
                Toast.makeText(this, "Please use a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // database check is on a background thread. it cant load on a main tread
            GlobalScope.launch(Dispatchers.IO) {
                val user = userDao.getUserByEmailAndPassword(userEmail, userPassword)

                launch(Dispatchers.Main) {
                    if (user != null) {
                        // Successful login
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Login invalid.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}
