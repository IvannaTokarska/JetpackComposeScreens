package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.model.DogsViewModel
import com.example.myapplication.ui.feed.Feed
import com.example.myapplication.ui.profile.Profile
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: DogsViewModel by viewModels()
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: DogsViewModel) {
    val state by viewModel.dogs.collectAsState()
    var selectedId by remember {
        mutableStateOf<String?>(null)
    }
    Crossfade(targetState = selectedId) { id ->
        if (id == null) {
            Feed(dogs = state, onSelected = { dog ->
                selectedId = dog.id
            })
        } else {
            Profile(dog = viewModel.getById(id), onClick = {})
            BackHandler() {
                selectedId = null
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting(DogsViewModel())
    }
}