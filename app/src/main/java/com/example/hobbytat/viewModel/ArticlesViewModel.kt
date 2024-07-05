package com.example.hobbytat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

data class Articles(
    val data: List<Article>,
    val size: Int
)

data class Article(
    val article_id: Int,
    val board_id: Int,
    val member_id: Int,
    val member_nickname: String,
    val title: String,
    val content: String,
    val img: String,
    val view_count: Int,
    val like_count: Int,
    val reply_count: Int,
    val replies: List<Reply>,
    val is_member_like: Boolean,
    val created_at: String,
    val modified_at: String
)


data class Reply(
    val reply_id: Int,
    val reply_member_id: Int,
    val reply_member_name: String,
    val reply_created_at: String,
    val reply_content: String
)

interface ArticleService {
    @GET("boards/{boardId}/articles")
    suspend fun getArticles(
        @Path("boardId") boardId: Int,
        @Query("article_id") articleId: Int? = null
    ): Articles

    @GET("/boards/{boardId}/articles/{articleId}")
    suspend fun getArticleById(
        @Path("boardId") boardId: Int,
        @Path("boardId") articleId: Int,
    ): Article
}

class ArticlesViewModel: ViewModel() {
    private val _articles = MutableLiveData<Articles>()
    val articles: LiveData<Articles> = _articles

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article

    val retrofit = RetrofitInstance.retrofit
    val articleService = retrofit.create(ArticleService::class.java)

    fun fetchArticles(boardId: Int, articleId: Int? = null) {
        viewModelScope.launch {
            try {
                val response = articleService.getArticles(boardId, articleId)
                _articles.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }

    fun fetchArticleById(boardId: Int, articleId: Int) {
        viewModelScope.launch {
            try {
                val response = articleService.getArticleById(boardId, articleId)
                _article.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }
}