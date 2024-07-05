package com.example.hobbytat.screen.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.Appbar
import com.example.hobbytat.common.CommonArticleBox
import com.example.hobbytat.common.CommonTopBar

@Composable
fun ArticleScreen(navController: NavHostController, boardId: Int) {

    val title = when (boardId) {
        1 -> "공예가"
        2 -> "스포츠맨"
        3 -> "예술가"
        4 -> "지식 탐구가"
        5 -> "탐험가"
        else -> "기타"
    }

    Scaffold(
        topBar = {
            CommonTopBar(navController)
        },
        bottomBar = {
            Appbar(selected = 3, navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
        ) {
            Column {
                Text(
                    text = "${title}의 하비탯", fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.main_blue_dark)
                )
                Text(text = "게시판에 오신 것을 환영합니다 ~", fontSize = 16.sp)
            }
            
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "최신순", fontSize = 14.sp, color = colorResource(id = R.color.gray_700),
                    modifier = Modifier.padding(end = 8.dp)
                )
                // 여기에 드롭다운 onClick 추가 수정해야함
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "드롭다운 버튼"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                // 여기 데이터 받아오기 수정
                items(5) { index ->
                    val order = index + 1

                    CommonArticleBox(
                        "파리 올림픽 같이 응원해요",
                        "스포츠맨의 하비탯",
                        "손흥민",
                        12,
                        12,
                        12,
                        order = order
                    ) {

                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}