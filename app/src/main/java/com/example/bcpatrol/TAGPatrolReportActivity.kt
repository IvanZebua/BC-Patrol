package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TAGPatrolReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tagpatrol_report)

        val LMO : Button = findViewById(R.id.btn_Patroli_LMO)
        val SMO : Button = findViewById(R.id.btn_Patroli_SMO)
        val BMO1KM1 : Button = findViewById(R.id.btn_Patroli_BMO1_KM1)
        val BMO1KM28 : Button = findViewById(R.id.btn_Patroli_BMO1_KM28)
        val HO : Button = findViewById(R.id.btn_Patroli_HO)

        LMO.setOnClickListener{
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_LMO::class.java))
        }

        SMO.setOnClickListener {
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_SMO::class.java))
        }

        BMO1KM1.setOnClickListener {
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_BMO1KM1::class.java))
        }

        BMO1KM28.setOnClickListener {
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_BMO1KM1::class.java))
        }

        BMO1KM28.setOnClickListener {
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_BMO1KM28::class.java))
        }

        HO.setOnClickListener {
            startActivity(Intent(this@TAGPatrolReportActivity, TAG_HO::class.java))
        }

    }
}