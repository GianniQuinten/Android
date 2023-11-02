package com.example.hirehubresources


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.hirehubresources.databinding.ActivityRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // database initialization
        val database = DatabaseProvider.getDatabase(this)
        userDao = database.userDao()

        // binding setter
        val editTextEmail = binding.email
        val editTextPassword = binding.password
        val buttonReg = binding.registerBtn
        val progressBar = binding.progressBar

        buttonReg.setOnClickListener {
            progressBar.isVisible = true

            // get user input
            val userEmail = editTextEmail.text.toString()
            val userPassword = editTextPassword.text.toString()

            // validate email
            fun isValidEmail(email: String): Boolean {
                val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
                return email.matches(emailPattern.toRegex())
            }

            // validate the email format
            if (!isValidEmail(userEmail)) {
                Toast.makeText(this, "Please use a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            // registration empty handler
            if (TextUtils.isEmpty(userEmail)) {
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(userPassword)) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // launch a coroutine to insert the user into the room database
            CoroutineScope(Dispatchers.IO).launch {
                val user = User(
                    userType = "User",
                    email = userEmail,
                    password = userPassword
                )
                userDao.insert(user)

                // handles successful registration
                runOnUiThread {
                    Toast.makeText(this@RegisterActivity, "Registration successful.", Toast.LENGTH_SHORT).show()

                    // load a new page
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
