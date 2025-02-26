package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Blue) { innerPadding ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        BusinessCard(
                            name = "Thomas Testa",
                            email = "thomas.testa@cix.csi.cuny.edu",
                            occupation = "Software Engineer",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, email: String, occupation: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.t)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(BorderStroke(2.dp, Color.White), RoundedCornerShape(32.dp))
            .padding(20.dp)

    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color.White),
        )
        Text(
            text = name,
            color = Color.White
        )
        Text(
            text = occupation,
            color = Color.White
        )
        Text(
            text = email,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard("Thomas Testa", "thomas.testa@cix.csi.cuny.edu", "Software Engineer")
    }
}