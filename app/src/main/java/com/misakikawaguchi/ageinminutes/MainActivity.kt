package com.misakikawaguchi.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
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
            // tvSelectedDateに取得した日付を表示する
            tvSelectedDate.setText(selectedDate)

            // Date Formatterのインスタンスを取得
            // 選択された日付を、パラメーターおよびロケールとして渡す形式でフォーマットするため
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            // フォーマッタは選択された日付をDateオブジェクトに解析するため、日付をms単位で取得できる
            val theDate = sdf.parse(selectedDate)

            // 経過時間の単位はms
            // 選択した日時の分を取得する ms→分に変換、60000で割る
            // msは1000で割ることで秒に変換できる、秒は60で割ることで分に変換できる
            val selectedDateInMinutes = theDate!!.time / 60000

            // 上記で使用したDateFormatterを使用して現在の日付を解析する
            // System.currentTimeMillesメソッド → ms単位で処理時間を計測する（戻り値はlong型）
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            // 現在の日時の分を取得する ms→分に変換、60000に割る
            val currentDateToMinutes = currentDate!!.time / 60000

            // 現在の日時から選択した日時を引く（分）
            val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes

            // tvSelectedDteInMinutesのidを取得
            val tvSelectedDateInMinutes: TextView = findViewById(R.id.tvSelectedDateInMinutes)
            // LongからStringに変換 引いた分を表示する
            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

        }
        ,year
        ,month
        ,day)
    }
}