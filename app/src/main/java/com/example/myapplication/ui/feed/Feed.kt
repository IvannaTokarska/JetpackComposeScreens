package com.example.myapplication.ui.feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R
import com.example.myapplication.model.Dog
import com.example.myapplication.ui.dog.DogCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Feed (
    dogs: List<Dog>,
    onSelected: (Dog) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        val listState = rememberLazyListState()
        LazyColumn(state = listState) {
            item {
                FeedHeader()
            }
            items(dogs) { dog ->
                DogCard(dog = dog, onClick = { onSelected(dog) })
            }
        }
    }
}


@Preview
@Composable
fun FeedPreview() {
    val dog = Dog(
        "1",
        R.drawable.dog_1,
        "Maggie",
        "Chow Chow",
        "Female",
        "11111"
    )
    MyApplicationTheme {
        Feed(dogs = listOf(dog), onSelected = {})
    }
}