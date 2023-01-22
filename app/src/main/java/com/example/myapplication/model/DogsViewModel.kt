package com.example.myapplication.model

import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DogsViewModel : ViewModel() {
    val dogs = MutableStateFlow<List<Dog>>(emptyList())

    fun getById(id: String) = dogs.value.first { dog -> dog.id == id }

    init {
        dogs.update {
            mutableListOf(
                Dog(
                    "1",
                    R.drawable.dog_1,
                    "Maggie",
                    "Chow Chow",
                    "Female",
                    "Fearless Maggie is always confident."
                ),
                Dog(
                    "2",
                    R.drawable.dog_2,
                    "Charlie",
                    "Dalmatian",
                    "Male",
                    "Charlie is very sociable with everyone."
                ),
                Dog(
                    "3",
                    R.drawable.dog_3,
                    "Luna",
                    "Yakutian Laika",
                    "Female",
                    "Luna is always curious about everything, so she likes to explore the world."
                ),
                Dog(
                    "4",
                    R.drawable.dog_4,
                    "Dolly",
                    "Pomeranian",
                    "Female",
                    "Dolly's favorite activity is to eat well."
                ),
                Dog(
                    "5",
                    R.drawable.dog_5,
                    "Gigi",
                    "Poodle",
                    "Female",
                    "Gigi has many awards from dog beauty pageants."
                ),
                Dog(
                    "6",
                    R.drawable.dog_6,
                    "Kobe",
                    "Siberian Husky",
                    "Male",
                    "Kobe is a very playful dog, he also likes to walk outside."
                ),
                Dog (

                    "7",
                    R.drawable.dog_7,
                    "Chip",
                    "Chupacabra",
                    "Male",
                    "Chip's favorite game is \"whoever blinks first loses\"."
                )
            )
        }
    }
}