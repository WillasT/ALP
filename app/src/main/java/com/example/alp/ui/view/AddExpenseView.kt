package com.example.alp.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import com.example.alp.ui.theme.textfilecol

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseView() {
    var expense_name by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavExpense()
                Image(
                    painter = painterResource(id = R.drawable.add_expense_image),
                    contentDescription = "Add Expense Image",
                    modifier = Modifier.size(200.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text(
                        text = "Expense Name",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, bottom = 6.dp)
                    )
                    CustomTextField(
                        value = expense_name,
                        onValueChanged = { expense_name = it },
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
                        text = "Price",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, top = 16.dp, bottom = 6.dp)
                    )
                    CustomTextField(
                        value = price,
                        onValueChanged = { price = it },
                        text = "Rp",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp)
                    )
                    Text(
                        text = "Category",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 36.dp, top = 16.dp, bottom = 6.dp)
                    )
                    CategoryDropdown()
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 28.dp, start = 36.dp, end = 36.dp)
                            .height(45.dp)
                            .width(305.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(buttonColor),

                        ) {
                        Text(
                            text = "Add",
//                    modifier = Modifier.padding(horizontal = 84.dp)
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
fun NavExpense() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
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
        Text(
            text = "Add Expense",
            fontFamily = Poppins,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 12.dp)
        )
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = buttonColor,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdown() {

    var isExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp)
        ) {
            OutlinedTextField(
                value = category,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    Text(
                        text = "Choose One",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        color = textfilecol
                    )
                },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(focusedBorderColor = buttonColor),
                modifier = Modifier.menuAnchor().fillMaxWidth().padding(end = 36.dp),
                shape = RoundedCornerShape(12.dp)
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.background(Color.White)
            ) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Category 1", fontFamily = Poppins,
                        )
                    },
                    onClick = {
                        category = "Category 1"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Category 2",
                            fontFamily = Poppins,
                        )
                    },
                    onClick = {
                        category = "Category 2"
                        isExpanded = false
                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = "Category 3", fontFamily = Poppins,
                        )
                    },
                    onClick = {
                        category = "Category 3"
                        isExpanded = false
                    },
                )
            }
        }
    }


}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AddExpensePreview() {
    AddExpenseView()
}