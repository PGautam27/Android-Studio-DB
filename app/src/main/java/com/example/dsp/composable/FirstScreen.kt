package com.example.dsp.composable

import android.graphics.Paint
import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen() {
    val Name = remember{ mutableStateOf("NIL")}
    val Age = remember { mutableStateOf("0")}
    val Name1 = remember{ mutableStateOf("")}
    val Age1 = remember{ mutableStateOf("")}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 57.dp, top = 140.dp)
    ) {
        TextField(
            value = Name.value ,
            onValueChange = {Name.value=it},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
                backgroundColor = Color.White
            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.layoutId("f2")
        )
        Spacer(modifier = Modifier.padding(0.dp))
        TextField(
            value = Age.value,
            onValueChange = {Age.value = it},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
                backgroundColor = Color.White
            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ), modifier = Modifier.layoutId("f1")
        )
        Spacer(modifier = Modifier.padding(15.dp))
        
        Text(text = "Enter Your details", style = TextStyle(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(15.dp))
        TextField(
            value = Name1.value,
            onValueChange = { Name.value = it },
            label = { Text(text = "NAME", color = Color.Black)},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )
        Spacer(modifier = Modifier.padding(15.dp))
        TextField(
            value = Age1.value,
            onValueChange = {Age.value = it},
            label = { Text(text = "AGE", color = Color.Black)},
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )

            )
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
    }
}