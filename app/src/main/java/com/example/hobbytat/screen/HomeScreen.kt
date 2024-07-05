package com.example.hobbytat.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.CommonArticleBox
import com.example.hobbytat.common.CommonTopBar
import com.example.hobbytat.common.RankBox

@Composable
fun HomeScreen(navController: NavHostController) {

    val scollState = rememberScrollState()

    Scaffold(
        topBar = {
            CommonTopBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
                .verticalScroll(scollState)
        ) {

            Text(
                text = "유형 순위", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.back_light),
                        contentDescription = "후광이미지",
                        Modifier.size(150.dp)
                    )

                    // 추후에 이미지 받아오기로 수정예정
                    Image(
                        painter = painterResource(id = R.drawable.character_craftsman),
                        contentDescription = "1위캐릭터",
                        Modifier.size(150.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 추후에 1위 이름 받아오기로 수정예정
                Text(text = "지적인 취미 공예가 유형")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 추후 데이터 받아오기로 수정예정
            Column {

                RankBox(1, "지적인 취미 공예가 유형", 40)
                Spacer(modifier = Modifier.height(10.dp))
                RankBox(2, "예술가 유형", 20)
                Spacer(modifier = Modifier.height(10.dp))
                RankBox(3, "스포츠맨 유형", 10)
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "이번주 인기글", fontSize = 16.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Column {
                CommonArticleBox(
                    "파리 올림픽 같이 응원해요",
                    "스포츠맨의 하비탯",
                    "손흥민",
                    12,
                    12,
                    12,
                    order = 2
                ) {

                }

                Spacer(modifier = Modifier.height(16.dp))

                CommonArticleBox(
                    "파리 올림픽 같이 응원해요",
                    "스포츠맨의 하비탯",
                    "손흥민",
                    12,
                    12,
                    12,
                    order = 2
                ) {

                }
            }


        }
    }


}