package com.luki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson

val gson = Gson()

class SingUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landlord_sign_up)

        val btnSingUp = findViewById<Button>(R.id.buttonSignUp)

        btnSingUp.setOnClickListener { checkSingUP(it) }
    }

    private fun checkSingUP(btn: View) {
        val txtName = findViewById<EditText>(R.id.editTextName)
        val txtLastName = findViewById<EditText>(R.id.editTextLastName)
        val txtPhone = findViewById<EditText>(R.id.editTextPhone)
        val txtEmail = findViewById<EditText>(R.id.editTextEmail)
        val txtPass = findViewById<EditText>(R.id.editTextPassword)

        val name = txtName.text.toString()
        val lastName = txtLastName.text.toString()
        val phone = txtPhone.text.toString()
        val email = txtEmail.text.toString()
        val pass = txtPass.text.toString()

        val dict: MutableMap<String, Any> = mutableMapOf(
                "name" to name,
                "lastname" to lastName,
                "phone" to phone,
                "email" to email,
                "password" to pass
        )

        /*val dict: MutableMap<String, Any> = HashMap()
        dict["name"] = name
        dict["lastname"] = lastName
        dict["phone"] = phone
        dict["email"] = email
        dict["password"] = pass*/

        // to JSON
        val strJSON = gson.toJson(dict)

        Toast.makeText(this, strJSON, Toast.LENGTH_SHORT).show()

        // SEND POST REQUEST
    }


    // ====================== MENU ===================== //
    /**
     * onCreateOptionsMenu - Initialize the contents of the Activity's standard options menu
     * this function doesn't mutate the option selected
     *
     * [menu]: the menu object
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_sing_up, menu)
        return true
    }
}