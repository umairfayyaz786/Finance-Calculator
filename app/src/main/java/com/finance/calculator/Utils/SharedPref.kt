package com.finance.calculator.Utils

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

class SharedPref(context: Context) {

    internal lateinit var mysharedpref: SharedPreferences

    init {
        mysharedpref = context.getSharedPreferences("filename", Context.MODE_PRIVATE)
    }

    fun setStringValue(key: String, value: String) {
        if (!TextUtils.isEmpty(key)) {
            val editor: SharedPreferences.Editor = mysharedpref.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getStringValue(key: String): String {
        var stringValue: String = ""
        if (!TextUtils.isEmpty(key)) {
            stringValue = mysharedpref.getString(key, "No").toString()
        }
        return stringValue
    }

    fun setIntegerValue(key: String, value: Double) {
        if (!TextUtils.isEmpty(key)) {
            val editor: SharedPreferences.Editor = mysharedpref.edit()
            editor.putFloat(key, value.toFloat())
            editor.apply()
        }
    }

    fun getIntegerValue(key: String): Float {
        var value: Float = 0F
        if (!TextUtils.isEmpty(key)) {
            value = mysharedpref.getFloat(key, 0F)
        }
        return value
    }
}