//package com.example.hirehubresources
//
//import android.os.Bundle
//import android.text.TextUtils
//import android.util.Log
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.hirehubresources.databinding.ActivityRegisterBinding
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//
//class RegisterActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityRegisterBinding
//    private lateinit var auth: FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        auth = FirebaseAuth.getInstance()
//
//        // binding setter
//        val editTextEmail = binding.email
//        val editTextPassword = binding.password
//        val buttonReg = binding.registerBtn
//
//        // register button functionality
//        buttonReg.setOnClickListener {
//            // Get user input
//            val userEmail = editTextEmail.text.toString()
//            val userPassword = editTextPassword.text.toString()
//
//            // Registration empty handler
//            if (TextUtils.isEmpty(userEmail)) {
//                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            if (TextUtils.isEmpty(userPassword)) {
//                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Create a user using Firebase Authentication
//            auth.createUserWithEmailAndPassword(userEmail, userPassword)
//                .addOnCompleteListener() { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Toast.makeText(
//                            baseContext,
//                            "You created your account.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        val user = auth.currentUser
//                        updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Toast.makeText(
//                            baseContext,
//                            "Authentication failed.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        updateUI(null)
//                    }
//                }
//        }
//    }
//
//    private fun updateUI(user: FirebaseUser?) {
//        //  UI updates here if registry is successfull
//    }
//}