package com.example.kotlin_retrofit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.*
import kotlinx.android.synthetic.main.list_item.username_TextView
import kotlinx.android.synthetic.main.user_profile.*

class User_Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)

        val username: String? = intent.getStringExtra("title")
        val description: String? = intent.getStringExtra("description")
        val image : String? = intent.getStringExtra("image")
//
        description_TextView.setText(description)
        username_TextView.setText(username)
        profile_ImageView.setImageURI(image!!.toUri())
        Glide.with(this)
            .load(image)
            .into(profile_ImageView)

    }
}