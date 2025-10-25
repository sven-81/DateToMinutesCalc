package de.duge.dobcalb

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import de.duge.dobcalb.ui.theme.DobCalcTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DobCalcTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.statusBars.asPaddingValues())
                ) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val viewModel: AgeViewModel = viewModel()

    val context = LocalContext.current

    AgeInMinutesScreen(
        selectedDate = viewModel.selectedDate.value,
        selectedDateInMinutes = viewModel.ageInMinutes.value,
        onDatePickerClick = {
            showDatePicker(
                context = context,
                onDateSelected = { inputDate ->
                    viewModel.onDateSelected(inputDate)
                })
        }
    )
}

fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePicker = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDateInput = "$selectedDay.${selectedMonth + 1}.$selectedYear"
            onDateSelected(selectedDateInput)
        },
        year, month, day
    )
    datePicker.datePicker.maxDate = System.currentTimeMillis()
    datePicker.show()
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    DobCalcTheme {
        App()
    }
}

@Preview(showBackground = true)
@Composable
fun AgeInMinutesScreenPreview() {
    AgeInMinutesScreen(
        selectedDate = "24.10.1995",
        selectedDateInMinutes = "15778800",
        onDatePickerClick = {}
    )
}