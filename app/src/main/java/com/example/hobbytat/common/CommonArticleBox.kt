package com.example.hobbytat.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbytat.R

@Composable
fun CommonArticleBox(
    title: String,
    boardType: String,
    userName: String,
    viewCount: Int,
    likeCount: Int,
    commentCount: Int
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.main_blue),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                colorResource(id = R.color.main_blue_light),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(top = 16.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(
            text = title,
            color = colorResource(id = R.color.gray_700),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Icon(
                painter = painterResource(id = R.drawable.icon_document),
                contentDescription = "게시판 아이콘",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp),
                tint = colorResource(id = R.color.gray_400)
            )
            Text(text = boardType, color = colorResource(id = R.color.gray_700), fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Icon(
                painter = painterResource(id = R.drawable.icon_person),
                contentDescription = "유저 아이콘",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp),
                tint = colorResource(id = R.color.gray_400)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = userName, color = colorResource(id = R.color.gray_700), fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_eye),
                contentDescription = "눈 아이콘",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp),
                tint = colorResource(id = R.color.gray_700)
            )
            Text(
                text = likeCount.toString(),
                modifier = Modifier.padding(end = 12.dp),
                color = colorResource(id = R.color.gray_700),
                fontSize = 12.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_like),
                contentDescription = "좋아요 아이콘",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp),
                tint = colorResource(id = R.color.gray_700)
            )
            Text(
                text = likeCount.toString(),
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
                text = commentCount.toString(),
                color = colorResource(id = R.color.gray_700),
                fontSize = 12.sp
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CommonArticleBox(
        "파리 올림픽 같이 응원해요",
        "스포츠맨의 하비탯",
        "손흥민",
        12,
        12,
        12
    )
}