package com.misakikawaguchi.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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

        // DatePickerDialogと呼ばれる画面を起動して日付を選択することができる
        val dpd = DatePickerDialog(this,
            // ユーザーが日付の選択を終了したことを示すために使用されるリスナー
            DatePickerDialog.OnDateSetListener() {
            // DatePickerDialog自体, 選択された年、選択さた月-1の値、選択された日
            view, selectedYear, selectedMonth, selectedDayOdMonth ->

            // 日付を選択した際の処理を記述、トーストを表示
            Toast.makeText(this, "The chosen year is $selectedYear, the month is ${selectedMonth+1} and the day is $selectedDayOdMonth", Toast.LENGTH_LONG).show()

            // 選択された日付は日/月/年の形式に設定される
            // Javaでカウントされる月は0から11であるため、選択した通りにできるように+1を追加する必要がある
            val selectedDate = "$selectedDayOdMonth/${selectedMonth+1}/$selectedYear"

            // tvSelectedDateのidを取得
            val tvSelectedDate:TextView = findViewById(R.id.tvSelectedDate)
            // フォーマッタは選択された日付をDateオブジェクトに解析するので、日付をms単位簡単に取得できる
            // tvSelectedDateに取得した日付を表示する
            tvSelectedDate.setText(selectedDate)

        }
        ,year
        ,month
        ,day)
    }
}