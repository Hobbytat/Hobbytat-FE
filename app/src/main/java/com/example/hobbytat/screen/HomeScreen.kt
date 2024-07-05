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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.Appbar
import com.example.hobbytat.common.CommonArticleBox
import com.example.hobbytat.common.CommonTopBar
import com.example.hobbytat.common.RankBox
import com.example.hobbytat.viewModel.TypeRankViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val scollState = rememberScrollState()
    val typeRankViewModel: TypeRankViewModel = viewModel()
    val typeRanks by typeRankViewModel.typeRanks.observeAsState()

    LaunchedEffect(Unit) {
        typeRankViewModel.fetchTypeRanks()
    }

    Scaffold(
        topBar = {
            CommonTopBar(navController)
        },
        bottomBar = {
            Appbar(selected = 1, navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
                .verticalScroll(scollState)
        ) {

            Text(
                text = "유형 순위", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
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
                        painter = painterResource(id = R.drawable.character_hobbycrafter),
                        contentDescription = "1위캐릭터",
                        Modifier.size(150.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // 추후에 1위 이름 받아오기로 수정예정
                Text(text = "지적인 취미 공예가 유형", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 추후 데이터 받아오기로 수정예정
            typeRanks?.let { rankList ->
                rankList.forEach { rank ->
                    RankBox(
                        rank = rank.rank,
                        boardType = rank.hobbyType,
                        percentage = rank.percent
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            } ?: run {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "이번주 인기글", fontSize = 18.sp, fontWeight = FontWeight.Bold,
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
                    order = 1
                ) {

                }

                Spacer(modifier = Modifier.height(20.dp))

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
                Spacer(modifier = Modifier.height(20.dp))

                CommonArticleBox(
                    "파리 올림픽 같이 응원해요",
                    "스포츠맨의 하비탯",
                    "손흥민",
                    12,
                    12,
                    12,
                    order = 3
                ) {

                }

                Spacer(modifier = Modifier.height(20.dp))
            }


        }
    }


}