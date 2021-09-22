package com.cemaltuysuz.easydatepicker

/**
 * @author Cemal Tuysuz
 * @date 22.09.2021
 * @link https://github.com/cemaltuysuz
 * */

import android.app.Activity

class EasyDatePicker (activity:Activity) {

    // Custom Style
    private var style:Int = R.style.DefaultDatePickerStyle
    // Activity
    private var activity: Activity = activity
    // onDateSelectListener interface for
    private var listener: OnDateSelectListener? = null
}