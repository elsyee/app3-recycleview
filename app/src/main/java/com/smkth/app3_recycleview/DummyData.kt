package com.smkth.app3_recycleview.data

import com.smkth.app3_recycleview.model.Student

object DummyData {
    fun getStudentList(): MutableList<Student> {
        return mutableListOf(
            Student("Aditya Rasya Dafa Putra", "23001", "XII TJKT 1", "Teknik Jaringan Komputer dan Telekomunikasi", "SMK Tunas Harapan Pati"),
            Student("Arrumi Asna Salsabila", "23002", "XII TJKT 1", "Teknik Jaringan Komputer dan Telekomunikasi", "SMK Tunas Harapan Pati"),
            Student("Elsye Sukma Argita", "23003", "XII TJKT 1", "Teknik Jaringan Komputer dan Telekomunikasi", "SMK Tunas Harapan Pati"),
            Student("Hafidhah Nurina Amajida", "23004", "XII TJKT 1", "Teknik Jaringan Komputer dan Telekomunikasi", "SMK Tunas Harapan Pati"),
            Student("Andi Setiawan", "23011", "XI TKR 1", "Teknik Kendaraan Ringan", "SMK Negeri 1 Pati"),
            Student("Laras Putri", "23012", "X TBKR 2", "Teknik Body Kendaraan Ringan", "SMK Negeri 2 Pati"),
            Student("Eko Prasetyo", "23013", "XII TAB 1", "Teknik Alat Berat", "SMK Negeri 3 Pati"),
            Student("Nisa Maharani", "23014", "XI TPM 1", "Teknik Pemesinan", "SMK Cordova Pati"),
            Student("Rifky Alamsyah", "23015", "X Las 1", "Teknik Pengelasan", "SMK Kesuma Pati"),
            Student("Melani Kusuma", "23016", "XII BCPF 1", "Bisnis dan Pemasaran", "SMK Bhakti Tama Bangsa Juwana")
        )


    }
}

