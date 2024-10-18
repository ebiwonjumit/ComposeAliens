package com.evander.composealiens

import android.icu.text.IDNA.Info
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.XmlRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evander.composealiens.ui.theme.ComposeAliensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoltsWithInfo()
        }
    }
}

@Composable
fun AndroidAlien(color: Color, modifier: Modifier = Modifier ){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.baseline_bolt_24),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = ""
        //..
        )
}

@Composable
fun AndroidAliensColumn(){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
    }
}

@Composable
fun AndroidAliensRow(){
    Row (
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center,
    ){
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .weight(1F)
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Black,
            modifier = Modifier
                .weight(2F)
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .weight(1F)
                .size(70.dp)
                .padding(4.dp)
        )

    }
}

@Composable
fun GameOverBox(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        AndroidAliensRow()
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.Gray.copy(alpha = .7f))

        )
        Text("GAME OVER")
    }
}

@Composable
fun BoltsWithInfo(){
    Scaffold(
        topBar = {
            InfoHeader()
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .width(140.dp)
                    .height(70.dp)
                    .fillMaxWidth()
                    .background(color = Color.Cyan),
                onClick = {}
            ){
                Text("PRESS START")
            }
        }
    ){
        paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            BoltGrid(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            )
        }
    }
}

@Composable
fun InfoHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ){
        Text(
            text = "SCORE: 0050"
        )
        Text(
            text = "LIVES"
        )

    }
}

@Composable
fun BoltGrid(modifier: Modifier){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(5)
    ) {
        items(50){
            AndroidAlien(color = Color.DarkGray)
        }
    }
}



