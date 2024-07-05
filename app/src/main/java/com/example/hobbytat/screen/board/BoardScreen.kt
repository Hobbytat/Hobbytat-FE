package com.example.hobbytat.screen.board

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.Appbar
import com.example.hobbytat.common.CommonTopBar
import com.example.hobbytat.viewModel.BoardsViewModel

@Composable
fun BoardScreen(navController: NavHostController) {
    val viewModel: BoardsViewModel = viewModel()
    val boards by viewModel.boards.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchBoards()
    }

    Log.d("board", boards.toString())

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

//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                horizontalArrangement = Arrangement.spacedBy(20.dp)
//            ) {
//                boards?.let {
//                    items(it.data) {board ->
//                        HobbytatBox(title = board.title, onClick = {
//                            navController.navigate("ArticleList/${board.board_id}")
//                        })
//                    }
//                }
//            }



        }
    }
}