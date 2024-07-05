package com.example.hobbytat.screen.sign

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.BlueButton
import com.example.hobbytat.common.CommonTextField
import com.example.hobbytat.common.LongTopBar
import com.example.hobbytat.viewModel.QuestionViewModel

@Composable
fun SignupNicknameScreen(navController: NavHostController) {
    var nickname by remember {
        mutableStateOf("")
    }
    var CanUse by remember{
        mutableStateOf("사용 가능한 닉네임입니다")
    }

    Scaffold(
        topBar = {
            LongTopBar("닉네임과\n프로필 이미지를\n입력해주세요")
        }
    ){paddingValues ->
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
                    Text(
                        text = "프로필 사진 (선택)",
                        fontSize = 16.sp
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_none_profile),
                            contentDescription = "기본 프로필",
                            modifier = Modifier.size(100.dp)
                        )
                        Button(
                            onClick = {
                                // 이미지 등록
                            },
                            contentPadding = PaddingValues(5.dp),
                            modifier = Modifier
                                .width(100.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.gray_50)),
                            border = BorderStroke(1.dp, colorResource(id = R.color.gray_700))
                        ) {
                            Text(
                                text = "이미지 등록",
                                fontSize = 14.sp,
                                color = Color.Black
                            )
                        }
                    }

                    Column {
                        CommonTextField(
                            title ="닉네임",
                            value = nickname,
                            imeAction = ImeAction.Done,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = {nickname = it}
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
                                text = CanUse,
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
                }
                
                BlueButton(
                    label = "다음으로",
                    corner = 8,
                    fontSize = 16,
                    height = 45,
                    color = R.color.main_blue) {
                    // 회원가입_아이디 화면으로 이동
                    navController.navigate("SignUp_id")
                }
            }
        }

    }
}

