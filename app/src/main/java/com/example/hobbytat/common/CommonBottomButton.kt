package com.example.hobbytat.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hobbytat.R

@Composable
fun CommonBottomButton(
    label: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.main_blue)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = label)
    }
}

@Preview
@Composable
private fun Preview() {
    CommonBottomButton("등록하기") {

    }
}