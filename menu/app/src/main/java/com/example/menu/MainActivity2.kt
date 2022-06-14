package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tea = findViewById<RadioGroup>(R.id.tea);
        val sweet = findViewById<RadioGroup>(R.id.sweet);
        val ice = findViewById<RadioGroup>(R.id.ice);
        val send_menu = findViewById<Button>(R.id.send_menu);

        val actionBar = supportActionBar;
        val intent = Intent(this, MainActivity::class.java)
        if(actionBar != null){
            actionBar.title = "菜單選擇";
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        intent.putExtra("sweet", findViewById<RadioButton>(R.id.no_sugar).text.toString());
        intent.putExtra("ice", findViewById<RadioButton>(R.id.no_ice).text.toString());
        intent.putExtra("tea", findViewById<RadioButton>(R.id.black_tea).text.toString());
        sweet.setOnCheckedChangeListener { _, i ->
            intent.putExtra("sweet", findViewById<RadioButton>(i).text.toString());
        }
        ice.setOnCheckedChangeListener{ _, i->
            intent.putExtra("ice", findViewById<RadioButton>(i).text.toString());
        }
        tea.setOnCheckedChangeListener{ _, i->
            intent.putExtra("tea", findViewById<RadioButton>(i).text.toString());
        }

        send_menu.setOnClickListener {
            intent.putExtra("order_check", true);
            startActivity(intent);
        }

    }
}