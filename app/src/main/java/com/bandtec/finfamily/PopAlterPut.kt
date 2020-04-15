package com.bandtec.finfamily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pop_alter_put.*

class PopAlterPut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_alter_put)

        btnDeletePut.setOnClickListener {
            val intent = Intent(this, PopDeletePut::class.java)
            //start your next activity
            startActivity(intent)
            finish()
        }

        btnClose.setOnClickListener {
            finish()
        }
    }
}