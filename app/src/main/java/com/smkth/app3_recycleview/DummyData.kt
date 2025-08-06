package com.smkth.app3_recycleview.data

import com.smkth.app3_recycleview.model.Student

object DummyData {
    fun getStudentList(): MutableList<Student> {
        return mutableListOf(
            Student("Rizky", "12345", "XII RPL 1"),
            Student("Siti", "67890", "XII RPL 2"),
            Student("Budi", "54321", "XII RPL 3")
        )
    }
}
