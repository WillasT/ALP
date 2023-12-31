package com.example.alp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.ui.theme.buttonColor
import com.example.alp.ui.theme.forpassCol
import com.example.alp.ui.theme.line

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetingView() {
    val scrollState = rememberScrollState()
    val popfamilybold = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold)
    )
    val popfamilyreg = FontFamily(
        Font(R.font.poppins_regular, FontWeight.Normal)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ){
//      Top Bar
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            Image(
                painter = painterResource(R.drawable.baseline_window_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
            Text(
                text = "Budgeting",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Image(
                painter = painterResource(R.drawable.baseline_notifications_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(160.dp)

            ){
//                Vector Data itu la
                Image(
                    painter = painterResource(R.drawable.baseline_notifications_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                )
            }
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ){
                    Image(
                        painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        text = "Transport",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ){
                    Image(
                        painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        text = "Bills",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                }
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ){
                    Image(
                        painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .padding(end = 12.dp)
                    )
                    Text(
                        text = "Food & Drink",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    // Left column
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Left to Spend",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        )
                        Text(
                            text = "Rp 500.000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }

                    // Right column
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(
                            text = "Monthly Budget",
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        )
                        Text(
                            text = "Rp 1.500.000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }
                }

                // Bottom bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .background(Color.Gray)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                    )
                    Text(
                        text = "Auto & Transport",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Auto & Transport",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Rp 300.000",
                        fontWeight = FontWeight.SemiBold  ,
                        fontSize = 16.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .height(4.dp)
                            .background(Color.Gray)
                    )
                    Text(
                        text = "Left Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal  ,
                        fontSize = 12.sp,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Auto Insurance",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Rp 200.000",
                        fontWeight = FontWeight.SemiBold  ,
                        fontSize = 16.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .height(4.dp)
                            .background(Color.Gray)
                    )
                    Text(
                        text = "Left Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal  ,
                        fontSize = 12.sp,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.baseline_notifications_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                    )
                    Text(
                        text = "Bill & Utilities",
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Auto & Transport",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Rp 300.000",
                        fontWeight = FontWeight.SemiBold  ,
                        fontSize = 16.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .height(4.dp)
                            .background(Color.Gray)
                    )
                    Text(
                        text = "Left Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal  ,
                        fontSize = 12.sp,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = "Auto Insurance",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                    )
                    Text(
                        text = "Rp 200.000",
                        fontWeight = FontWeight.SemiBold  ,
                        fontSize = 16.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .height(4.dp)
                            .background(Color.Gray)
                    )
                    Text(
                        text = "Left Rp 500.000",
                        color = Color.LightGray,
                        fontWeight = FontWeight.Normal  ,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BudgetingPreview() {
    BudgetingView()
}