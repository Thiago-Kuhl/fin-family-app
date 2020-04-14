package com.bandtec.finfamily

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_extract.*

class Extract : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extract)

        val total = intent.extras?.getFloat("totalFamily")

        vlTotalFamily.text = "$total"

        btNewContribution.setOnClickListener {
            val intent = Intent(this, PopFamContribution::class.java)
            //start your next activity
            startActivity(intent)
            finish()
        }

    }

    fun viewMore(v: View){
            val intent = Intent(this, ModalEntry::class.java)
            //start your next activity
            startActivity(intent)
            finish()
    }
}
