package com.example.retrofitpractica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitpractica.ui.theme.RetrofitPracticaTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.model.Post
import com.example.retrofitpractica.viewmodel.PostViewModel
import androidx.compose.material3.MaterialTheme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitPracticaTheme {
                val viewModel: PostViewModel = viewModel()
                val posts by viewModel.posts.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        items(posts) { post ->
                            PostItem(post = post)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitPracticaTheme {
        Greeting("Android")
    }
}

@Composable
fun PostItem(post: Post) {
    androidx.compose.material3.Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = post.title, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
            Text(text = post.body, style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
        }
    }
}
