package com.example.dsp.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dsp.entity.SampleEntity

@Composable
fun AddDataListItem(sampleEntity: SampleEntity) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = sampleEntity.name,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = sampleEntity.desc,
                    modifier = Modifier
                        .weight(1.0f),
                    fontSize = 15.sp,
                    color = Color.Black
                )

                Text(
                    text = sampleEntity.createdDate,
                    modifier = Modifier
                        .weight(0.5f),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
