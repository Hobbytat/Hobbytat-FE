package com.example.hobbytat.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hobbytat.screen.HomeScreen
import com.example.hobbytat.screen.board.BoardScreen
import com.example.hobbytat.screen.sign.LoginScreen
import com.example.hobbytat.screen.sign.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Splash") {
        // 스플래쉬, 로그인, 회원가입 화면
        composable(route = "Splash") {
            SplashScreen(navController)
        }
        composable(route = "Login") {
            LoginScreen()
        }

        // 홈화면
        composable(route = "Home") {
            HomeScreen(navController)
        }

        // 밸런스 게임 화면
        composable(route = "Game") {

        }

        // 게시판 화면
        composable(route = "Board") {
            BoardScreen(navController)
        }

        // 마이페이지 화면
        composable(route = "MyPage") {

        }
    }
}