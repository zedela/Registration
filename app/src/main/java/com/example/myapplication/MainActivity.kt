package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRegister.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"შეცდომა", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"მომხმარებელი შეიქმნა", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}