package com.cemaltuysuz.easydatepicker

/**
 * @author Cemal Tuysuz
 * @date 22.09.2021
 * @link https://github.com/cemaltuysuz
 * */

import android.app.Activity
import android.app.DatePickerDialog
import android.util.Log
import java.text.DateFormat
import java.util.*

/**
 * In order to create a Date Picker dialog, we need to get activity information from the user.
 * */
class EasyDatePicker (val activity:Activity) {

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

    /**
     * User can change default style
     * */
    fun setDatePickerStyle(style:Int):EasyDatePicker{
        this.style = style
        return this
    }

    fun setListener(listener: OnDateSelectListener):EasyDatePicker{
        this.listener = listener
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
                val x = calendar.time
                listener?.isSelected(DateFormat.getDateInstance().format(x)) // Send user
            }, year, month, day // Set current year / month / day
        )
        try {
            /**
             * I'm showing it in a try block in case of an unexpected error.
             * */
            datePicker.show()
        }catch (e: Exception){
            // Print Log
            Log.e("Easy date picker exception :", "ex : ${e.message}")
        }
    }
}