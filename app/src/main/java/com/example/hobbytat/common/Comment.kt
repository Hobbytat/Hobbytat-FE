package com.example.hobbytat.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbytat.R

@Composable
fun Comment(
//    profileImg: String,
    replyMemberName: String,
    replyCreatedAt: String,
    replyContent: String
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample_profile),
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
                    text = replyMemberName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = replyCreatedAt,
                    fontSize = 10.sp,
                    color = colorResource(id = R.color.gray_400)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = replyContent,
                    fontSize = 12.sp
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_kebab),
            contentDescription = "케밥버튼",
            modifier = Modifier.size(16.dp)
        )
    }

    Divider(color = colorResource(id = R.color.gray_100))
}