package com.kodiiiofc.example.adressbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameET: EditText
    private lateinit var lastNameET: EditText
    private lateinit var addressET: EditText
    private lateinit var phoneNumberET: EditText

    private lateinit var submitBTN: Button

    private lateinit var contactsLV: ListView

    private var adapter: ArrayAdapter<Person>? = null

    private val contacts = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameET = findViewById(R.id.et_first_name)
        lastNameET = findViewById(R.id.et_last_name)
        addressET = findViewById(R.id.et_address)
        phoneNumberET = findViewById(R.id.et_phone_number)

        submitBTN = findViewById(R.id.btn_submit)

        contactsLV = findViewById(R.id.lv_contacts)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contacts)
        contactsLV.adapter = adapter

        submitBTN.setOnClickListener {
            val contact = Person(
                firstNameET.text.toString(),
                lastNameET.text.toString(),
                addressET.text.toString(),
                phoneNumberET.text.toString()
            )
            contacts.add(contact)
            adapter!!.notifyDataSetChanged()
            firstNameET.text.clear();
            lastNameET.text.clear();
            addressET.text.clear();
            phoneNumberET.text.clear();

        }

        contactsLV.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
            val contact = contacts[position]
            val intent = Intent(this, ContactActivity::class.java)
            intent.putExtra(Person::class.java.simpleName, contact)
            startActivity(intent)
        }


    }
}