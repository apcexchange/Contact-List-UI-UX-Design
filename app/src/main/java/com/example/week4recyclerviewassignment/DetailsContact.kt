package com.example.week4recyclerviewassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_details)

        val contactPhoto = findViewById<ImageView>(R.id.cv_image)
        val contactName = findViewById<TextView>(R.id.tv_name)
        val phoneNumber = findViewById<TextView>(R.id.phone_number)
        val emailAddress = findViewById<TextView>(R.id.email_address)
        val backArrow = findViewById<ImageView>(R.id.back_arrow)

        backArrow.setOnClickListener {
            onBackPressed()
        }

        val getIntent = intent.getParcelableExtra<Items>("info",)

        contactName.text=getIntent?.people
        phoneNumber.text=getIntent?.number
        emailAddress.text=getIntent?.email
        if (getIntent != null) {
            contactPhoto.setImageResource(getIntent.photos)
        }
    }
}