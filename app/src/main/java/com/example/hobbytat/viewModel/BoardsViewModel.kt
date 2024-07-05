package com.example.hobbytat.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class Board(
    val boardId: Int,
    val title: String,
    val img: String
)

data class Boards(
    val isSuccess: Boolean,
    val status: Int,
    val data: List<Board>,
    val size: Int
)

interface BoardService {
    @GET("/boards")
    suspend fun getBoards(): Boards
}

class BoardsViewModel : ViewModel() {
//    private val _boards = MutableLiveData<Boards>()
//    val boards: LiveData<Boards> = _boards

    private val _boards = MutableLiveData<List<Board>>()
    val boards: LiveData<List<Board>> = _boards

//    val retrofit = RetrofitInstance.retrofit
//    val boardService = retrofit.create(BoardService::class.java)

    private val boardService = RetrofitInstance.retrofit.create(BoardService::class.java)

//    fun fetchBoards() {
//        viewModelScope.launch {
//            try {
//                val response = boardService.getBoards()
//                _boards.value = response
//            } catch (e: Exception) {
//                // 예외 처리
//            }
//        }
//    }

    fun fetchBoards() {
        viewModelScope.launch {
            try {
                val response = boardService.getBoards()

                if (response.isSuccess) {
                    _boards.value = response.data
                    Log.d("success", response.toString())
                } else {
                    // Handle API failure
//                    _boards.value = emptyList()
                    Log.d("fail1", response.toString())
                }
            } catch (e: Exception) {
                // Handle network error
                _boards.value = emptyList()
                Log.e("fetchBoards", "Network error: ${e.message}", e)
            }
        }
    }
}