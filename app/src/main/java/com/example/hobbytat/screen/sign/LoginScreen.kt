package com.example.hobbytat.screen.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.CommonBottomButton
import com.example.hobbytat.common.LoginButton
import com.example.hobbytat.common.LoginTextField

@Composable
fun LoginScreen(navController: NavHostController) {
    var userID by remember {
        mutableStateOf("")
    }
    var userPassWord by remember{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(140.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_blue),
                contentDescription = "로고 블루",
                modifier = Modifier
                    .width(230.dp)
                    .height(105.dp)
            )
            Text(
                text = "당신을 위한 취향저격 안식처를 시작해보세요",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.gray_600)
            )
            Spacer(modifier = Modifier.height(50.dp))
            LoginTextField(
                value = userID,
                onValueChange = { userID = it },
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                hint = "아이디"
            )
            Spacer(modifier = Modifier.height(15.dp))
            LoginTextField(
                value = userPassWord,
                onValueChange = { userPassWord = it },
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                hint = "비밀번호"
            )
            Spacer(modifier = Modifier.height(30.dp))
            LoginButton(label = "로그인") {
                navController.navigate("Home")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_login_with),
                contentDescription = "loginwith",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_kakao),
                contentDescription = "카카오 로그인",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 40.dp)
        ) {
            Text(
                text = "계정이 없으신가요?",
                color = colorResource(id = R.color.gray_300)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "회원가입",
                color = colorResource(id = R.color.gray_700),
                modifier = Modifier.clickable {
                    navController.navigate("SignUp_agree")
                }
            )
        }
    }
}