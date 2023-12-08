package com.example.e_library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KoleksiFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_koleksi, container, false)

        imageList = arrayOf(
            R.drawable.yangtelah,
            R.drawable.rumahkost,
            R.drawable.lorong,
            R.drawable.pandawa,
            R.drawable.ghost,
            R.drawable.sianak
        )

        titleList = arrayOf(
            "Yang Telah Lama Pergi",
            "Rumah Kost Beringin",
            "Lorong Waktu",
            "Pandawa tujuh",
            "Ghost Fleet",
            "Si Anak Pintar"
        )

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getData()

        return view
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}
