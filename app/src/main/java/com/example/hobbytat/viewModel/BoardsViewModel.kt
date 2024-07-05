package com.example.hobbytat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class Boards(
    val data: List<Board>,
    val size: Int
)

data class Board(
    val board_id: Int,
    val title: String,
    val img: String
)

interface BoardService {
    @GET("/boards")
    suspend fun getBoards(): Boards
}

class BoardsViewModel : ViewModel() {
    private val _boards = MutableLiveData<Boards>()
    val boards: LiveData<Boards> = _boards

    val retrofit = RetrofitInstance.retrofit
    val boardService = retrofit.create(BoardService::class.java)

    fun fetchBoards() {
        viewModelScope.launch {
            try {
                val response = boardService.getBoards()
                _boards.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }
}