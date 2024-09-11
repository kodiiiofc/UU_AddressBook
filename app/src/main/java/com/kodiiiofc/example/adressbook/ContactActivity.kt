package com.kodiiiofc.example.adressbook

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    private lateinit var firstNameTV: TextView
    private lateinit var lastNameTV: TextView
    private lateinit var addressTV: TextView
    private lateinit var phoneNumberTV: TextView

    private lateinit var backBTN: Button

    private var contact: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        firstNameTV = findViewById(R.id.tv_first_name)
        lastNameTV = findViewById(R.id.tv_second_name)
        addressTV = findViewById(R.id.tv_address)
        phoneNumberTV = findViewById(R.id.tv_phone_number)

        backBTN = findViewById(R.id.btn_back)

        toolbar = findViewById(R.id.toolbar)

        contact = intent.extras?.getSerializable(Person::class.java.simpleName) as Person

        firstNameTV.text = contact?.firstName
        lastNameTV.text = contact?.lastName
        addressTV.text = contact?.address
        phoneNumberTV.text = contact?.phoneNumber

        toolbar.title = getString(R.string.toolbar_contact) + " " + contact?.firstName + " " + contact?.lastName

        backBTN.setOnClickListener {
            finish()
        }

    }
}