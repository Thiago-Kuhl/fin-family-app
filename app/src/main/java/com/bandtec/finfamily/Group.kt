package com.bandtec.finfamily

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bandtec.finfamily.popups.PopChooseGroupAction
import com.bandtec.finfamily.api.RetrofitClient
import com.bandtec.finfamily.fragments.GroupFinance
import com.bandtec.finfamily.model.GroupResponse
import kotlinx.android.synthetic.main.activity_group.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Group : AppCompatActivity() {

    private var sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        val user = getSharedPreferences("user", Context.MODE_PRIVATE)
        val spGroups = getSharedPreferences("group", Context.MODE_PRIVATE).all

        getUserGroups(user.getInt("userId", 0))

        btnGroup.setOnClickListener {
            val intent = Intent(this, PopChooseGroupAction::class.java)
            //start your next activity
            startActivity(intent)
        }
    }

    fun Group(v: View) {
        val intent = Intent(this, Panel::class.java)

        val id: Int = 1
        intent.putExtra("id", id)

        startActivity(intent)
    }

    fun getUserGroups(userId: Int){
        RetrofitClient.instance.getUserGroups(userId)
            .enqueue(object : Callback<List<GroupResponse>> {
                var groups : List<GroupResponse>? = null

                override fun onFailure(call: Call<List<GroupResponse>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<GroupResponse>>,
                    response: Response<List<GroupResponse>>
                ) {
                    when {
                        response.code().toString() == "200" -> {
                            groups = response.body()!!
                            println(groups?.size)
                            setGroups(groups!!)
                        }
                        response.code().toString() == "204" -> {
                        }
                        else -> {
                            Toast.makeText(
                                applicationContext,
                                "Erro interno no servidor!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            })
    }

    fun setGroups(userGroups : List<GroupResponse>){
        val transaction = supportFragmentManager.beginTransaction()

        userGroups.forEachIndexed { _, g ->
            val parametros = Bundle()
            parametros.putInt("groupId", g.id!!)
            parametros.putString("groupName", g.groupName)
            parametros.putInt("groupType", g.groupType!!)
            parametros.putInt("groupOwner", g.groupOwner!!)
            parametros.putString("groupExternalId", g.externalGroupId)
            val groupsFragments = GroupFinance()
            groupsFragments.arguments = parametros

            transaction.add(R.id.groupFinanceFrag, groupsFragments, "group1")

        }
        transaction.commit()
    }
}
