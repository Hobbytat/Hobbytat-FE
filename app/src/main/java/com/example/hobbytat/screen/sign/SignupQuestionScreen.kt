package com.example.hobbytat.screen.sign

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.hobbytat.R
import com.example.hobbytat.common.BlueButton
import com.example.hobbytat.common.signupTopBar
import com.example.hobbytat.viewModel.QuestionViewModel

@Composable
fun SignupQuestionScreen(navController: NavHostController) {
    val questionViewModel: QuestionViewModel = viewModel()
    val questions by questionViewModel.questions.observeAsState(emptyList())
    val currentQuestionIndex by questionViewModel.currentQuestionIndex.observeAsState(0)
    val answers by questionViewModel.answers.observeAsState(emptyMap())

    // 현재 선택된 답변을 추적하기 위한 상태 변수
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    // 현재 질문의 인덱스가 변경될 때마다 selectedAnswer를 업데이트
    LaunchedEffect(currentQuestionIndex) {
        selectedAnswer = answers[currentQuestionIndex]
    }

    // 모든 질문에 답변이 완료되었는지 확인하는 변수
    val isAllAnswered = questions.size == answers.keys.size

    val currentQuestion = questions.getOrNull(currentQuestionIndex)
    Scaffold(
        topBar = { signupTopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            currentQuestion?.let { question ->
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Question " + question.id)
                    Text(
                        text = question.questionText,
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 45.sp
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = if (currentQuestionIndex > 0) painterResource(id = R.drawable.ic_active_prev) else painterResource(
                                id = R.drawable.ic_unactive_prev
                            ),
                            contentDescription = "이전",
                            modifier = Modifier
                                .clickable(
                                    enabled = currentQuestionIndex > 0
                                ) {
                                    if (currentQuestionIndex > 0) {
                                        questionViewModel.previousQuestion()
                                    }
                                }
                                .size(30.dp)
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            BlueButton(
                                label = question.answer1,
                                corner = 10,
                                fontSize = 25,
                                height = 60,
                                color = if (selectedAnswer == question.answer1) R.color.main_blue_dark else R.color.main_blue
                            ) {
                                selectedAnswer = if (selectedAnswer == question.answer1) null else question.answer1
                                if (selectedAnswer == null) {
                                    questionViewModel.removeAnswer(currentQuestionIndex)
                                } else {
                                    questionViewModel.saveAnswer(currentQuestionIndex, selectedAnswer ?: "")
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            BlueButton(
                                label = question.answer2,
                                corner = 10,
                                fontSize = 25,
                                height = 60,
                                color = if (selectedAnswer == question.answer2) R.color.main_blue_dark else R.color.main_blue
                            ) {
                                selectedAnswer = if (selectedAnswer == question.answer2) null else question.answer2
                                if (selectedAnswer == null) {
                                    questionViewModel.removeAnswer(currentQuestionIndex)
                                } else {
                                    questionViewModel.saveAnswer(currentQuestionIndex, selectedAnswer ?: "")
                                }
                            }
                        }

                        Image(
                            painter = if (currentQuestionIndex < questions.size - 1) painterResource(id = R.drawable.ic_active_next) else painterResource(
                                id = R.drawable.ic_unactive_next
                            ),
                            contentDescription = "다음",
                            modifier = Modifier
                                .clickable(
                                    enabled = currentQuestionIndex < questions.size - 1
                                ) {
                                    if (currentQuestionIndex < questions.size - 1) {
                                        questionViewModel.nextQuestion()
                                    }
                                }
                                .size(30.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    // 모든 질문에 답변이 완료되었는지 확인 후 확인 버튼 추가
                    if (currentQuestionIndex == questions.size - 1) {
                        Button(
                            onClick = {
                                      // 확인 버튼 클릭 시 실행할 동작
                                      navController.navigate("Home")
                            },
                            enabled = isAllAnswered,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("확인")
                        }
                    }
                }
                // Text를 바닥에 고정
                Text(text = "${question.id}/12", modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}