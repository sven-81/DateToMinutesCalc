package de.duge.dobcalb

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.duge.dobcalb.ui.theme.Blue

@Composable
fun AgeInMinutesScreen(
    selectedDate: String,
    selectedDateInMinutes: String,
    onDatePickerClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Blue)
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = White,
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(18.dp))

            Text(
                text = "CALCULATE YOUR",
                color = Blue,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp)
            )

            Text(
                text = "AGE",
                color = White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .background(Color.LightGray)
                    .padding(10.dp)
            )

            Text(
                text = "IN MINUTES",
                color = Blue,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)
            )

            Button(
                onClick = onDatePickerClick,
                colors = ButtonDefaults.buttonColors(containerColor = White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = "Select Date",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF929292)
                )
            }
            Spacer(modifier = Modifier.padding(18.dp))

            Text(
                text = selectedDate,
                color = Color(0xFF844046),
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 20.dp)
            )

            Text(
                text = "Selected Date",
                color = Blue,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.padding(18.dp))

            Text(
                text = selectedDateInMinutes,
                color = Color(0xFF844046),
                fontSize = 35.sp,
                modifier = Modifier.padding(top = 20.dp)
            )

            Text(
                text = "Age in minutes",
                color = Blue,
                fontSize = 18.sp
            )
        }
    }
}