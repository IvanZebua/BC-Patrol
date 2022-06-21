package com.example.bcpatrol

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.System.err
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TAG_HO : AppCompatActivity() {

    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2
    }

    private lateinit var db : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag_ho)

        val patrol = findViewById<Button>(R.id.btn_TAG_HO_1)
        patrol.setOnClickListener {
            tgl_jam()
        }

        // code dibawah ini untuk menjalankan program dropdown keterangan
        lokasi()
        keterangan()
        kamera()

        val save_TAG_HO = findViewById<Button>(R.id.save)
        val time_TAG_HO = findViewById<TextView>(R.id.Time_TAG_HO_1)


        val lokasi_TAG_HO = findViewById<TextView>(R.id.r_TAG_HO_1)

        val keterangan_TAG_HO = findViewById<TextView>(R.id.r_TAG_HO_2)

        save_TAG_HO.setOnClickListener {
            when {
                TextUtils.isEmpty(time_TAG_HO.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "waktu kosong", Toast.LENGTH_SHORT).show()
                }

                TextUtils.isEmpty(lokasi_TAG_HO.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "isi keterangan", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(keterangan_TAG_HO.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "isi keterangan", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    save()
                    /*
                    var patroli = hashMapOf(
                        hw_TAG_HO to "hari dan waktu",
                        lok_TAG_HO to "keterangan",
                        ket_TAG_HO to "hari dan waktu 2"
                    )
                    Firebase.firestore.collection("test").add(patroli)
                    */
                }
            }
            startActivity(Intent(this@TAG_HO, MainActivity::class.java))
        }
    }

    private fun save() {

        val lokasi_TAG_HO = findViewById<TextView>(R.id.r_TAG_HO_1)
        val time_TAG_HO = findViewById<TextView>(R.id.Time_TAG_HO_1)
        val keterangan_TAG_HO = findViewById<TextView>(R.id.r_TAG_HO_2)

        val ket_TAG_HO: String = (keterangan_TAG_HO.text.toString().trim { it <= ' ' })
        val lok_TAG_HO: String = (lokasi_TAG_HO.text.toString().trim { it <= ' ' })
        val hw_TAG_HO: String = (time_TAG_HO.text.toString().trim { it <= ' ' })
        /*

        var patroli = hashMapOf(
            hw_TAG_HO to "hari dan waktu",
            lok_TAG_HO to "keterangan",
            ket_TAG_HO to "hari dan waktu 2"
        )
        Firebase.firestore.collection("test").add(patroli)*/


        db = FirebaseDatabase.getInstance().getReference("Patroli")
        val patroli_TAG_HO_ID = db.push().key!!

        val pat_TAG_HO = PatroliModel(patroli_TAG_HO_ID, ket_TAG_HO, lok_TAG_HO, hw_TAG_HO)
        db.child(patroli_TAG_HO_ID).setValue(pat_TAG_HO)
            .addOnCompleteListener {
                Toast.makeText(this, "Patroli Tersimpan", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { err ->
                Toast.makeText(this, "Data Tidak Tersimpan, error ${err.message}", Toast.LENGTH_SHORT).show()
            }


    }

    private fun tgl_jam() {
        val waktu_1 = findViewById<TextView>(R.id.Time_TAG_HO_1)
        val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")

        val now = LocalDateTime.now()
        val sekarang = dtf.format(now)
        waktu_1.setText(sekarang)
    }

    private fun lokasi() {
        val Ket_1 = findViewById<Spinner>(R.id.sp_TAG_HO_1)
        val tv_ket_1 = findViewById<TextView>(R.id.r_TAG_HO_1)
        var options = arrayOf(
            "Lokasi Patroli",
            "Parkiran Roda 4",
            "Parkiran Sepeda",
            "WTP",
            "ULTRALUV",
            "Eks Gedung Kantin",
            "Fuel Station",
            "Genset",
            "Gedung Baru Lantai Atas dan Lantai Bawah Serta Ruang Kerja",
            "Gedung Lama Lantai Atas dan Lantai Bawah Serta Ruang Kerja",
            "Pintu Belakang HO BC",
            "Pintu Dermaga HO BC")

        Ket_1.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        Ket_1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                tv_ket_1.text = "Lokasi Patroli"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tv_ket_1.text = options.get(p2)
            }
        }
    }

    private fun keterangan() {
        val Ket_2 = findViewById<Spinner>(R.id.sp_TAG_HO_2)
        val tv_ket_2 = findViewById<TextView>(R.id.r_TAG_HO_2)
        var options = arrayOf(
            "Keterangan",
            "Temuan 1",
            "Temuan 2",
            "Temuan 3")

        Ket_2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        Ket_2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                tv_ket_2.text = "Keterangan"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tv_ket_2.text = options.get(p2)
            }
        }
    }

    private fun kamera() {
        val addImage_TAG_HO_1 = findViewById<TextView>(R.id.tv_add_image_1)
        addImage_TAG_HO_1.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this, android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            } else {
                Toast.makeText(
                    this,
                    "uppss sorry",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                val thumBnail: Bitmap = data!!.extras!!.get("data") as Bitmap
                val image1 = findViewById<ImageView>(R.id.pic_TAG_HO_1)
                image1.setImageBitmap(thumBnail)
            }
        }
    }

}
