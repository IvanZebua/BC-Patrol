package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val livetracking : TextView = findViewById(R.id.Live_Tracking_Activity)
        val secPatrolform :TextView = findViewById(R.id.Security_Patrol_Activity)
        val LPMForm : TextView = findViewById(R.id.LPM_FORM_Activity)
        val logout : TextView = findViewById(R.id.logout)
        //val tv_username : TextView = findViewById(R.id.username)
        //val tv_userId : TextView = findViewById(R.id.user_ID)

        livetracking.setOnClickListener {
            startActivity(Intent(this@MainActivity, LiveTrackingActivity::class.java))
        }

        secPatrolform.setOnClickListener {
            startActivity(Intent(this@MainActivity, PatrolReportActivity::class.java))
        }

        LPMForm.setOnClickListener {
            startActivity(Intent(this@MainActivity, LPMFormActivity::class.java))
        }

        logout.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

    }
}