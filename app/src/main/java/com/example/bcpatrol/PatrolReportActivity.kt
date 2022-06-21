package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PatrolReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patrol_report)

        val SOS : Button = findViewById(R.id.btn_SOS)
        val MBJ : Button = findViewById(R.id.btn_MBJ)
        val TAG : Button = findViewById(R.id.btn_TAG)
        val back : TextView = findViewById(R.id.backtoMA)

        SOS.setOnClickListener {
            startActivity(Intent(this@PatrolReportActivity, SOSPatrolReportActivity::class.java) )
        }

        MBJ.setOnClickListener {
            startActivity(Intent(this@PatrolReportActivity, MBJPatrolReportActivity::class.java))
        }

        TAG.setOnClickListener {
            startActivity(Intent(this@PatrolReportActivity, TAGPatrolReportActivity::class.java))
        }

        back.setOnClickListener {
            startActivity(Intent(this@PatrolReportActivity, MainActivity::class.java))
        }

    }
}