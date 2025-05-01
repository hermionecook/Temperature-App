package com.example.temperatureapp

import ads_mobile_sdk.h2
import android.icu.util.ULocale
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.firebase.perf.util.Timer

//The main screen.
//Each visual component is it's own, separate composable function.
//Once you have made a component, you can call the function by writing the name of the
//function, followed by empty brackets.
//EG. TextBox()
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add task */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F9FA))
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            CategoryRow()
            Spacer(modifier = Modifier.height(24.dp))

            //Change Title of header
            Text("Title", style = MaterialTheme.typography.h6)

            //Adds a gap between Title and first card
            Spacer(modifier = Modifier.height(8.dp))
            CardList()

            Spacer(modifier = Modifier.height(8.dp))
            TextBox()
        }
    }
}

//Top bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        colors = Color.White,
        //Elevates top bar to make it stand out.
        elevation = 0.dp,
        //Title for the top of the top bar.
        title = {
            Text("Title", style = MaterialTheme.typography.h6)
        },
        //Account symbol at top of the screen
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
            }
        }
    )
}


@Composable
fun CategoryRow() {
    //List of titles for each card. Edit to add or remove any items to automatically
    //add or remove cards
    val categories = listOf("Title1")
    LazyRow {
        items(categories) { category ->
            Card(
                //Colour of the cards at top. NOTE: These are not buttons, just cards.
                backgroundColor = Color(0xFF219EBC),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(category, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CardList() {
    //Text within cards. Add new cards by adding a new line of text. THis is in the main body
    //of the app.
    val cards = listOf(
        "Information Text"
    )

    LazyColumn {
        //Adds a card for each item in the "ListOf"
        items(cards) { task ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                //Elevates card to make it stand out on screen.
                elevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        //Padding changes the size of the card. Higher DP = Bigger card.
                        //Fill max width is used to fill entire screen. Can be altered by changing to
                        //.width(insert DP here)
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    //The wrench icon on the card. Change the icon to any of the default icons available
                    //Colour can be changed by changing the hex code.
                    Icon(Icons.Default.Build, contentDescription = null, tint = Color(0xFF023047))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(task)


                }
            }



        }
    }
}

//Blue box in body
@Composable
fun TextBox() {
    Box(
        modifier = Modifier
            .width(500.dp)
            .height(300.dp), // Fill the screen
        contentAlignment = Alignment.Center // Center child content
    ) {
        //Box underneath the cards. Includes a text box for information.
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)

                //Background colour for the box
                .background(color = Color(0xFF219EBC))
        )
        //Text within the box. Change the text colour and what the text box says.
        Text("This is a text box!", color = Color.White)


    }
}


//Shows the preview of the home screen here. Everything within the "HomeScreen" function is
//displayed in here.
@Composable
@Preview()
fun HomeScreenPreview(){
    HomeScreen()
}