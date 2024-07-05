package com.example.hobbytat.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(navController: NavHostController) {

    TopAppBar(title = {
        Image(
            painterResource(id = R.drawable.logo_blue), contentDescription = "로고 이미지",
            modifier = Modifier
                .size(width = 78.dp, height = 28.dp)
                .clickable {
                    navController.navigate("Home")
                }
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signupTopBar() {

    TopAppBar(title = {
        Image(
            painterResource(id = R.drawable.logo_blue), contentDescription = "로고 이미지",
            modifier = Modifier.size(width = 78.dp, height = 28.dp)
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LongTopBar(title: String) {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.main_blue))
            .height(215.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_white),
            contentDescription = "로고 버튼",
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .size(width = 78.dp, height = 28.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, start = 20.dp),
        ){
            Text(
                text = title,
                color = colorResource(id = R.color.white),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                lineHeight = 40.sp
            )
        }
    }
}