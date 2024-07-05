package com.example.hobbytat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hobbytat.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Path

data class MyProfile(
    val member_id: Int,
    val username: String,
    val password: String,
    val nickname: String,
    val profile_img: String,
    val hobby_type: String,
    val created_at: String,
    val modified_at: String
)

data class Profile(
    val member_id: Int,
    val nickname: String,
    val profile_img: String,
    val hobby_type: String
)

interface UserService {
    @GET("")
    suspend fun getMyProfile(): MyProfile

    @GET("")
    suspend fun getProfile(@Path("member_id") memberId: Int): Profile
}

class UserViewModel : ViewModel() {
    private val _myProfile = MutableLiveData<MyProfile>()
    val myProfile: LiveData<MyProfile> = _myProfile

    private val _profile = MutableLiveData<Profile>()
    val profile: LiveData<Profile> = _profile

    val retrofit = RetrofitInstance.retrofit
    val userService = retrofit.create(UserService::class.java)

    fun fetchMyProfile() {
        viewModelScope.launch {
            try {
                val response = userService.getMyProfile()
                _myProfile.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }

    fun fetchProfile(memberId: Int) {
        viewModelScope.launch {
            try {
                val response = userService.getProfile(memberId)
                _profile.value = response
            } catch (e: Exception) {
                // 예외 처리
            }
        }
    }
}