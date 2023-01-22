package com.example.myapplication.ui.dog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Dog
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DogCard(
    dog: Dog,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val padding = 16.dp
    Row (
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(
                top = padding / 2,
                start = padding,
                end = padding,
                bottom = padding / 2
            )
            .fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = dog.image),
            contentDescription = "Image",
            modifier = Modifier
                .size(112.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Spacer(Modifier.size(padding))
        Column {
            Text(
                dog.name,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Medium)
            )
            Text(
                dog.breed,
                style = MaterialTheme.typography.body1
            )
            
        }
        Spacer(Modifier.size(padding))
    }

}

@Preview
@Composable
fun DogCardPreview() {
    val dog = Dog(
        "1",
        R.drawable.dog_1,
        "Maggie",
        "Chow Chow",
        "Female",
        "11111"
    )
    MyApplicationTheme {
        Surface {
            DogCard(dog, {})
        }
    }
}