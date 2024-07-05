package com.example.hobbytat.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hobbytat.screen.board.ArticleScreen
import com.example.hobbytat.screen.board.BoardScreen

@Composable
fun BoardNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Board") {
        composable("Board") { BoardScreen(navController = navController)}
        composable("Article/{boardId}") {backStackEntry ->
            val boardId = backStackEntry.arguments?.getString("boardId")?.toInt() ?: 0
            ArticleScreen(navController, boardId)
        }
    }
}