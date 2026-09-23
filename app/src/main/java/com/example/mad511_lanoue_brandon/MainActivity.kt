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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
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




}

@Preview(showBackground = true)
@Composable
fun ArtistFormPreview() {

    Artist(
        name = "Nirvana",
        genre = "Grunge",
        yearFormed = "1987",
        artists = emptyList(),
        onNameChange = {},
        onGenreChange = {},
        onYearChange = {},

    )
}

@Composable
fun Artist(
    name: String,
    genre: String,
    yearFormed: String,
    artists: List<Artist>,
    onNameChange: (String) -> Unit,
    onGenreChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
)
{
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = onNameChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Artist Name")
                }
            )

            OutlinedTextField(
                value = genre,
                onValueChange = onGenreChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Artist Genre")
                }
            )

            OutlinedTextField(
                value = yearFormed,
                onValueChange = onYearChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Year Formed")
                }
            )
        }
    }
}



