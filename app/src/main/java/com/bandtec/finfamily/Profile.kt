package com.bandtec.finfamily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        settingsProfile.setOnClickListener {
            val intent = Intent(this, ProfileEdit::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // start your next activity
            startActivity(intent)
        }

        btLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // start your next activity
            startActivity(intent)
        }


    }
}
