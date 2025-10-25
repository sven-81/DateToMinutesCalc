package de.duge.dobcalb

import android.icu.text.SimpleDateFormat
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.Locale

class AgeViewModel : ViewModel() {
    private val _selectedDate = mutableStateOf("")
    val selectedDate: MutableState<String> = _selectedDate

    private val _ageInMinutes = mutableStateOf("")
    val ageInMinutes: MutableState<String> = _ageInMinutes

    fun onDateSelected(date: String) {
        _selectedDate.value = date

        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val parsedDate = simpleDateFormat.parse(date)
        parsedDate?.let {
            val diff = (System.currentTimeMillis() - it.time) / 60000
            _ageInMinutes.value = "%,d".format(diff)
        }
    }

}