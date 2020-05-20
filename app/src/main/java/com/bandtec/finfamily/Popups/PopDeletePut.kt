package com.bandtec.finfamily.Popups

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bandtec.finfamily.R
import kotlinx.android.synthetic.main.activity_pop_new_invoice.btnClose

class PopDeletePut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_delete_put)

        btnClose.setOnClickListener {
            val intent = Intent(this, PopAlterPut::class.java)
            //start your next activity
            startActivity(intent)
            finish()
        }
    }
}