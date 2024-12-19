package com.singlepointsol.validationdemo

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Signup : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var confirmEditText: EditText
    lateinit var signupButton: Button
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        nameEditText = findViewById(R.id.name_edit)
        phoneEditText = findViewById(R.id.phone_edit)
        emailEditText = findViewById(R.id.email_edit)
        confirmEditText = findViewById(R.id.confirm_edit)
        signupButton = findViewById(R.id.signup_btn)
        signupButton.setOnClickListener(this)
        sharedPrefs = getSharedPreferences(
            "single point solutions",
            MODE_PRIVATE
        )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.signup_btn -> {
                    val editor: SharedPreferences.Editor = sharedPrefs.edit()
                    editor.putString("nameKey", nameEditText.toString())
                    editor.putString("phonekey", phoneEditText.toString())
                    editor.putString("emailkey", emailEditText.toString())
                    editor.putString("confirmkey", confirmEditText.toString())
                    editor.apply()
                    nameEditText.text.clear()
                    phoneEditText.text.clear()
                    emailEditText.text.clear()
                    confirmEditText.text.clear()
                }
            }
        }
    }
}

//                R.id.signin_btn -> {
//                    if (sharedPrefs.contains("nameKey")) {
//                        val name: String = sharedPrefs.getString("nameKey", null).toString()
//                        nameEditText.setText(name)
//                    } else {
//                        Toast.makeText(this, "Empty name preference", Toast.LENGTH_LONG).show()
//                    }
//                    if (sharedPrefs.contains("phonekey")) {
//                        val phone: String = sharedPrefs.getString("phonekey", null).toString()
//                        phoneEditText.setText(phone)
//                    } else {
//                        Toast.makeText(this, "Empty phone preference", Toast.LENGTH_LONG).show()
//                    }
//                    if (sharedPrefs.contains("emailkey")) {
//                        val email: String = sharedPrefs.getString("emailkey", null).toString()
//                        emailEditText.setText(email)
//                    } else {
//                        Toast.makeText(this, "Empty email preference", Toast.LENGTH_LONG).show()
//                    }
//                    if (sharedPrefs.contains("confirmkey")) {
//                        val confirm: String = sharedPrefs.getString("confirmkey", null).toString()
//                        confirmEditText.setText(confirm)
//                    } else {
//                        Toast.makeText(this, "Empty confirm preference", Toast.LENGTH_LONG).show()
//                    }
//
//
//                }
//            }
//        }
//    }
//}
