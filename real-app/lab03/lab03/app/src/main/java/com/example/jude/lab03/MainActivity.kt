package com.example.jude.lab03

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val LOGIN_REQUEST = 1
    }


    fun handleAbout(v: View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun handleLogin(v: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivityForResult(intent,LOGIN_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var text = "Unsuccessful"

        if(requestCode == LOGIN_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                //Set toast message to Successful
                text = "Successful"
            }
        }
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
        toast.show()
    }


}
