package com.landfathich.testandroidwebview.storage

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {

    private val data: SharedPreferences = context
        .getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)
    private val editor = data.edit()

    fun putStringValue(name: String, value: String) {
        editor.putString(name, value).apply()
    }

    fun getStringValue(name: String): String? {
        return data.getString(name, null)
    }
}