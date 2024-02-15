package abika.sinau.libraries.component.utils

import android.icu.text.NumberFormat
import java.util.Locale

actual val Double.toRupiah: String get() {
    val locale = Locale("id", "ID")
    val numberFormat = NumberFormat.getCurrencyInstance(locale)
    return numberFormat.format(this)
}