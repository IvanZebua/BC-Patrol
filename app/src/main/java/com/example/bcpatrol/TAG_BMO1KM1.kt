package com.example.bcpatrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TAG_BMO1KM1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag_bmo1_km1)

        val posKM1PTMTL:Button = findViewById(R.id.btn_POSKM1PTMTL)
        val poskm1BMO1:Button = findViewById(R.id.btn_POSKM1BMO1)
        val gudanghandak:Button = findViewById(R.id.btn_GudangHandakBMO1)

        //set fungsi button
        posKM1PTMTL.setOnClickListener {
            startActivity(Intent(this@TAG_BMO1KM1, TAG_BMO1KM1_PosKM1PTMTL::class.java))
        }

        poskm1BMO1.setOnClickListener {
            startActivity(Intent(this@TAG_BMO1KM1, TAG_BMO1KM1_PosBMO1::class.java))
        }

        gudanghandak.setOnClickListener {
            startActivity(Intent(this@TAG_BMO1KM1, TAG_BMO1KM1_GudangHandak::class.java))
        }

    }
}