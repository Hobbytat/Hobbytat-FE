package com.example.hobbytat.screen.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.Appbar
import com.example.hobbytat.common.CommonTopBar
import com.example.hobbytat.common.HobbytatBox

@Composable
fun BoardScreen(navController: NavHostController) {

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
            Text(
                text = "게시판에 참여해\n다양한 유형의 사람들과\n취향을 공유해보세요!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.main_blue)
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // 여기 나중에 데이터 받아오게 수정
                    items(5) {index ->
                        val boardId = index + 1 // 예시로 index를 사용하여 board_id 생성

                        HobbytatBox(title = "예술가의 하비탯", onClick = {
                            navController.navigate("Article/$boardId")
                        })
                    }
            }

        }
    }
}