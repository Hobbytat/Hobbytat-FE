package com.example.hobbytat.screen.board

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
import com.example.hobbytat.viewModel.ArticlesViewModel

@Composable
fun ArticleListScreen(navController: NavHostController, boardId: Int) {
    val viewModel: ArticlesViewModel = viewModel()

    val articles by viewModel.articles.observeAsState()

    LaunchedEffect(boardId) {
        viewModel.fetchArticles(boardId) // Fetch articles from API
    }

    val boardType = when (boardId) {
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
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate("PostArticle") },
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "플러스 아이콘",
                    )
                },
                text = {
                    Text(
                        text = "글쓰기",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                },
                containerColor = colorResource(id = R.color.main_blue),
                contentColor = colorResource(id = R.color.main_blue_bg),
                shape = RoundedCornerShape(100.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
        ) {
            Column {
                Text(
                    text = "${boardType}의 하비탯", fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
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

//            articles?.let { articlesData ->
//                LazyColumn {
//                    items(articlesData.data) { article ->
//                        CommonArticleBox(
//                            title = "파리올림픽 같이 응원해요",
//                            boardType = boardType,
//                            userName = "손흥민",
//                            viewCount = 12,
//                            likeCount = 12,
//                            commentCount = 12,
//                            order = article.articleId
//                        ) {
//                            navController.navigate("Article/${article.articleId}/${boardId}")
//                        }
//
//                        Spacer(modifier = Modifier.height(20.dp))
//                    }
//                }
//            } ?: run {
//                // 데이터가 로딩 중일 때 표시할 UI
//                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
//            }

            CommonArticleBox(
                title = "파리올림픽 같이 응원해요",
                boardType = boardType,
                userName = "손흥민",
                viewCount = 12,
                likeCount = 12,
                commentCount = 12,
                order = 1
            ) {
                navController.navigate("Article/${2}/${1}")
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}