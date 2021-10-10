package com.cemaltuysuz.easydatepicker

/**
 * @author Cemal Tuysuz
 * @date 22.09.2021
 * @link https://github.com/cemaltuysuz
 * */

import android.app.Activity
import android.app.DatePickerDialog
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * In order to create a Date Picker dialog, we need to get activity information from the user.
 * */
class EasyDatePicker (val activity:Activity,) {

    /**
     * The user can create his own style if he wishes.
     * Until then, the default style is considered selected.
     * @see R.style.DefaultDatePickerStyle
     * */
    private var style:Int = R.style.DefaultDatePickerStyle

    /**
     * When the user completes the date selection process,
     * we send her the selected date information with interface.
     * @see OnDateSelectListener
     * */
    private var listener: OnDateSelectListener? = null

    fun setListener(listener: OnDateSelectListener):EasyDatePicker{
        this.listener = listener
        return this
    }

    /**
     * The format in which the user-selected date will be converted.
     * If the user does not specify, the local format is accepted.
     * */
    private var formatPattern = "yyyy-MM-dd"

    fun setFormatType(type:String):EasyDatePicker{
        this.formatPattern = type
        return this
    }

    /**
     * User can change default style
     * */
    fun setDatePickerStyle(style:Int):EasyDatePicker{
        this.style = style
        return this
    }



    fun calendarShow(){
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR) // Current Year
        val month = calendar.get(Calendar.MONTH) // Current Month
        val day = calendar.get(Calendar.DAY_OF_MONTH) // Current Day

        // Create DatePickerDialog
        val datePicker = DatePickerDialog(
            this.activity, this.style,
            { _, year, month, dayOfMonth ->

                // FormatDate
                val formatDate = SimpleDateFormat(formatPattern, Locale.getDefault())

                /**
                 * I get the incoming year, month and day information and
                 * set it to the Calendar object.
                 * */
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                /**
                 * I take the date information in date format and
                 * format it into String data type.
                 * */

                try {
                    val formattedDate = formatDate.format(calendar.time) // Date Format
                    listener?.isSelected(formattedDate) // Send user
                }catch (e:Exception){
                    Log.e("Date Format Exception :","${e.message}")
                }

            }, year, month, day // Set current year / month / day
        )
        try {
            /**
             * I'm showing it in a try block in case of an unexpected error.
             * */
            datePicker.show()
        }catch (e: Exception){
            // Print Log
            Log.e("Easy date picker exception :", "${e.message}")
        }
    }
}