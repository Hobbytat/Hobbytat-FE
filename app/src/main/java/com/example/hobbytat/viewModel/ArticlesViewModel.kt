package com.example.hobbytat.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

data class Articles(
    val data: List<Article>,
    val size: Int
)

data class Article(
    val articleId: Int,
    val boardId: Int,
    val memberId: Int,
    val memberNickname: String,
    val title: String,
    val content: String,
    val img: String,
    val viewCount: Int,
    val likeCount: Int,
    val replyCount: Int,
    val replies: List<Reply>,
    val isMemberLike: Boolean,
    val createdAt: String,
    val modifiedAt: String
)

data class Reply(
    val replyId: Int,
    val replyMemberId: Int,
    val replyMemberName: String,
    val replyCreatedAt: String,
    val replyContent: String
)

data class PostArticleRequest(
    val title: String,
    val content: String,
    val img: String
)

data class PostArticleResponse(
    val isSuccess: Boolean,
    val status: Int,
    val articleId: Int,
    val boardId: Int,
    val memberId: Int,
    val title: String,
    val content: String,
    val img: String,
    val createdAt: String
)


interface ArticleService {
    @GET("/boards/{boardId}/articles?article_id={articleId}")
    suspend fun getArticles(
        @Path("boardId") boardId: Int,
        @Query("articleId") articleId: Int? = null
    ): Articles

    @GET("/boards/{boardId}/articles/{articleId}")
    suspend fun getArticleById(
        @Path("boardId") boardId: Int,
        @Query("articleId") articleId: Int
    ): Article

    @POST("/boards/{boardId}/articles")
    suspend fun postArticle(
        @Path("boardId") boardId: Int,
        @Body request: PostArticleRequest
    ): PostArticleResponse
}

class ArticlesViewModel : ViewModel() {
    private val _articles = MutableLiveData<Articles>()
    val articles: LiveData<Articles> = _articles

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article

    private val _postArticleResponse = MutableLiveData<PostArticleResponse>()
    val postArticleResponse: LiveData<PostArticleResponse> = _postArticleResponse


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
                Log.d("asdf", response.toString())
                _article.value = response
            } catch (e: Exception) {
                // 예외 처리
                Log.d("asdf", "asdfasdfadsf")
            }
        }
    }

    fun postArticle(boardId: Int, title: String, content: String, img: String) {
        viewModelScope.launch {
            try {
                val request = PostArticleRequest(title, content, img)
                val response = articleService.postArticle(boardId, request)
                _postArticleResponse.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }
}