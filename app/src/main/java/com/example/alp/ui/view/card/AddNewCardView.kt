package com.example.alp.ui.view.card

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.R
import com.example.alp.ui.theme.Poppins
import com.example.alp.ui.theme.buttonColor
import com.example.alp.ui.view.CategoryDropdown
import com.example.alp.ui.view.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddNewCardView() {

    val snackbarHostState = remember { SnackbarHostState() }

    var cardholder_name by rememberSaveable { mutableStateOf("") }
    var card_number by rememberSaveable { mutableStateOf("") }
    var expiry by rememberSaveable { mutableStateOf("") }
    var cvv by rememberSaveable { mutableStateOf("") }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState())
                    ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = buttonColor,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Add New Card",
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(top = 12.dp, end = 48.dp)
                        )
                    }

                }
                Image(
                    painter = painterResource(id = R.drawable.addnewcardimg),
                    contentDescription = "Add New Card Image",
                    modifier = Modifier.size(280.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                ) {
                    Text(
                        text = "Cardholder Name",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, bottom = 6.dp)
                    )
                    CustomTextField(
                        value = cardholder_name,
                        onValueChanged = { cardholder_name = it },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next


                        ),
                        text = "John Doe",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp)
                    )
                    Text(
                        text = "Card Number",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, top = 16.dp, bottom = 6.dp)
                    )
                    CustomTextField(
                        value = card_number,
                        onValueChanged = { card_number = it },
                        text = "XXXX XXXX XXXX XXXX",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.NumberPassword,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp)
                    )
                    Text(
                        text = "Card Type",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, top = 16.dp, bottom = 6.dp)
                    )
                    CategoryDropdown()
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = "Expiry",
                                fontFamily = Poppins,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(
                                    start = 36.dp,
                                    top = 16.dp,
                                    bottom = 6.dp
                                )
                            )
                            Text(
                                text = "CVV",
                                fontFamily = Poppins,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(
                                    start = 124.dp,
                                    top = 16.dp,
                                    bottom = 6.dp
                                )
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {

                            CustomTextField(
                                value = expiry,
                                onValueChanged = { expiry = it },
                                text = "MM/YY",
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Next
                                ),
                                modifier = Modifier
                                    .padding(start = 36.dp)
                                    .width(154.dp)
                            )
                            CustomTextField(
                            value = cvv,
                            onValueChanged = { cvv = it },
                            text = "XXX",
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .width(154.dp)

                            )
                        }



                    }
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 28.dp, horizontal = 36.dp)
                            .height(45.dp)
                            .width(305.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(buttonColor),

                        ) {
                        Text(
                            text = "Add Card",
                            fontFamily = Poppins,
                            fontSize = 15.sp

                        )
                    }
                }
            }
        }
    )


}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AddNewCardPreview() {
    AddNewCardView()
}