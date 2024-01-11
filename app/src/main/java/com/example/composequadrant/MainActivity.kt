package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import com.example.composequadrant.ui.theme.Color as boxColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column(Modifier.fillMaxWidth()) {
        QuadrantRow(loopInit = 0, loopEnd = 1,
            modifier = Modifier.weight(1F))
        QuadrantRow(loopInit = 2, loopEnd = 3,
            modifier = Modifier.weight(1F))
    }
}

@Composable
fun QuadrantRow(
    modifier: Modifier = Modifier, modifierCol: Modifier = Modifier, color: ArrayList<Color> = boxColor,
    title: Array<String> = stringArrayResource(id = R.array.title),
    description: Array<String> = stringArrayResource(id = R.array.description),
    loopInit: Int, loopEnd: Int
) {
    Row(modifier = modifier) {
        for (i in loopInit .. loopEnd) {
            Column(modifier = modifierCol
                .weight(1F)
                .fillMaxSize()
                .background(color[i])
                .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = title[i],
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold)

                Text(text = description[i], textAlign = TextAlign.Justify)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quadrant()
    }
}