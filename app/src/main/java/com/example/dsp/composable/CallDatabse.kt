package com.example.dsp.composable

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dsp.entity.SampleEntity
import com.example.dsp.ui.theme.Purple500
import com.example.dsp.viewmodel.SampleViewModel
import com.example.dsp.viewmodel.SampleViewModelFactory
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.*

val date = SimpleDateFormat("dd-MM-yyyy")
val strDate: String = date.format(Date())

val insertSampleData = listOf(
    SampleEntity(1,"Sample 1","Sample 1", "Image 1", strDate),
    SampleEntity(2,"Sample 2","Sample 2", "Image 2", strDate),
    SampleEntity(4,"Sample 4","Sample 4", "Image 4", strDate),
    SampleEntity(5,"Sample 5","Sample 5", "Image 5", strDate),
    SampleEntity(3,"Sample 3","Sample 3", "Image 3", strDate),
    SampleEntity(6,"Sample 6","Sample 6", "Image 6", strDate),
    SampleEntity(7,"Sample 7","Sample 7", "Image 7", strDate),
    SampleEntity(8,"Sample 8","Sample 8", "Image 8", strDate),
    SampleEntity(9,"Sample 9","Sample 11", "Image 9", strDate),
    SampleEntity(10,"Sample 10","Sample 10", "Image 10", strDate),
    SampleEntity(12,"Gautam","Sample 3","img url 15", strDate)
)

@Composable
fun CallDatabase() {
    val context = LocalContext.current
    val sampleViewModel: SampleViewModel = viewModel(
        factory = SampleViewModelFactory(context.applicationContext as Application)
    )

   // sampleViewModel.addSample(insertSampleData)

    val getAllRecord = sampleViewModel.readAllData.observeAsState(listOf()).value
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Database List Item",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            items(getAllRecord.size) { index ->
                AddDataListItem(getAllRecord[index])
            }
        }
    }
}
