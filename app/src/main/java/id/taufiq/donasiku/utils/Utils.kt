package id.taufiq.donasiku.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import java.text.NumberFormat
import java.util.*

/**
 * Created By Taufiq on 1/20/2021.
 *
 */

fun <T> Context.startActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun delayFunction(function: () -> Unit, delay: Long) {
    @Suppress("DEPRECATION")
    Handler().postDelayed(function, delay)
}

fun formatRupiahs(number: Double) : String {
    val localeID = Locale("in", "ID")
    val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
    return formatRupiah.format(number)
}