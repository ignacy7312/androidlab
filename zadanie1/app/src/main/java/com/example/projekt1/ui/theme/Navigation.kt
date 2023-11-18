package com.example.projekt1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projekt1.R
import com.example.projekt1.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.SecondScreen.route + "?name={name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "ktokolwiek"
                    nullable = true
                }
            )
        ) { entry ->
            SecondScreen(name = entry.arguments?.getString("name"), navController = navController)
        }
        composable(route = Screen.ThirdScreen.route) {
            ThirdScreen(navController = navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .background(Color.Yellow)
    ){
        TextField(value = text, onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
                         navController.navigate(Screen.SecondScreen.route + "$text")
        }, modifier = Modifier.align(Alignment.End)){
            Text(text = "do drugiego ekranu")
    }
        Image(
            painterResource(R.drawable.img),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun SecondScreen(name: String?, navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)
        , contentAlignment = Alignment.Center){
        Text(text = "witam na drugim ekranie, $name")
    }
Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 50.dp)
        .background(Color.Green)){}
    Button(onClick = {
        navController.navigate(Screen.ThirdScreen.route)
    }){
        Text(text = "do trzeciego ekranu")
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center){
        Text(text = "to jest trzeci ekran")
    }
    Button(onClick = {
        navController.navigate(Screen.MainScreen.route)
    }){
        Text(text = "do pierwszego ekranu")
    }
}
