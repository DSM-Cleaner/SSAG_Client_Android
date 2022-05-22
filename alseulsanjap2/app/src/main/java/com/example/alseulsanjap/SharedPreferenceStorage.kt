package com.example.alseulsanjap

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceStorage(private val context: Context) {
    private var pref: SharedPreferences? = null

    fun getInfo(content: String?): String {
        if (pref == null) pref = context.getSharedPreferences("content", Context.MODE_PRIVATE)
        return if (content == "access_token") {
            "Bearer " + pref!!.getString(content, "")
        } else
            pref!!.getString(content, "").toString()
    }

    fun getNotBearerInfo(content: String?): String {
        if (pref == null) pref = context.getSharedPreferences("content", Context.MODE_PRIVATE)
        return pref!!.getString(content, "").toString()
    }


    fun saveInfo(info: String, content: String) {
        if (pref == null) pref = context.getSharedPreferences("content", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref!!.edit()
        editor.putString(content, info)
        editor.apply()
    }

    fun saveInfo(info: Int, content: String) {
        if (pref == null) pref = context.getSharedPreferences("content", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref!!.edit()
        editor.putInt(content, info)
        editor.apply()
    }
}