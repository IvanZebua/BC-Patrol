package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //deklarasi UI tools yang digunakan
        val login_email : EditText = findViewById(R.id.et_loginEmail)
        val login_password : EditText = findViewById(R.id.et_loginPass)
        val login_button : Button = findViewById(R.id.btn_login)
        val regis_page : TextView = findViewById(R.id.tv_lets_register)

        //pindah ke regis page
        regis_page.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        //setup login button
        login_button.setOnClickListener {
            when{
                //setup apabila edit text login email masih kosong
                TextUtils.isEmpty(login_email.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Tolong Input Email ID Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                //setup apabila edit text login password masih kosong
                TextUtils.isEmpty(login_password.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Tolong Input Password Akun Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                //setup apabila email ID dan password telah diisi
                else -> {
                    val email : String = login_email.text.toString().trim{ it <= ' '}
                    val password : String = login_password.text.toString().trim{ it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            //setup apabila email dan password telah tepat
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Welcome",
                                    Toast.LENGTH_LONG
                                ).show()
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user ID", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email ID", email)
                                startActivity(intent)
                                finish()
                            }

                            //setup apabila email dan password tidak tepat
                            else{
                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                }
            }
        }
    }
}