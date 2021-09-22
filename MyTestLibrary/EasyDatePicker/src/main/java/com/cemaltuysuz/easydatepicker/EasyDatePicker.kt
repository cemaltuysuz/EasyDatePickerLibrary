package com.cemaltuysuz.easydatepicker

/**
 * @author Cemal Tuysuz
 * @date 22.09.2021
 * @link https://github.com/cemaltuysuz
 * */

import android.app.Activity

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
}