package com.example.alp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.ui.theme.background

@Composable
fun bgHome() {

    val popfamilybold = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold)
    )
    val popfamilyreg = FontFamily(
        Font(R.font.poppins_regular, FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backgroundhome),
                    contentDescription = "Content",
                    modifier = Modifier
                        .size(320.dp)
                        .background(background)

                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = 300.dp)
                    .rotate(20f)
                    .background(Color.White)
            ) {
                Text(text = "kjhfkjsfsf")
            }

        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun bgPreview() {
    bgHome()
}