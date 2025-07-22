package com.example.retrofitpractica.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Post
import com.example.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPosts()
                if (response.isSuccessful) {
                    _posts.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                // Manejo de error simple
            }
        }
    }
}