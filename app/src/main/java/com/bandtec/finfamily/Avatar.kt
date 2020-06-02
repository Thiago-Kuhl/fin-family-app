package com.bandtec.finfamily

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.drawToBitmap
import kotlinx.android.synthetic.main.activity_avatar.*

class Avatar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar)
    }

    fun chooseAvatar(image: View) {
        val profile = Intent(this, Profile::class.java)
        val profileEdit = Intent(this, ProfileEdit::class.java)
        val members = Intent(this, MembersGroup::class.java)
        val group = Intent(this, Group::class.java)

        profile.putExtra("avatar", ((image as ImageView).drawable as BitmapDrawable).bitmap)
        profileEdit.putExtra("avatar",((image as ImageView).drawable as BitmapDrawable).bitmap)
        members.putExtra("avatar",  ((image as ImageView).drawable as BitmapDrawable).bitmap)
        group.putExtra("avatar", ((image as ImageView).drawable as BitmapDrawable).bitmap)

        startActivity(profileEdit);
        finish()
    }
}
