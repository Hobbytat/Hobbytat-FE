package com.example.hobbytat.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbytat.R

@Composable
fun RankBox(
    rank: Int,
    boardType: String,
    percentage: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (rank == 1) colorResource(id = R.color.main_blue) else colorResource(
                    id = R.color.gray_200
                ),
                shape = RoundedCornerShape(12)
            )
            .background(
                if (rank == 1) colorResource(id = R.color.main_blue_light) else colorResource(
                    id = R.color.gray_50
                ),
                shape = RoundedCornerShape(12)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Text(
                text = rank.toString(),
                modifier = Modifier.padding(end = 8.dp),
                fontSize = 14.sp,
                color = if (rank == 1) colorResource(id = R.color.main_blue_dark) else colorResource(
                    id = R.color.gray_600
                )
            )
            Text(
                text = boardType, fontSize = 14.sp,
                color = if (rank == 1) colorResource(id = R.color.main_blue_dark) else colorResource(
                    id = R.color.gray_600
                )
            )
        }

        Text(
            text = "$percentage%", fontSize = 14.sp,
            color = if (rank == 1) colorResource(id = R.color.main_blue_dark) else colorResource(
                id = R.color.gray_600
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column {

        RankBox(1, "지적인 취미 공예가 유형", 40)

        Spacer(modifier = Modifier.height(10.dp))
        RankBox(2, "예술가 유형", 20)

        Spacer(modifier = Modifier.height(10.dp))
        RankBox(3, "스포츠맨 유형", 10)
    }
}