package com.misakikawaguchi.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 親コンストラクターを呼び出す
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Select Dateボタン(btnDatePicker)のidを取得
        val btnDatePicker:Button = findViewById(R.id.btnDatePicker)
        //Select Dateボタンを押す
        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
        }
    }

    // Select Dateボタンを押した時の処理
    fun clickDatePicker(view: View) {

    }
}