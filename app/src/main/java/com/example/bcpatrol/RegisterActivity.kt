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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //deklarasi UI tools yang digunakan pada RegisterActivity
        val regis_nama : EditText = findViewById(R.id.et_fullname)
        val regis_email : EditText = findViewById(R.id.et_regisEmail)
        val regis_password : EditText = findViewById(R.id.et_regisPass)
        val regis_btn : Button = findViewById(R.id.btn_regis)
        val login_page : TextView = findViewById(R.id.tv_lets_login)
        val user_sid : EditText = findViewById(R.id.et_SID)


        //pindah login page
        login_page.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        //setup register button
        regis_btn.setOnClickListener {
            when{

                //setup apabila edit text nama lengkap masih kosong
                TextUtils.isEmpty(regis_nama.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Tolong Input Nama lengkap Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                TextUtils.isEmpty(user_sid.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Tolong Input SID Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                //setup apabila edit text login email masih kosong
                TextUtils.isEmpty(regis_email.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Tolong Input Email ID Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                //setup apabila edit text login password masih kosong
                TextUtils.isEmpty(regis_password.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Tolong Input Password Akun Anda",
                        Toast.LENGTH_LONG
                    ).show()
                }

                //setup apabila nama lengkap, email ID dan password telah diisi
                else -> {
                    val email: String = regis_email.text.toString().trim{ it <= ' '}
                    val password: String = regis_password.text.toString().trim{ it <= ' '}
                    val NamaPengguna : String = regis_nama.text.toString().trim{ it <= ' '}
                    val SID : String = user_sid.text.toString().trim { it <= ' ' }

                    /*
                    //nyimpan nama lengkap
                    val user = hashMapOf(
                        NamaPengguna to "User",
                        SID to "SID"
                    )
                    */


                    // Create an Instance and create a register a user with email and password.
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener{ task ->
                            // If the register is succesfully done
                            if (task.isSuccessful) {
                                // firebase register user
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "You are registered succesfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                    Intent(this@RegisterActivity, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                intent.putExtra("username", NamaPengguna)
                                intent.putExtra("SID", SID)
                                startActivity(intent)
                                finish()
                            } else {
                                // if the register is not successful then show error message
                                Toast.makeText(
                                    this@RegisterActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}