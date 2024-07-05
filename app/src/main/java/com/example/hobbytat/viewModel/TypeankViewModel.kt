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

data class ArticleRank(
    val articleId: Int,
    val articleTitle: String,
    val boardTitle: String,
    val memberName: String,
    val viewCount: Int,
    val replyCount: Int
)

data class ArticleRankResponse(
    val isSuccess: Boolean,
    val status: Int,
    val data: List<Article>,
    val size: Int
)


interface TypeRankService {
    @GET("rankings/types")
    suspend fun getTypeRankings(): TypeRankResponse

    @GET("rankings/articles")
    suspend fun getPostRankings(): ArticleRankResponse
}

class TypeRankViewModel: ViewModel() {
    private val _typeRanks = MutableLiveData<List<TypeRank>>()
    val typeRanks: LiveData<List<TypeRank>> = _typeRanks

    private val _articles = MutableLiveData<List<ArticleRank>>()
    val articles: LiveData<List<ArticleRank>> = _articles

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