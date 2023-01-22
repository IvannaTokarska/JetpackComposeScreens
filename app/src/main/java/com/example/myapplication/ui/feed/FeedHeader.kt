package com.example.myapplication.ui.feed

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun FeedHeader () {
    Surface(
        color = MaterialTheme.colors.onSurface,
        contentColor = MaterialTheme.colors.surface
    ) {
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "These are dogs",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp)
                    .fillMaxWidth()
                    .wrapContentSize()
            )
            Spacer(modifier = Modifier.size(16.dp))
    }

}

@Preview
@Composable
fun FeedHeaderPreview () {

    MyApplicationTheme() {
        FeedHeader()
    }
}