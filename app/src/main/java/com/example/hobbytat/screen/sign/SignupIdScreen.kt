package com.example.hobbytat.screen.sign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.BlueButton
import com.example.hobbytat.common.CommonTextField
import com.example.hobbytat.common.LongTopBar

@Composable
fun SignupIdScreen(navController: NavHostController) {
    var userID by remember {
        mutableStateOf("")
    }
    var userPassWord by remember{
        mutableStateOf("")
    }
    var userPassWordCheck by remember{
        mutableStateOf("")
    }
    var canUse by remember{
        mutableStateOf("사용 가능한 아이디입니다")
    }
    var checkPassWord by remember{
        mutableStateOf("비밀번호가 일치합니다")
    }

    Scaffold(
        topBar = {
            LongTopBar("아이디와\n비밀번호를\n설정해주세요")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 60.dp)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Column {
                        CommonTextField(
                            title ="아이디",
                            value = userID,
                            imeAction = ImeAction.Done,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = {userID = it}
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = canUse,
                                color = colorResource(id = R.color.gray_500),
                                fontSize = 12.sp
                            )

                            Button(
                                onClick = {
                                    // 중복 확인
                                },
                                contentPadding = PaddingValues(5.dp),
                                modifier = Modifier
                                    .width(100.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.main_blue))
                            ) {
                                Text(
                                    text = "중복 확인",
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    CommonTextField(
                        title ="비밀번호",
                        value = userPassWord,
                        imeAction = ImeAction.Next,
                        modifier = Modifier.fillMaxWidth(),
                        onValueChange = {userPassWord = it}
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Column {
                        CommonTextField(
                            title ="비밀번호 확인",
                            value = userPassWordCheck,
                            imeAction = ImeAction.Done,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = {userPassWordCheck = it}
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = checkPassWord,
                            color = colorResource(id = R.color.gray_500),
                            fontSize = 12.sp
                        )
                    }
                }
                BlueButton(
                    label = "등록하기",
                    corner = 8,
                    fontSize = 16,
                    height = 45,
                    color = R.color.main_blue) {
                    // 로그인 화면으로 이동
                    navController.navigate("Login")
                }
            }
        }
    }
}