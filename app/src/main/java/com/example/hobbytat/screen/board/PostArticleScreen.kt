package com.example.hobbytat.screen.board

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.CommonBottomButton
import com.example.hobbytat.common.CommonTextField
import com.example.hobbytat.common.CommonTopBar

@Composable
fun PostArticleScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CommonTopBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "게시글 작성하기",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = colorResource(
                            id = R.color.main_blue_dark
                        )
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = "닫기 버튼",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                CommonTextField(title = "제목*", value = title, imeAction = ImeAction.Next, modifier = Modifier.fillMaxWidth()) {
                    title = it
                }
                Spacer(modifier = Modifier.height(20.dp))

                CommonTextField(title = "상세 내용*", value = content, imeAction = ImeAction.Done, modifier = Modifier.fillMaxWidth().height(200.dp)) {
                    content = it
                }
            }
            
            CommonBottomButton(label = "등록하기", modifier = Modifier.fillMaxWidth().padding(bottom = 40.dp)) {
                
            }
        }
    }
}