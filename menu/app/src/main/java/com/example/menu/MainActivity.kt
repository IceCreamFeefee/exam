package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_choice = findViewById<Button>(R.id.btn_choice);
        val order = findViewById<TextView>(R.id.order);


        val ed_drink = intent.getStringExtra("tea").toString();
        val sweet = intent.getStringExtra("sweet").toString();
        val ice = intent.getStringExtra("ice").toString();

        if(intent.hasExtra("tea") && intent.hasExtra("sweet") && intent.hasExtra("ice")) {
            order.text = ("飲料: $ed_drink\n\n甜度: $sweet\n\n冰塊: $ice");
        }else if(intent.hasExtra("order_check")){
            Toast.makeText(applicationContext, "請填入完整菜單", Toast.LENGTH_SHORT).show();
        }

        btn_choice.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java));
        }
    }
}