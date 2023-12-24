package com.example.alp.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.R
import com.example.alp.ui.theme.buttonColor
import com.example.alp.ui.theme.linegoogle
import com.example.alp.ui.theme.loggoogletxt
import com.example.alp.ui.theme.textfilecol

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView() {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phone_number by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isEmailValid by rememberSaveable { mutableStateOf(true) }
    var isPasswordValid by rememberSaveable { mutableStateOf(true) }

    val popfamilybold = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold)
    )
    val popfamilyreg = FontFamily(
        Font(R.font.poppins_regular, FontWeight.Normal)
    )

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Create an Account",
                    fontFamily = popfamilybold,
                    fontSize = 24.sp
                )
                Text(
                    text = "Manage your financial today!",
                    fontFamily = popfamilyreg,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    CustomTextField(
                        value = username,
                        onValueChanged = { username = it },
                        text = "Enter Your Username",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp, vertical = 12.dp)
                    )

                    CustomEmailField(
                        value = email,
                        onValueChanged = { email = it },
                        text = "Enter Your Email",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        isEmailValid = isEmailValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 36.dp, top = 12.dp)
                    )

                    CustomTextField(
                        value = phone_number,
                        onValueChanged = { phone_number = it },
                        text = "Enter Your Phone Number",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 36.dp, top = 24.dp, bottom = 12.dp)
                    )

                    CustomPasswordField(
                        value = password,
                        onValueChanged = { password = it },
                        text = "Enter Your Password",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        isPasswordValid = isPasswordValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 36.dp, top = 12.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(12.dp))

                Button(
                    onClick = {
                        isEmailValid = isValidEmail(email)
                        isPasswordValid = isValidPassword(password)
                    },
                    colors = ButtonDefaults.buttonColors(buttonColor),
                    modifier = Modifier
                        .width(312.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(6.dp),

                    ) {
                    Text(
                        text = "Sign Up",
                        fontFamily = popfamilyreg,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp, top = 36.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Lines()
                    Text(
                        text = "Or With",
                        fontFamily = popfamilyreg,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Lines()

                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    border = BorderStroke(1.dp, linegoogle),
                    modifier = Modifier
                        .width(312.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(10.dp)

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google_logo),
                                contentDescription = "Google Logo",
                                modifier = Modifier
//                            .padding(end = 48.dp)
                                    .size(24.dp)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Sign Up with Google",
                                color = loggoogletxt,
                                fontFamily = popfamilyreg,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }

                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 48.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account?",
                        fontFamily = popfamilyreg,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Login",
                            color = buttonColor,
                            fontFamily = popfamilybold,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = {
            Text(
                text = text,
//                        fontFamily = popfamilyreg,
                fontSize = 16.sp,
                color = textfilecol
            )

        },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview() {
    RegisterView()
}