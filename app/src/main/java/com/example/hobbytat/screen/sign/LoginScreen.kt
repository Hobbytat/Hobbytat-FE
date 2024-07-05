package com.example.hobbytat.screen.sign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
        modifier= Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Spacer(modifier = Modifier.height(40.dp))
        LoginTextField(
            value = userID,
            onValueChange = {userID=it},
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            hint = "아이디"
        )
        Spacer(modifier = Modifier.height(15.dp))
        LoginTextField(
            value = userPassWord,
            onValueChange = {userPassWord=it},
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            hint = "비밀번호"
        )
        Spacer(modifier = Modifier.height(30.dp))
        LoginButton(label = "로그인") {
            navController.navigate("Home")
        }

    }
}