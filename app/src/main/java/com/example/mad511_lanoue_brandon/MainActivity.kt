package com.example.mad511_lanoue_brandon

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.mad511_lanoue_brandon.ui.theme.MAD511_Lanoue_BrandonTheme


data class Artist(
    val name: String,
    val genre: String,
    val yearFormed: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Main()
        }
    }
}

@Composable
fun Lab1Main()
{
    var name by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var yearFormed by remember { mutableStateOf("") }

    val artists = remember { mutableStateListOf<Artist>() }

    Column(Modifier.padding(16.dp)) {
        Text("Artist Name:")
        TextField(
            value = name,
            onValueChange = {name = it},
        )
        Text("Artist Genre:")
        TextField(
            value = genre,
            onValueChange = {genre = it},
        )
        Text("Year formed:")
        TextField(
            value = yearFormed,
            onValueChange = {yearFormed = it},
        )
        Button(
            onClick = {
                val year = yearFormed.toIntOrNull()

                if (year != null) {
                    artists.add(
                        Artist(
                            name = name,
                            genre = genre,
                            yearFormed = year
                        )
                    )
                }
                else
                {
                    artists.add(
                        Artist(
                            name = name,
                            genre = genre,
                            yearFormed = 9999
                        )
                    )
                }
            }
        ) {
            Text("Add")
        }
        LazyColumn{
            for (artist in artists) {
                item {
                    Row {
                        Text("Name: ${artist.name}")
                        Text("Genre: ${artist.genre}")
                        Text("Year: ${artist.yearFormed}")
                    }
                }
            }
        }
    }


}

