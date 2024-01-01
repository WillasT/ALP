package com.example.alp.ui.view

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.alp.R
import com.example.alp.ui.theme.Poppins
import com.example.alp.ui.theme.backbills
import com.example.alp.ui.theme.backfooddrink
import com.example.alp.ui.theme.backtrans
import com.example.alp.ui.theme.cardcolor2a
import com.example.alp.ui.theme.cardcolor2b
import com.example.alp.ui.theme.cekboxcolor
import com.example.alp.ui.theme.linegoogle
import com.example.alp.ui.theme.piechartbills
import com.example.alp.ui.theme.piechartfooddrink
import com.example.alp.ui.theme.piecharttrans
import com.example.alp.ui.view.card.Cards

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetingView() {
    LazyColumn {
        item {
            BudgetingMenu()
        }
    }
}


@Composable
fun BudgetingMenu() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        NavBar(title = "Budgeting")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
//                Vector Data itu la
//                ini yang asli cuma bingumg implementasinya
                PieChart(
                    data = mapOf(
                        Pair("Transportation", 240),
                        Pair("Bills", 80),
                        Pair("Food & Drink", 90)
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 48.dp)
            ) {
                BudgetIcons(
                    backcolor = backtrans,
                    imageVector = Icons.Default.DirectionsCar,
                    iconname = "Transport Icon",
                    iconcolor = piecharttrans,
                    icontitle = "Transport",
                    fontSize = 13.sp,
                    fontColor = linegoogle
                )
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                BudgetIcons(
                    backcolor = backbills,
                    imageVector = Icons.Default.Receipt,
                    iconname = "Bills Icon",
                    iconcolor = piechartbills,
                    icontitle = "Bills",
                    fontSize = 13.sp,
                    fontColor = linegoogle
                )
                Spacer(modifier = Modifier.padding(vertical = 6.dp))
                BudgetIcons(
                    backcolor = backfooddrink,
                    imageVector = Icons.Default.Restaurant,
                    iconname = "Food & Drink Icon",
                    iconcolor = piechartfooddrink,
                    icontitle = "Food & Drink",
                    fontSize = 13.sp,
                    fontColor = linegoogle
                )
            }
        }
        SpendCard()
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(2.dp, shape = RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),

            ) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                ExpensesCard(
                    backcolor = backtrans,
                    imageVector = Icons.Default.DirectionsCar,
                    iconname = "Transport Icon",
                    iconcolor = piecharttrans,
                    icontitle = "Auto & Transport",
                    fontSize = 15.sp,
                    fontColor = Color.Black,
                    totalExpenses = "Rp 500.000",
                )
                DetailsExpensesCard(
                    detailsTitle = "Auto & Transport",
                    detailsExpenses = "Rp 300.000",
                    detailsRemainder = "Left Rp 123.345",
                    color = piecharttrans,
                    newProgress = 0.7f
                )
                Spacer(modifier = Modifier.height(6.dp))
                DetailsExpensesCard(
                    detailsTitle = "Auto Insurance",
                    detailsExpenses = "Rp 200.000",
                    detailsRemainder = "Left Rp 134.290",
                    color = piecharttrans,
                    newProgress = 0.3f
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(2.dp, shape = RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),

            ) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {

                ExpensesCard(
                    backcolor = backbills,
                    imageVector = Icons.Default.Receipt,
                    iconname = "Bills Icon",
                    iconcolor = piechartbills,
                    icontitle = "Bill & Utility",
                    fontSize = 15.sp,
                    fontColor = Color.Black,
                    totalExpenses = "Rp 320.000",
                )
                DetailsExpensesCard(
                    detailsTitle = "Subscription",
                    detailsExpenses = "Rp 120.000",
                    detailsRemainder = "Left Rp 90.120",
                    color = piechartbills,
                    newProgress = 0.1f
                )
                Spacer(modifier = Modifier.height(6.dp))
                DetailsExpensesCard(
                    detailsTitle = "Maintenance",
                    detailsExpenses = "Rp 100.000",
                    detailsRemainder = "Left Rp 56.345",
                    color = piechartbills,
                    newProgress = 0.9f
                )
                Spacer(modifier = Modifier.height(6.dp))
                DetailsExpensesCard(
                    detailsTitle = "House Service",
                    detailsExpenses = "Rp 100.000",
                    detailsRemainder = "Left Rp 67.123",
                    color = piechartbills,
                    newProgress = 0.6f
                )
            }
        }
    }
}


@Composable
fun NavBar(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_window_24),
                contentDescription = "Home",
                modifier = Modifier
                    .size(30.dp)
            )
        }

        Text(
            text = title,
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
        )

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_notifications_24),
                contentDescription = "Notifications",
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}


@Composable
fun SpendCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(2.dp, shape = RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),

        ) {
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
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
                        color = linegoogle,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Rp 500.000",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
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
                        color = linegoogle,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "Rp 1.500.000",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                }
            }

            // Bottom bar
            CustomSpendProgressBar()
        }
    }
}


@Composable
fun ExpensesCard(
    backcolor: Color,
    imageVector: ImageVector,
    iconname: String,
    iconcolor: Color,
    icontitle: String,
    fontSize: TextUnit,
    fontColor: Color,
    totalExpenses: String,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        BudgetIcons(
            backcolor = backcolor,
            imageVector = imageVector,
            iconname = iconname,
            iconcolor = iconcolor,
            icontitle = icontitle,
            fontSize = fontSize,
            fontColor = fontColor
        )
        Text(
            text = totalExpenses,
            fontFamily = Poppins,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DetailsExpensesCard(
    detailsTitle: String,
    detailsExpenses: String,
    detailsRemainder: String,
    color: Color,
    newProgress: Float
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Text(
            text = detailsTitle,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            text = detailsExpenses,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )

    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CustomProgressBar(
            color = color,
            newProgress = newProgress
        )
        Text(
            text = detailsRemainder,
            fontFamily = Poppins,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}


@Composable
fun BudgetIcons(
    backcolor: Color,
    imageVector: ImageVector,
    iconname: String,
    iconcolor: Color,
    icontitle: String,
    fontSize: TextUnit,
    fontColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .background(backcolor, shape = RoundedCornerShape(14.dp))
                .padding(8.dp)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = iconname,
                tint = iconcolor
            )
        }

        Text(
            text = icontitle,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = fontSize,
            color = fontColor,
            modifier = Modifier.padding(start = 10.dp, top = 4.dp)
        )
    }
}

@Composable
fun PieChart(
    data: Map<String, Int>,
    radiusOuter: Dp = 90.dp,
    chartBaeWidth: Dp = 20.dp,
    animDuration: Int = 1000,
) {

    val totalSum = data.values.sum()
    val floatValue = mutableListOf<Float>()

    data.values.forEachIndexed { index, values ->
        floatValue.add(index, 360 * values.toFloat() / totalSum.toFloat())
    }

    val colors = listOf(
        piecharttrans,
        piechartbills,
        piechartfooddrink
    )

    var animationPlayed by remember { mutableStateOf(false) }
    var lastValue = 0f

    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) {
            radiusOuter.value * 1f
        } else {
            0f
        },
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) {
            90f * 11f
        } else {
            0f
        },
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(animateSize.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .size(radiusOuter * 2f)
                    .rotate(animateRotation)
            ) {
                floatValue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index],
                        lastValue,
                        value, useCenter = false,
                        style = Stroke(chartBaeWidth.toPx(), cap = StrokeCap.Butt)
                    )
                    lastValue += value
                }
            }
        }

//        DetailsPieChart(
//            data = data,
//            colors = colors
//        )
    }
}

//@Composable
//fun DetailsPieChart(
//    data: Map<String, Int>,
//    colors: List<Color>
//) {
//    Column(
//        modifier = Modifier
//            .padding(top = 60.dp)
//            .fillMaxWidth()
//    ) {
//        data.values.forEachIndexed { index, value ->
//            DetailsPieChartItem(
//                data = Pair(data.keys.elementAt(index), value),
//                color = colors[index]
//            )
//        }
//    }
//}

//@Composable
//fun DetailsPieChartItem(
//    data: Pair<String, Int>,
//    height: Dp = 45.dp,
//    color: Color
//) {
//    Surface(
//        modifier = Modifier
//            .padding(vertical = 10.dp, horizontal = 30.dp),
//        color = Color.Transparent
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .background(
//                        color = color,
//                        shape = RoundedCornerShape(10.dp)
//                    )
//                    .size(height)
//            )
//
//            Column(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(
//                    text = data.first,
//                    fontFamily = Poppins,
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 22.sp,
//                    modifier = Modifier.padding(start = 15.dp)
//                )
//                Text(
//                    text = data.first,
//                    fontFamily = Poppins,
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 22.sp,
//                    modifier = Modifier.padding(start = 15.dp),
//                    color = Color.Gray
//                )
//            }
//        }
//    }
//}

@Composable
fun CustomProgressBar(color: Color, newProgress: Float) {
    var progress by remember {
        mutableStateOf(0f)
    }
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .padding(top = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .height(6.dp)
                .width(160.dp)
        ) {
            //background progress bar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(cekboxcolor)
            )
            //progress progress bar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(color)
                    .animateContentSize()
            )
        }
    }
    LaunchedEffect(key1 = true) {
        progress = newProgress
    }
}

@Composable
fun CustomSpendProgressBar() {
    var progress1 by remember {
        mutableStateOf(0f)
    }
    var progress2 by remember {
        mutableStateOf(0f)
    }
    var progress3 by remember {
        mutableStateOf(0f)
    }
    val size1 by animateFloatAsState(
        targetValue = progress1,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    val size2 by animateFloatAsState(
        targetValue = progress2,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    val size3 by animateFloatAsState(
        targetValue = progress3,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .padding(top = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .height(12.dp)
                .fillMaxWidth()
        ) {
            //background progress bar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(cekboxcolor)
            )
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size1)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(9.dp, 0.dp, 0.dp, 9.dp))
                        .background(piechartbills)
                        .animateContentSize()
                        .zIndex(0f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size2)
                        .fillMaxHeight()
                        .zIndex(1f)
                        .background(piechartfooddrink)
                        .animateContentSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size3)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(0.dp, 9.dp, 9.dp, 0.dp))
                        .background(piecharttrans)
                        .animateContentSize()
                        .zIndex(0f)
                )
            }
        }
    }
    LaunchedEffect(key1 = true) {
        progress1 = 0.2f
    }
    LaunchedEffect(key1 = true) {
        progress2 = 0.3f
    }
    LaunchedEffect(key1 = true) {
        progress3 = 0.6f
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BudgetingPreview() {
    BudgetingView()
}