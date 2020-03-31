package com.bandtec.finfamily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_members_group.*

class MembersGroup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_members_group)

        btnGroup.setOnClickListener {
            val intent = Intent(this, PopAddNewMember::class.java)
            //start your next activity
            startActivity(intent)
        }
    }
}
