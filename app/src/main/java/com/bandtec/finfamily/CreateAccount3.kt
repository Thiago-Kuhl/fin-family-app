package com.bandtec.finfamily

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bandtec.finfamily.api.RetrofitClient
import com.bandtec.finfamily.model.LoginResponse
import com.bandtec.finfamily.model.SignupResponse
import com.bandtec.finfamily.model.Users
import com.bandtec.finfamily.utils.MaskEditUtil
import kotlinx.android.synthetic.main.activity_create_account3.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateAccount3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account3)

        val spCreate3 : SharedPreferences = getSharedPreferences("spCreate1", Context.MODE_PRIVATE)

        inputcode.addTextChangedListener(MaskEditUtil.mask(inputcode, MaskEditUtil.FORMAT_FONE_AREA_CODE))
        inputnumber.addTextChangedListener(MaskEditUtil.mask(inputnumber, MaskEditUtil.FORMAT_FONE_AREA_NUMBER))


        buttonnext3.setOnClickListener {

            val fullName = spCreate3.getString("full_name", "")
            val cpf = spCreate3.getString("cpf", "")
            val birthday = spCreate3.getString("birthday", "")
            val email = spCreate3.getString("email", "")
            val password = spCreate3.getString("password", "")
            val nickname = inputcadastronick.text.toString()
            val phoneAreaCode = inputcode.text.toString()
            val phoneAreaNumber = inputnumber.text.toString()

            if (nickname.isEmpty()) {
                inputcadastronick.error = "Nickname is required!"
                inputcadastronick.requestFocus()
                return@setOnClickListener
            }

            if (phoneAreaCode.isEmpty()) {
                inputcode.error = "Area code is required!"
                inputcode.requestFocus()
                return@setOnClickListener
            }

            if (phoneAreaNumber.isEmpty()) {
                inputnumber.error = "Number is required!"
                inputnumber.requestFocus()
                return@setOnClickListener
            }

            val user = Users(fullName, cpf, birthday, email, password, nickname, phoneAreaCode, phoneAreaNumber)

            RetrofitClient.instance.signupUser(fullName!!, cpf!!, birthday!!, email!!, password!!, nickname, phoneAreaCode, phoneAreaNumber)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if(response.code().toString() == "201"){
                            Toast.makeText(applicationContext, response.body()?.email, Toast.LENGTH_LONG).show()
//                            sp.edit().putBoolean("logged", true).apply()
//                            sp.edit().putInt("id", response.body()?.id!!).apply()
//                            sp.edit().putString("full_name", response.body()?.fullName).apply()
//                            sp.edit().putString("email", response.body()?.email).apply()
//                            sp.edit().putString("nickname", response.body()?.nickname).apply()

                        }
                        else {
                            Toast.makeText(applicationContext, "ERROR!", Toast.LENGTH_LONG).show()
                        }


                    }

                })
        }
    }
}
