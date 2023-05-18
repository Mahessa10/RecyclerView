package com.ishfyamahessa.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                TODO("Not yet implemented")
            }

        })

    }
}