package com.example.hobbytat.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hobbytat.screen.HomeScreen
import com.example.hobbytat.screen.board.ArticleScreen
import com.example.hobbytat.screen.board.BoardScreen
import com.example.hobbytat.screen.board.PostArticleScreen
import com.example.hobbytat.screen.sign.LoginScreen
import com.example.hobbytat.screen.sign.SignupAgreeScreen
import com.example.hobbytat.screen.sign.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home"){
        // 스플래쉬, 로그인, 회원가입 화면
        composable(route = "Splash") {
            // 스플래쉬 화면
            SplashScreen(navController)
        }
        composable(route="Login") {
            // 로그인 화면
            LoginScreen(navController)
        }
        composable(route="SignUp_agree") {
            // 회원가입_동의 화면
            SignupAgreeScreen(navController)
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

        // 게시글 화면
        composable("Article/{boardId}") { backStackEntry ->
            val boardId = backStackEntry.arguments?.getString("boardId")?.toInt() ?: 0
            ArticleScreen(navController, boardId)
        }

        // 게시글 작성하기 화면
        composable(route = "PostArticle") {
            PostArticleScreen(navController)
        }
    }
}