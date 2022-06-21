package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SOSPatrolReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sospatrol_report)

        val POS1_GMO : Button = findViewById(R.id.btn_POS_1_GMO)
        val HAULING_GMO : Button = findViewById(R.id.btn_Hauling_GMO)
        val POS_Gab_Suaran : Button = findViewById(R.id.btn_POS_Gab_Suaran)
        val POS_Dermaga_Suaran : Button = findViewById(R.id.btn_POS_Dermaga_Suaran)
        val POS_KM27 : Button = findViewById(R.id.btn_POS_KM_27)

        POS1_GMO.setOnClickListener {
            startActivity(Intent(this@SOSPatrolReportActivity, SOS_POS1GMO::class.java))
        }

        HAULING_GMO.setOnClickListener {
            startActivity(Intent(this@SOSPatrolReportActivity, SOS_HaulingGMO::class.java))
        }

        POS_Gab_Suaran.setOnClickListener {
            startActivity(Intent(this@SOSPatrolReportActivity, SOS_POSGabSuaran::class.java))
        }

        POS_Dermaga_Suaran.setOnClickListener {
            startActivity(Intent(this@SOSPatrolReportActivity, SOS_Dermaga_Suaran::class.java))
        }

        POS_KM27.setOnClickListener {
            startActivity(Intent(this@SOSPatrolReportActivity, SOS_POSKM27::class.java))
        }

    }
}