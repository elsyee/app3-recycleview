package com.smkth.app3_recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.smkth.app3_recycleview.adapter.StudentAdapter
import com.smkth.app3_recycleview.data.DummyData
import com.smkth.app3_recycleview.model.Student

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: MutableList<Student>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Safe area
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentList = DummyData.getStudentList()
        studentAdapter = StudentAdapter(this, studentList) { student, index ->
            showFormDialog(isEdit = true, existingStudent = student) { updatedStudent ->
                studentList[index] = updatedStudent
                studentAdapter.updateData(studentList)
                Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
            }
        }


// FAB tambah data
        findViewById<FloatingActionButton>(R.id.fabTambah).setOnClickListener {
            showFormDialog(isEdit = false) { newStudent ->
                studentList.add(newStudent)
                studentAdapter.updateData(studentList)
                Toast.makeText(this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }



        // Init view
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        // Ambil data dari DummyData
        studentList = DummyData.getStudentList()

        // Init adapter dengan callback update
        studentAdapter = StudentAdapter(this, studentList) { student, index ->
            showFormDialog(isEdit = true, existingStudent = student) { updatedStudent ->
                studentList[index] = updatedStudent
                studentAdapter.updateData(studentList)
                Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
            }
        }


        // Pasang ke RecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = studentAdapter
        }

        // Search logic
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                studentAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                studentAdapter.filter.filter(newText)
                return true
            }
        })
    }

    private fun showFormDialog(
        isEdit: Boolean,
        existingStudent: Student? = null,
        onSave: (Student) -> Unit
    ) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.addnupdate, null)

        val edtNama = dialogView.findViewById<EditText>(R.id.edtNama)
        val edtNis = dialogView.findViewById<EditText>(R.id.edtNis)
        val edtKelas = dialogView.findViewById<EditText>(R.id.edtKelas)
        val edtJurusan = dialogView.findViewById<EditText>(R.id.edtJurusan)
        val edtSekolah = dialogView.findViewById<EditText>(R.id.edtSekolah)

        if (isEdit && existingStudent != null) {
            edtNama.setText(existingStudent.nama)
            edtNis.setText(existingStudent.nis)
            edtKelas.setText(existingStudent.kelas)
            edtJurusan.setText(existingStudent.jurusan)
            edtSekolah.setText(existingStudent.sekolah)
        }

        AlertDialog.Builder(this)
            .setTitle(if (isEdit) "Edit Data Siswa" else "Tambah Data Siswa")
            .setView(dialogView)
            .setPositiveButton("Simpan") { _, _ ->
                val student = Student(
                    nama = edtNama.text.toString(),
                    nis = edtNis.text.toString(),
                    kelas = edtKelas.text.toString(),
                    jurusan = edtJurusan.text.toString(),
                    sekolah = edtSekolah.text.toString()
                )
                onSave(student)
            }
            .setNegativeButton("Batal", null)
            .show()
    }


}
