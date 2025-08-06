package com.smkth.app3_recycleview.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.*
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app3_recycleview.R
import com.smkth.app3_recycleview.model.Student

class StudentAdapter(
    private val context: Context,
    private var studentList: MutableList<Student>,
    private val onUpdateClick: (Student, Int) -> Unit // ← Callback untuk edit
) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(), Filterable {

    private var filteredList = studentList.toMutableList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvNis: TextView = itemView.findViewById(R.id.tvNis)
        val tvKelas: TextView = itemView.findViewById(R.id.tvKelas)
        val tvJurusan: TextView = itemView.findViewById(R.id.tvJurusan)
        val tvSekolah: TextView = itemView.findViewById(R.id.tvSekolah)
        val btnHapus: Button = itemView.findViewById(R.id.btnHapus)
        val btnUpdate: Button = itemView.findViewById(R.id.btnUpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = filteredList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = filteredList[position]

        holder.tvNama.text = student.nama
        holder.tvNis.text = "NIS: ${student.nis}"
        holder.tvKelas.text = "Kelas: ${student.kelas}"
        holder.tvJurusan.text = "Jurusan: ${student.jurusan}"
        holder.tvSekolah.text = "Sekolah: ${student.sekolah}"

        // Tombol hapus
        holder.btnHapus.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Hapus Data")
                .setMessage("Yakin ingin menghapus ${student.nama}?")
                .setPositiveButton("Hapus") { _, _ ->
                    studentList.remove(student)
                    filter.filter("") // refresh
                    Toast.makeText(context, "${student.nama} dihapus", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        // Tombol update
        holder.btnUpdate.setOnClickListener {
            val realIndex = studentList.indexOf(student)
            onUpdateClick(student, realIndex) // ← Kirim ke MainActivity
        }

        // Klik item = tampilkan detail
        holder.itemView.setOnClickListener {
            val intent = android.content.Intent(context, com.smkth.app3_recycleview.DetailActivity::class.java).apply {
                putExtra("student_nama", student.nama)
                putExtra("student_nis", student.nis)
                putExtra("student_kelas", student.kelas)
                putExtra("student_jurusan", student.jurusan)
                putExtra("student_sekolah", student.sekolah)
            }
            context.startActivity(intent)
        }


    }

    // Filter pencarian
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(query: CharSequence?): FilterResults {
                val keyword = query?.toString()?.lowercase()?.trim() ?: ""
                val filtered = if (keyword.isEmpty()) {
                    studentList
                } else {
                    studentList.filter {
                        it.nama.lowercase().contains(keyword) ||
                                it.nis.lowercase().contains(keyword) ||
                                it.kelas.lowercase().contains(keyword) ||
                                it.jurusan.lowercase().contains(keyword) ||
                                it.sekolah.lowercase().contains(keyword)
                    }
                }

                return FilterResults().apply { values = filtered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = (results?.values as? List<Student>)?.toMutableList() ?: mutableListOf()
                notifyDataSetChanged()
            }
        }
    }

    fun updateData(newData: MutableList<Student>) {
        studentList = newData
        filter.filter("")
    }
}
