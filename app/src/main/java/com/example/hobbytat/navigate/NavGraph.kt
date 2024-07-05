package com.example.hobbytat.navigate

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hobbytat.screen.HomeScreen
import com.example.hobbytat.screen.board.BoardScreen
import com.example.hobbytat.screen.sign.LoginScreen
import com.example.hobbytat.screen.sign.SignupAgreeScreen
import com.example.hobbytat.screen.sign.SignupNicknameScreen
import com.example.hobbytat.screen.sign.SignupQuestionScreen
import com.example.hobbytat.screen.sign.SplashScreen
import com.example.hobbytat.viewModel.QuestionViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val questionViewModel: QuestionViewModel = viewModel()
    NavHost(navController = navController, startDestination = "SignUp_nickname"){
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
        composable(route="SignUp_Question") {
            // 회원가입_검사 화면
            SignupQuestionScreen(navController,questionViewModel)
        }
        composable(route="SignUp_nickname"){
            // 회원가입_닉네임 화면
            SignupNicknameScreen(navController)
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