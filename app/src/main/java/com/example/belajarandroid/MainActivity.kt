package com.example.belajarandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")

    val user = "frand"
    val pass = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        menutup mata dan membuka mata
        iv_mata.setOnTouchListener{ p0, p1 ->
            when(p1.action){
                MotionEvent.ACTION_DOWN ->{
                    password.transformationMethod = HideReturnsTransformationMethod()
                    iv_mata.setImageResource(R.drawable.ic_baseline_visibility_24)
                }
                MotionEvent.ACTION_UP ->{
                    password.transformationMethod = PasswordTransformationMethod.getInstance()
                    iv_mata.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                }
            }
            true
        }

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.button)
        val registasi = findViewById<TextView>(R.id.registrasi)

        val google = findViewById<ImageView>(R.id.google)
        val fb = findViewById<ImageView>(R.id.fb)
        val tw = findViewById<ImageView>(R.id.tw)

        registasi.setOnClickListener{startActivity(Intent(this@MainActivity, Registasi::class.java))}
        google.setOnClickListener(this)
        fb.setOnClickListener{startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://id-id.facebook.com/")))}
        tw.setOnClickListener{startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/i/flow/login")))}

        button.setOnClickListener{
            if(username.getText().toString().equals(user)&&password.getText().toString().equals(pass)){
                Toast.makeText(applicationContext,"Login Berhasil", Toast.LENGTH_SHORT).show()
                //                startActivity(Intent(this@MainActivity, Dashboard::class.java))
                startActivity(Intent(this@MainActivity, ListApp::class.java))
//                startActivity(Intent(this@MainActivity, fragmentbasic::class.java))
            }else if (username.text.isEmpty()){
                Toast.makeText(applicationContext,"Email kosong silahkan masukkan email anda!",
                    Toast.LENGTH_SHORT).show()
            }else if (password.text.isEmpty()){
                Toast.makeText(applicationContext,"password kosong silahkan masukkan password anda!",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"data yang anda masukkan salah", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.google ->{
                val google = Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com"))
                startActivity(google)
            }
        }
    }
}