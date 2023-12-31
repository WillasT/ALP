package com.example.alp.ui.view.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.R
import com.example.alp.ui.theme.Poppins
import com.example.alp.ui.theme.cardcolor1a
import com.example.alp.ui.theme.cardcolor1b
import com.example.alp.ui.theme.cardcolor2a
import com.example.alp.ui.theme.cardcolor2b
import com.example.alp.ui.theme.cardcolor3a
import com.example.alp.ui.theme.cardcolor3b
import com.example.alp.ui.view.NavBar
import com.example.alp.ui.view.split_bill.ActionBar
import com.example.alp.ui.view.split_bill.MainNavbar


@Composable
fun CardManagementView() {
    LazyColumn {
        item {
            NavBar(title = "All Cards")
        }
        item {
            Cards(
                painter = painterResource(id = R.drawable.visacard),
                color1 = cardcolor1a,
                color2 = cardcolor1b,
            )
        }
        item {
            Cards(
                painter = painterResource(id = R.drawable.masterbankkcard),
                color1 = cardcolor2a,
                color2 = cardcolor2b,
            )
        }
        item {
            Cards(
                painter = painterResource(id = R.drawable.paypalcard),
                color1 = cardcolor3a,
                color2 = cardcolor3b,
            )
        }
    }
}

@Composable
fun Cards(painter: Painter, color1: Color, color2: Color) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                color1, color2
                            )
                        )
                    )
            ) {
                Row(
                    modifier = Modifier.padding(start = 24.dp, top = 20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .padding(top = 1.dp)
                            .size(20.dp)

                    )
                    Text(
                        text = "Google Bank",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
                Text(
                    text = "**** **** **** 1690",
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 24.dp, top = 24.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, top = 4.dp, end = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Platinum Plus",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                    Text(
                        text = "Exp 01/22",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Ankara Mesii",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                    Image(
                        painter = painter,
                        contentDescription = "Logo",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }

}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CardManagementPreview() {
    CardManagementView()
}