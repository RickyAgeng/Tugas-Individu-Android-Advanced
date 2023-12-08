package com.example.e_library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.content.SharedPreferences
import android.widget.Button
import android.widget.TextView

class PeminjamanFragment : Fragment() {

    private lateinit var tvBookTitle: TextView
    private lateinit var btnBorrow: Button

    // Nama berkas SharedPreferences
    private val PREF_NAME = "PeminjamanPreferences"

    // Nama kunci-kunci SharedPreferences
    private val KEY_BOOK_TITLE = "book_title"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_peminjaman, container, false)

        // Inisialisasi elemen UI
        tvBookTitle = view.findViewById(R.id.tvBookTitle)
        btnBorrow = view.findViewById(R.id.btnBorrow)

        // Inisialisasi SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        // Tampilkan judul buku dari SharedPreferences
        val bookTitle = sharedPreferences.getString(KEY_BOOK_TITLE, "Belum Ada Peminjaman")
        tvBookTitle.text = bookTitle

        // Atur tindakan untuk tombol "Pinjam Buku"
        btnBorrow.setOnClickListener {
            // Simpan judul buku ke SharedPreferences
            val newBookTitle = "Anda Telah Berhasil Meminjam"
            saveBookTitle(newBookTitle)
            tvBookTitle.text = newBookTitle
        }

        return view
    }

    // Metode untuk menyimpan judul buku ke SharedPreferences
    private fun saveBookTitle(bookTitle: String) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_BOOK_TITLE, bookTitle)
        editor.apply()
    }
}