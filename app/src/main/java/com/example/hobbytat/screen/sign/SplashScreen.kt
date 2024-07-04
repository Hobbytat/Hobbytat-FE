package com.example.hobbytat.screen.sign

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.hobbytat.common.Appbar

@Composable
fun SplashScreen(navController: NavHostController) {
    Appbar(selected = 1, navController = navController)
}