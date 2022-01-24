package com.example.dsp.composable

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dsp.entity.SampleEntity
import com.example.dsp.scrollableColumn
import com.example.dsp.viewmodel.SampleViewModel
import com.example.dsp.viewmodel.SampleViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun InfoPage(navController: NavController) {
    val date = SimpleDateFormat("dd-MM-yyyy")
    val strDate: String = date.format(Date())
    scrollableColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val sampleViewModel: SampleViewModel = viewModel(
            factory = SampleViewModelFactory(context.applicationContext as Application)
        )
        val Id = remember{ mutableStateOf("") }
        val Name = remember { mutableStateOf("") }
        val Desc = remember{ mutableStateOf("") }
        val Imgurl = remember { mutableStateOf("") }
        Text(
            text = "Enter your data",
            textAlign = TextAlign.Justify,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        TextField(
            value = Id.value,
            onValueChange = { Id.value = it },
            placeholder = { Text(text = "ID", color = Color(0xFF4C78DB)) },
            label = { Text(text = "ID", color = Color.Black) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color(0xFFC9C9C9),
                focusedIndicatorColor = Color(0xFFC9C9C9),
                backgroundColor = Color(0xFFE5EAF5)
            ),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(
                    RoundedCornerShape(
                        topStart = 11.dp,
                        topEnd = 11.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
                .background(Color(0xFFF6F8FD)),
            textStyle = TextStyle(
                color = Color(0xFF4C78DB)
            )
        )
        TextField(
            value = Name.value,
            onValueChange = { Name.value = it },
            placeholder = { Text(text = "Name", color = Color(0xFF4C78DB)) },
            label = { Text(text = "Name", color = Color.Black) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color(0xFFC9C9C9),
                focusedIndicatorColor = Color(0xFFC9C9C9),
                backgroundColor = Color(0xFFE5EAF5)
            ),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .background(Color(0xFFF6F8FD)),
            textStyle = TextStyle(
                color = Color(0xFF4C78DB)
            )
        )
        TextField(
            value = Desc.value,
            onValueChange = { Desc.value = it },
            placeholder = { Text(text = "Desc", color = Color(0xFF4C78DB)) },
            label = { Text(text = "Desc", color = Color.Black) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color(0xFFC9C9C9),
                focusedIndicatorColor = Color(0xFFC9C9C9),
                backgroundColor = Color(0xFFE5EAF5)
            ),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .background(Color(0xFFF6F8FD)),
            textStyle = TextStyle(
                color = Color(0xFF4C78DB)
            )
        )
        TextField(
            value = Imgurl.value,
            onValueChange = { Imgurl.value = it },
            placeholder = { Text(text = "Img name",color = Color(0xFF4C78DB)) },
            label = { Text(text = "Img", color = Color.Black) },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color(0xFFC9C9C9),
                focusedIndicatorColor = Color(0xFFC9C9C9),
                backgroundColor = Color(0xFFE5EAF5)
            ),
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 11.dp,
                        bottomEnd = 11.dp
                    )
                )
                .background(Color(0xFFF6F8FD)),
            textStyle = TextStyle(
                color = Color(0xFF4C78DB)
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
              val new = listOf(SampleEntity (Id.value.toInt(), Name.value, Desc.value,Imgurl.value,strDate))
            sampleViewModel.addSample(new)
            navController.navigate(Screens.CallDatabase.route)
        },
            modifier = Modifier
                .clip(RoundedCornerShape(19.dp))
                .background(Color(0xFF4C78DB))
        ) {
            Text(
                text = "Save",
                fontSize = 20.sp
            )
        }
    }
}