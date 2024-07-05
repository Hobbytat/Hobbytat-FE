package com.example.hobbytat.common

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbytat.R

@Composable
fun CommonBottomButton(
    label: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(12.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.main_blue)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.main_blue_bg))
    }
}

@SuppressLint("ResourceAsColor")
@Composable
fun WhiteCommonBottomButton(
    label: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 15.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = label,
            color= colorResource(R.color.main_blue),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BlueButton(
    label: String,
    corner : Int,
    fontSize : Int,
    height : Int,
    color : Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = color)),
        shape = RoundedCornerShape(corner.dp)
    ) {
        Text(
            text = label,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
