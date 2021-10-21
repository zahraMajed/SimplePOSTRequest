package com.example.simplepostrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var edName: EditText
    lateinit var btnSave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName=findViewById(R.id.edName)
        btnSave=findViewById(R.id.btnSave)

        btnSave.setOnClickListener(){
            if (edName.text.isNotEmpty()){
                postName()
            }else
                Toast.makeText(applicationContext, "empty entry",Toast.LENGTH_LONG).show()
        }
    }//end onCreate()

    fun postName(){
        val apIinterface=APIclint().getClient()?.create(APIinterface::class.java)
        apIinterface?.postName(myData.myDataItem(edName.text.toString(),1))?.enqueue(object : Callback<myData.myDataItem?> {
            override fun onResponse(call: Call<myData.myDataItem?>, response: Response<myData.myDataItem?>) {
                Toast.makeText(applicationContext, "${edName.text}: your name has added successfully", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<myData.myDataItem?>, t: Throwable) {
                Toast.makeText(applicationContext, "$t error ", Toast.LENGTH_LONG).show()
            }
        })//end enqueue()
    }//end postName()
}