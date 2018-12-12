package com.example.jude.lab03

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun handleLogin(v: View) {
        //extract user input from form
        val username = inpUsername.text.toString()
        val password = inpPassword.text.toString()

        //validate and close activity
        if (username.equals(getString(R.string.valid_username)) && password.equals(getString(R.string.valid_password))) {
            setResult(Activity.RESULT_OK)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
