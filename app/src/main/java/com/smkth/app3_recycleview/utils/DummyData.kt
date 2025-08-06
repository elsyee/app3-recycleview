package com.smkth.app3_recycleview.utils

import com.smkth.app3_recycleview.model.Student

object DummyData {
    fun getStudentList(): List<Student> {
        return listOf(
            Student("Andi", "123456", "XII TJKT 1", "TJKT", "SMKTH"),
            Student("Okta", "123456", "XII TJKT 1", "TJKT", "SMKTH"),
            Student("Soli", "123456", "XII TJKT 1", "TJKT", "SMKTH")
        )
    }
}
