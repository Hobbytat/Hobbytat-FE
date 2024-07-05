package com.example.hobbytat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class TypeRank(
    val hobbyType: String,
    val rank: Int,
    val percent: Int
)

data class TypeRankResponse(
    val data: List<TypeRank>,
    val size: Int
)


interface TypeRankService {
    @GET("rankings/types")
    suspend fun getTypeRankings(): TypeRankResponse
}

class TypeRankViewModel: ViewModel() {
    private val _typeRanks = MutableLiveData<List<TypeRank>>()
    val typeRanks: LiveData<List<TypeRank>> = _typeRanks

    val retrofit = RetrofitInstance.retrofit
    val typeRankService = retrofit.create(TypeRankService::class.java)

    fun fetchTypeRanks() {
        viewModelScope.launch {
            try {
                val response = typeRankService.getTypeRankings()
                _typeRanks.value = response.data
            } catch (e: Exception) {
                // 예외 처리
                _typeRanks.value = emptyList() // 예외 발생 시 빈 리스트를 설정
            }
        }
    }
}