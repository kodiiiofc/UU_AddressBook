package com.kodiiiofc.example.adressbook

import java.io.Serializable

data class Person(val firstName: String, val lastName: String, val address: String, val phoneNumber: String) : Serializable {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}
