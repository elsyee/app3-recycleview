package com.smkth.app3_recycleview.data

import com.smkth.app3_recycleview.model.Student

object DummyData {
    fun getStudentList(): MutableList<Student> {
        return mutableListOf(
            Student("Rizky", "12345", "XII RPL 1", "TJKT", "SMKTH"),
            Student("Siti", "67890", "XII RPL 2", "TJKT", "SMKTH"),
            Student("Budi", "54321", "XII RPL 3", "TJKT", "SMKTH")
        )
    }
}
