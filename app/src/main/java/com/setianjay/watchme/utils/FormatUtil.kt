package com.setianjay.watchme.utils

import java.text.SimpleDateFormat
import java.util.*

object FormatUtil {

    /**
     * convert date from "yyyy-MM-dd" to "dd/MM/yyyy"
     * eg. 2021-12-01 to be 01/12/2021
     *
     * @param   date    String og date with pattern(yyyy-MM-dd)
     * @return          String of date with pattern(dd/MM/yyyy)
     * */
    fun dateFormat(date: String): String {
        if (date.isEmpty()) {
            return "11/11/2000"
        }

        val resultDate = try {
            val oldFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val oldDate = oldFormat.parse(date)

            return if (oldDate != null){
                val newFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                newFormat.format(oldDate)
            }else{
                "11/11/2000"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "11/11/2000"
        }

        return resultDate
    }

    /**
     * genre format
     *
     * @param genre     String of genre with value(Drama, Fantasy, )
     * @return          String of genre with value(Drama, Fantasy)
     * */
    fun genreFormat(genre: String): String {
        if (genre.isEmpty()) {
            return "Drama"
        }

        return genre.substring(0, genre.length - 2)
    }
}