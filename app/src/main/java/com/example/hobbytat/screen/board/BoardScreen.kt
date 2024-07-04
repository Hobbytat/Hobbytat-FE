package com.example.hobbytat.screen.board

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.hobbytat.common.Appbar

@Composable
fun BoardScreen(navController: NavHostController) {
    Appbar(selected = 3, navController = navController)
}