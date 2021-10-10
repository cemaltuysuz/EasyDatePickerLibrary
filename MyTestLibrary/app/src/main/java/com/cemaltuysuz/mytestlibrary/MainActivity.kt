package com.cemaltuysuz.mytestlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.cemaltuysuz.easydatepicker.EasyDatePicker
import com.cemaltuysuz.easydatepicker.OnDateSelectListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create Instance
        val myDatePickerDialog =
            EasyDatePicker(this)
                .setFormatType("yyyy-MM-dd")
                .setListener(object : OnDateSelectListener{
                    override fun isSelected(date: String) {
                        Toast.makeText(applicationContext,date,Toast.LENGTH_SHORT).show()
                    }
                })



        findViewById<Button>(R.id.showButton).setOnClickListener {
            myDatePickerDialog.calendarShow()
        }

    }
}