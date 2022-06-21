package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TAG_LMO : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag_lmo)

        val TAG_LMO_pos3 : Button = findViewById(R.id.btn_TAG_LMO_pos3)
        val TAG_LMO_KS : Button = findViewById(R.id.btn_TAG_LMO_kandangsapi)
        val TAG_LMO_ER : Button = findViewById(R.id.btn_TAG_LMO_exRBA)
        val TAG_LMO_W07 : Button = findViewById(R.id.btn_TAG_LMO_WMP07)
        val TAG_LMO_P05 : Button = findViewById(R.id.btn_TAG_LMO_pos05LMO)
        val TAG_LMO_POSKOLMO :Button = findViewById(R.id.btn_TAG_LMO_poskoLMO)
        val TAG_LMO_W04 : Button = findViewById(R.id.btn_TAG_LMO_WMP04)
        val TAG_LMO_W03 : Button = findViewById(R.id.btn_TAG_LMO_WMP03)
        val TAG_LMO_W10 : Button = findViewById(R.id.btn_TAG_LMO_WMP10)
        val TAG_LMO_W13 : Button = findViewById(R.id.btn_TAG_LMO_WMP13)
        val TAG_LMO_W14 : Button = findViewById(R.id.btn_TAG_LMO_WMP14)
        val TAG_LMO_POS2 : Button = findViewById(R.id.btn_TAG_LMO_pos2)
        val TAG_LMO_EXPOS4 : Button = findViewById(R.id.btn_TAG_LMO_expos4)
        val TAG_LMO_JN : Button = findViewById(R.id.btn_TAG_LMO_jalannegara)

        TAG_LMO_pos3.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_POS3::class.java))
        }

        TAG_LMO_KS.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_KandangSapi::class.java))
        }

        TAG_LMO_ER.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_EXRBA::class.java))
        }

        TAG_LMO_W07.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP07::class.java))
        }

        TAG_LMO_P05.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_POS05::class.java))
        }

        TAG_LMO_POSKOLMO.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, com.example.bcpatrol.TAG_LMO_POSKOLMO::class.java))
        }

        TAG_LMO_W04.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP07::class.java))
        }

        TAG_LMO_W03.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP03::class.java))
        }

        TAG_LMO_W10.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP10::class.java))
        }

        TAG_LMO_W13.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP13::class.java))
        }

        TAG_LMO_W14.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_WMP14::class.java))
        }

        TAG_LMO_POS2.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, com.example.bcpatrol.TAG_LMO_POS2::class.java))
        }

        TAG_LMO_EXPOS4.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, com.example.bcpatrol.TAG_LMO_EXPOS4::class.java))
        }

        TAG_LMO_JN.setOnClickListener {
            startActivity(Intent(this@TAG_LMO, TAG_LMO_JalanNegara::class.java))
        }

    }
}