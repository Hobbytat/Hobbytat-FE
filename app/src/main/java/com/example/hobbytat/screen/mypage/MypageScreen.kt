package com.example.hobbytat.screen.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun MypageScreen(navController: NavHostController) {
    var userNickname by remember{
        mutableStateOf("건대컴공")
    }
    var userType by remember{
        mutableStateOf("예술적인 공예가")
    }
    var Mytype by remember{
        mutableStateOf(true)
    }
    var Mywrite by remember{
        mutableStateOf(false)
    }
    var Mycomment by remember{
        mutableStateOf(false)
    }
    var Mylike by remember{
        mutableStateOf(false)
    }
    var userTypeExplain by remember{
        mutableStateOf("예술적인 공예가는 예술적이고 어쩌고")
    }

    Scaffold(
        topBar = {
            CommonTopBar(navController)
        },
        bottomBar = {
            Appbar(selected = 4, navController = navController)
        }){paddingValues ->
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues)
        ) {
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sample_profile),
                            contentDescription = "샘플 프로필",
                            modifier = Modifier
                                .size(56.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = userNickname, fontSize = 16.sp)
                            Text(text = userType, fontSize = 12.sp, color = colorResource(id = R.color.gray_500))
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_kebab),
                        contentDescription = "더보기"
                    )
                }

                Box(
                    modifier = Modifier.height(50.dp)
                ){
                    Divider(
                        color = colorResource(id = R.color.gray_100),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .height(1.dp)
                    )

                    Row{
                        Column(
                            modifier = Modifier
                                .size(90.dp, 50.dp)
                                .clickable {
                                    // 내 유형 클릭
                                    Mytype = true
                                    Mywrite = false
                                    Mycomment = false
                                    Mylike = false
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "내 유형",
                                fontSize = 14.sp,
                                color = if(Mytype) colorResource(id = R.color.black) else colorResource(
                                    id = R.color.gray_500
                                )
                            )

                            if(Mytype){
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .width(90.dp)
                                        .height(2.dp)
                                        .offset(y = 13.dp)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .size(90.dp, 50.dp)
                                .clickable {
                                    // 내 유형 클릭
                                    Mytype = false
                                    Mywrite = true
                                    Mycomment = false
                                    Mylike = false
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "작성글",
                                fontSize = 14.sp,
                                color = if(Mywrite) colorResource(id = R.color.black) else colorResource(
                                    id = R.color.gray_500
                                )
                            )

                            if(Mywrite){
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .width(90.dp)
                                        .height(2.dp)
                                        .offset(y = 13.dp)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .size(90.dp, 50.dp)
                                .clickable {
                                    // 내 유형 클릭
                                    Mytype = false
                                    Mywrite = false
                                    Mycomment = true
                                    Mylike = false
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "댓글",
                                fontSize = 14.sp,
                                color = if(Mycomment) colorResource(id = R.color.black) else colorResource(
                                    id = R.color.gray_500
                                )
                            )

                            if(Mycomment){
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .width(90.dp)
                                        .height(2.dp)
                                        .offset(y = 13.dp)
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .size(90.dp, 50.dp)
                                .clickable {
                                    // 내 유형 클릭
                                    Mytype = false
                                    Mywrite = false
                                    Mycomment = false
                                    Mylike = true
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "좋아요",
                                fontSize = 14.sp,
                                color = if(Mylike) colorResource(id = R.color.black) else colorResource(
                                    id = R.color.gray_500
                                )
                            )

                            if(Mylike){
                                Divider(
                                    color = Color.Black,
                                    modifier = Modifier
                                        .width(90.dp)
                                        .height(2.dp)
                                        .offset(y = 13.dp)
                                )
                            }
                        }
                    }
                }
                if(Mytype){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.character_craftsman),
                            contentDescription = "user 유형 이미지",
                            modifier = Modifier.size(200.dp)
                        )
                        Text(
                            text = "당신은 "+ userType+" 유형입니다",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = userTypeExplain,
                            fontSize = 16.sp
                        )
                    }
                }
                else if(Mywrite){
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
//                        itemsIndexed(){
//                            CommonArticleBox(
//                                "파리 올림픽 같이 응원해요",
//                                "스포츠맨의 하비탯",
//                                "손흥민",
//                                12,
//                                12,
//                                12,
//                                order = 1
//                            ) {
//                                navController.navigate("Article/1/1")
//                            }
//                        }
                    }
                }
                else if(Mycomment){

                }
                else if(Mylike){

                }
            }
        }
    }
}