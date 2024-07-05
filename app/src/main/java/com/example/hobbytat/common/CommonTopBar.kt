package com.example.hobbytat.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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