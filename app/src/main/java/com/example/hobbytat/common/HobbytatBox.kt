package com.example.hobbytat.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbytat.R

@Composable
fun HobbytatBox(
//    img: String,
    title: String,
    onClick: () -> Unit
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.artist_bg), contentDescription = "하비탯이미지",
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .clickable(onClick = onClick)
                .width(170.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview
@Composable
private fun Preview() {
    HobbytatBox("예술가의 하비탯") {

    }
}