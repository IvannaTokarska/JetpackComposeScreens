package com.example.myapplication.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.R.drawable.telephone
import com.example.myapplication.model.Dog
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material.Divider as Divider

@Composable
fun Profile(
    dog: Dog,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val padding = 16.dp
    Column() {
        Image(
            painter = painterResource(id = dog.image),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(397.dp)
        )
        Spacer(Modifier.size(padding / 2))

        Column(
            modifier = modifier
                .padding(
                    top = padding / 2,
                    start = padding,
                    end = padding,
                    bottom = padding / 2
                )
                .weight(1f)
        ) {

            Text(
                dog.name,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(Modifier.size(padding / 2))

            Divider(modifier = Modifier.fillMaxWidth().width(5.dp))
            Spacer(Modifier.size(padding))

            Column() {
                Text(
                    text = "Breed",
                    style = MaterialTheme.typography.caption
                )
                Text(dog.breed)
            }
            Spacer(Modifier.size(padding / 2))

            Divider(modifier = Modifier.fillMaxWidth().width(5.dp))
            Spacer(Modifier.size(padding))

            Column() {
                Text(
                    text = "Sex",
                    style = MaterialTheme.typography.caption
                )
                Text(dog.sex)
            }
            Spacer(Modifier.size(padding / 2))

            Divider(modifier = Modifier.fillMaxWidth().width(5.dp))
            Spacer(Modifier.size(padding))

            Column() {
                Text(
                    text = "Personality",
                    style = MaterialTheme.typography.caption
                )
                Text(dog.personality)
            }
            Spacer(Modifier.size(padding))
        }

            Button(
                onClick = onClick,
                shape = CircleShape,
                modifier = Modifier.offset(250.dp, 0.dp)) {
                Row() {
                    Icon(
                        painter = painterResource(id = telephone),
                        contentDescription = "Telephone",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                    Text(text = "Adopt Me"
                    )
                }
            }
    }
}

@Preview
@Composable
fun ProfilePreview() {
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
            Profile(dog, {})
        }
    }
}