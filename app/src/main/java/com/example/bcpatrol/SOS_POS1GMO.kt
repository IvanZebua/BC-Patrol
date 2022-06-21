package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SOS_POS1GMO : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sos_pos1_gmo)

        // declare UI Button
        val SOS_POS1GMO_ADCH : Button = findViewById(R.id.btn_SOS_POS1_1)
        val SOS_POS1GMO_LLJN : Button = findViewById(R.id.btn_SOS_POS1_2)
        val SOS_POS1GMO_WMP1GT : Button = findViewById(R.id.btn_SOS_POS1_3)
        val SOS_POS1GMO_CPP : Button = findViewById(R.id.btn_SOS_POS1_4)
        val SOS_POS1GMO_Jety :Button = findViewById(R.id.btn_SOS_POS1_5)
        val SOS_POS1GMO_Warehouse : Button = findViewById(R.id.btn_SOS_POS1_6)
        val SOS_POS1GMO_FS : Button = findViewById(R.id.btn_SOS_POS1_7)
        val SOS_POS1GMO_Parkiran : Button = findViewById(R.id.btn_SOS_POS1_8)
        val SOS_POS1GMO_OPTBC : Button = findViewById(R.id.btn_SOS_POS1_9)
        val SOS_POS1GMO_OPTJPC : Button = findViewById(R.id.btn_SOS_POS1_10)
        val SOS_POS1GMO_BP : Button = findViewById(R.id.btn_SOS_POS1_11)
        val SOS_POS1GMO_Nursery :Button = findViewById(R.id.btn_SOS_POS1_12)

        // go to next page
        SOS_POS1GMO_ADCH.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_AlatDeteksiCurahHujan::class.java))
        }

        SOS_POS1GMO_LLJN.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_LampuLalinJalanNegara::class.java))
        }

        SOS_POS1GMO_WMP1GT.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_WMP1GT::class.java))
        }

        SOS_POS1GMO_CPP.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_CPP::class.java))
        }

        SOS_POS1GMO_Jety.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_Jety::class.java))
        }

        SOS_POS1GMO_Warehouse.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_Warehouse::class.java))
        }

        SOS_POS1GMO_FS.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_FuelStation::class.java))
        }

        SOS_POS1GMO_Parkiran.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_Parkiran::class.java))
        }

        SOS_POS1GMO_OPTBC.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_OfficePTBC::class.java))
        }

        SOS_POS1GMO_OPTJPC.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_OfficePTJPC::class.java))
        }

        SOS_POS1GMO_BP.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, SOS_POS1GMO_BeachingPoint::class.java))
        }

        SOS_POS1GMO_Nursery.setOnClickListener {
            startActivity(Intent(this@SOS_POS1GMO, com.example.bcpatrol.SOS_POS1GMO_Nursery::class.java))
        }

    }
}