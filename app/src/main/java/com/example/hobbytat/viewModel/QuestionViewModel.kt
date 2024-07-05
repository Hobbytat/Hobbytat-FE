package com.example.hobbytat.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Question(val id: Int, val questionText: String, val answer1: String, val answer2: String)

class QuestionViewModel : ViewModel() {
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    private val _currentQuestionIndex = MutableLiveData<Int>()
    val currentQuestionIndex: LiveData<Int> = _currentQuestionIndex

    private val _answers = MutableLiveData<Map<Int, String>>()
    val answers: LiveData<Map<Int, String>> = _answers

    init {
        _questions.value = listOf(
            Question(1, "새로운 취미를\n시작할 때", "혼자", "친구와 함께"),
            Question(2, "주말에 시간을\n보낼 때", "집에서", "밖에서"),
            Question(3, "여가 시간을\n보낼 때", "보드게임, 퍼즐", "스포츠, 춤추기"),
            Question(4, "자유 시간을\n가질 때", "글쓰기, 그림", "퍼즐"),
            Question(5, "음악을\n들을 때", "혼자서 조용히", "친구들과 콘서트"),
            Question(6, "휴가를\n보낼 때", "요리, 베이킹", "캠핑, 낚시"),
            Question(7, "취미 활동을\n할 때", "뜨개질, 자수", "댄스 클래스"),
            Question(8, "창의적인 활동을\n할 때", "사진찍기, 영상편집", "체스, 전략게임"),
            Question(9, "조용한 시간을\n보낼 때", "명상, 요가", "동호회 활동"),
            Question(10, "새로운 것을\n배울 때", "요리", "자연 속 산책"),
            Question(11, "여가 시간을\n보낼 때", "독서, 영화감상", "춤, 운동"),
            Question(12, "복잡한 문제를\n해결할 때", "새로운방법 구상", "논리적 해결")
        )
        _answers.value = mutableMapOf()
    }

    fun saveAnswer(questionIndex: Int, answer: String) {
        _answers.value = _answers.value.orEmpty().toMutableMap().apply {
            put(questionIndex, answer)
        }
    }

    fun removeAnswer(questionIndex: Int) {
        _answers.value = _answers.value.orEmpty().toMutableMap().apply {
            remove(questionIndex)
        }
    }

    fun nextQuestion() {
        _currentQuestionIndex.value = (_currentQuestionIndex.value ?: 0) + 1
    }

    fun previousQuestion() {
        _currentQuestionIndex.value = (_currentQuestionIndex.value ?: 0) - 1
    }
}