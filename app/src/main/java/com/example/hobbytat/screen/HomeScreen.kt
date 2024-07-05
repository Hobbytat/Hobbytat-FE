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

            typeRanks?.let { rankList ->
                val topRank = rankList.firstOrNull()
                if (topRank != null) {
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

                            val imageRes = getHobbyTypeImage(topRank.hobbyType)
                            Image(
                                painter = painterResource(id = imageRes),
                                contentDescription = "1위캐릭터",
                                Modifier.size(150.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = topRank.hobbyType,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

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
}

@Composable
fun getHobbyTypeImage(hobbyType: String): Int {
    return when (hobbyType) {
        "ARTIST" -> R.drawable.character_artist
        "EXPLORER" -> R.drawable.character_explorer
        "SPORTSMAN" -> R.drawable.character_sportsman
        "HOBBYCRAFTER" -> R.drawable.character_hobbycrafter
        "KNOWLEDGESEEKER" -> R.drawable.character_knowledgeseeker
        "ARTHOBBYCRAFTER" -> R.drawable.character_arthobbycrafter
        "KNOWLEDGESPORTSMAN" -> R.drawable.character_knowledgesportsman
        "KNOWLEDGEHOBBYCRAFTER" -> R.drawable.character_knoledgehobbycrafter
        else -> R.drawable.character_artist // 여기 수정?
    }
}