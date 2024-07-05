package com.example.hobbytat.screen.sign

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.WhiteCommonBottomButton

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current
    val backgroundColor = ContextCompat.getColor(context, R.color.main_blue)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(backgroundColor))
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_white),
                contentDescription = "로고 화이트",
                modifier = Modifier
                    .width(230.dp)
                    .height(105.dp)
            )
            Text(
                text = "당신을 위한 취향저격 안식처",
                color = Color.White,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column {
            WhiteCommonBottomButton(label = "회원가입") {
                // 설문조사 동의 페이지로 이동
                navController.navigate("SignUp_agree")
            }
            WhiteCommonBottomButton(label = "로그인") {
                // 로그인 페이지로 이동
                navController.navigate("Login")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}