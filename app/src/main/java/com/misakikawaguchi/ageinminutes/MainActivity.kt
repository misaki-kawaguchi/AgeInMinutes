package com.misakikawaguchi.ageinminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

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

        /*
         *デフォルトのタイムゾーンとロケールを使用してカレンダーを取得（現在の時刻に基づく）
         */

        // getInstance()を使ってインスタンスを取得
        val myCalendar = Calendar.getInstance()
        // 「年」に関する値を取得
        val year = myCalendar.get(Calendar.YEAR)
        // 「月」に関する値を取得
        val month = myCalendar.get(Calendar.MONTH)
        // 「日」に関する値を取得
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

    }
}