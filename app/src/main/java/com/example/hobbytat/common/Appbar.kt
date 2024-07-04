package com.example.hobbytat.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hobbytat.R

@Composable
fun Appbar(
    selected:Int,
    navController: NavHostController
) {
    val imageSize: Dp = 20.dp
    val fontSize = 10.sp

    var homeImage = R.drawable.ic_home_black
    var homeColor = R.color.black
    var gameImage = R.drawable.ic_game_black
    var gameColor = R.color.black
    var boardImage = R.drawable.ic_board_black
    var boardColor = R.color.black
    var myPageImage = R.drawable.ic_my_black
    var myPageColor = R.color.black

    when (selected){
        1-> {
            homeImage = R.drawable.ic_home_blue
            homeColor = R.color.main_blue
        }
        2 -> {
            gameImage = R.drawable.ic_game_blue
            gameColor = R.color.main_blue
        }
        3 -> {
            boardImage = R.drawable.ic_board_blue
            boardColor = R.color.main_blue
        }
        4 -> {
            myPageImage = R.drawable.ic_my_blue
            myPageColor = R.color.main_blue
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ){
        Column {
            Divider(
                color = colorResource(id = R.color.gray_200)
            )

            Row(
                modifier = Modifier
                    .clickable{}
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(80.dp)
                //.padding(start = 10.dp, end = 10.dp)
                ,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                CreateTap(navController, "Home", homeImage, homeColor, imageSize, fontSize, "홈")
                CreateTap(navController, "Game", gameImage, gameColor, imageSize, fontSize, "밸런스 게임")
                CreateTap(navController, "Board", boardImage, boardColor, imageSize, fontSize, "게시판")
                CreateTap(navController, "MyPage", myPageImage, myPageColor, imageSize, fontSize, "MY")
            }
        }
    }
}

@Composable
fun CreateTap(navController: NavHostController, route:String, image:Int, textColor:Int, imageSize:Dp, fontSize: TextUnit, text:String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                navController.navigate(route)
            }
            .size(80.dp)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(imageSize)
        )
        Text(
            text = text,
            fontSize = fontSize,
            color = colorResource(id = textColor)
        )
    }
}