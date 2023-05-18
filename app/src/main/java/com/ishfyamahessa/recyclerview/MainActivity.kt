package com.ishfyamahessa.recyclerview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.ishfyamahessa.recyclerview.adapter.AdapterTeamBola
import com.ishfyamahessa.recyclerview.databinding.ActivityMainBinding
import com.ishfyamahessa.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Teja Paku ALam",R.drawable.teja,"Penjaga Gawang","1.81 m","Painan (Indonesia)","14 Maret 1994"))
        listPemain.add(Pemain("Abdul Aziz Lutfi Akbar",R.drawable.abdul,"Gelandang Tengah","1.75 m","Bandung (Indonesia)","14 Februari 1994"))
        listPemain.add(Pemain("Marc Anthony Klok",R.drawable.klok,"Penjaga Bertahan","1.76 m","Amsterdam (Belanda)","20 April 1993"))
        listPemain.add(Pemain("Frets Listanto Butuan",R.drawable.frets,"Penyerang Sayap Kiri","1.75 m","Ternate (Indonesia)","04 Juni 1996"))
        listPemain.add(Pemain("Ciro Henrique Alves",R.drawable.ciro,"Penyerang Sayap Kanan","1.78 m","Brasil (Brasil)","18 April 1989"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val Image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    Image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })

    }
}