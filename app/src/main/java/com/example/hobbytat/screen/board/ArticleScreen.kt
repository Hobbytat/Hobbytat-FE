package com.example.hobbytat.screen.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.Comment
import com.example.hobbytat.viewModel.ArticlesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(navController: NavHostController, articleId: Int, boardId: Int) {
    val articlesViewModel: ArticlesViewModel = viewModel()
    val article by articlesViewModel.article.observeAsState()

    LaunchedEffect(articleId) {
        articlesViewModel.fetchArticleById(boardId, articleId)
    }

    val boardType = when (boardId) {
        1 -> "공예가"
        2 -> "스포츠맨"
        3 -> "예술가"
        4 -> "지식 탐구가"
        5 -> "탐험가"
        else -> "기타"
    }

    var title = "예술가 완전 별로임"
    var userName = "나는야 스포츠맨"
    var profileImg = painterResource(id = R.drawable.sample_profile)
    var date = "2024-07-04"
    var content = "걔네 완전 예술가인척 해\n" +
            "스포츠를 해야 건강하지 연약한 것들"
    var likeCount = 12
    var commentCount = 12

    val scollState = rememberScrollState()

    var comment by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .background(colorResource(id = R.color.main_blue))
                    .height(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_white),
                    contentDescription = "로고 버튼",
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
                        .size(width = 78.dp, height = 28.dp)
                        .clickable {
                            navController.navigate("Home")
                        }
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "뒤로가기",
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                        tint = colorResource(id = R.color.main_blue_bg)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = "${boardType}의 하비탯",
                            color = colorResource(
                                id = R.color.main_blue_bg
                            ),
                            fontSize = 16.sp,
                            fontWeight = Bold,
                        )
                    }
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = comment,
                    onValueChange = { comment = it },
                    placeholder = { Text(text = "댓글을 입력하세요") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier
                        .background(colorResource(id = R.color.main_blue_bg)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = colorResource(id = R.color.gray_100),
                        focusedBorderColor = colorResource(id = R.color.gray_400)
                    )
                )

                Button(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(14.dp),
                    modifier = Modifier
                        .wrapContentHeight()
                        .width(80.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.main_blue)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "등록", fontSize = 16.sp)
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(scollState)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = title, fontSize = 18.sp, fontWeight = Bold)
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = profileImg,
                                contentDescription = "프로필이미지",
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop,
                            )
                            Column(
                                modifier = Modifier.padding(start = 12.dp)
                            ) {

                                Text(
                                    text = userName,
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.gray_600)
                                )
                                Text(
                                    text = date,
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.gray_600)
                                )
                            }
                        }
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.ic_kebab),
                        contentDescription = "케밥버튼"
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = content, fontSize = 14.sp)

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_like),
                        contentDescription = "좋아요 아이콘",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp),
                    )
                    Text(
                        text = "$likeCount Likes",
                        modifier = Modifier.padding(end = 12.dp),
                        color = colorResource(id = R.color.gray_700),
                        fontSize = 12.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_comment),
                        contentDescription = "댓글 아이콘",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(20.dp),
                        tint = colorResource(id = R.color.gray_700)
                    )
                    Text(
                        text = "$commentCount Comments",
                        color = colorResource(id = R.color.gray_700),
                        fontSize = 12.sp
                    )
                }
            }

            Divider()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
                Comment(
                    "예술적인 공예가", "2024-07-04", "어떻게 그런 말을 해?"
                )
            }
        }
    }

}