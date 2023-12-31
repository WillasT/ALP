package com.example.alp.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alp.R
import com.example.alp.ui.theme.Poppins
import com.example.alp.ui.theme.buttonColor
import com.example.alp.ui.theme.cekboxcolor
import com.example.alp.ui.theme.forpassCol
import com.example.alp.ui.theme.line
import com.example.alp.ui.theme.linegoogle
import com.example.alp.ui.theme.loggoogletxt
import com.example.alp.ui.theme.textfilecol
import java.util.regex.Pattern

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isEmailValid by rememberSaveable { mutableStateOf(true) }
    var isPasswordValid by rememberSaveable { mutableStateOf(true) }


    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Hi, Welcome Back!\uD83D\uDC4B",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text(
                        text = "Username or email",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        color = Color(0xFF695C5C),
                        modifier = Modifier.padding(start = 36.dp, bottom = 6.dp)
                    )
                    CustomEmailField(
                        value = email,
                        onValueChanged = { email = it },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next


                        ),
                        text = "example@gmail.com",
                        isEmailValid = isEmailValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 36.dp)
                    )
                    Text(
                        text = "Password",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        color = Color(0xFF695C5C),
                        modifier = Modifier.padding(start = 36.dp, top = 16.dp, bottom = 6.dp)
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
                            .padding(horizontal = 36.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, top = 12.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val checkedState = remember { mutableStateOf(true) }

                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it },
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.White,
                            uncheckedColor = cekboxcolor,
                            checkedColor = buttonColor
                        )
                    )
                    Text(
                        text = "Remember Me",
                        fontFamily = Poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 6.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                text = "Forgot Password?",
                                fontFamily = Poppins,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = forpassCol
                            )
                        }

                    }
                }
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
                    enabled = email.isNotBlank() && password.isNotBlank()


                ) {
                    Text(
                        text = "Login",
                        fontFamily = Poppins,
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
                        fontFamily = Poppins,
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
                                text = "Login with Google",
                                color = loggoogletxt,
                                fontFamily = Poppins,
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
                        text = "Don't have an account?",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Sign Up",
                            color = buttonColor,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }

            }
        }
    )


}

@Composable
fun Lines() {
    Box(
        modifier = Modifier
            .width(width = 120.dp)
            .height(height = 1.dp)
            .background(color = line)
    )
}

// Function to validate email using regex
fun isValidEmail(email: String): Boolean {
    val emailPattern = Pattern.compile(
        "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",
        Pattern.CASE_INSENSITIVE
    )
    return emailPattern.matcher(email).matches()
}

// Function to validate password
fun isValidPassword(password: String): Boolean {
    val passwordPattern = Pattern.compile(
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%_^&+=])(?=\\S+\$).{8,}\$"
    )
    return passwordPattern.matcher(password).matches()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmailField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    isEmailValid: Boolean,
    modifier: Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = {
            Text(
                text = text,
                fontFamily = Poppins,
                fontSize = 16.sp,
                color = textfilecol
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = buttonColor,
        ),
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        isError = !isEmailValid
    )
    if (!isEmailValid) {
        Text(
            text = "Invalid Email Format",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            Color.Red
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomPasswordField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    isPasswordValid: Boolean,
    modifier: Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        placeholder = {
            Text(
                text = text,
                fontFamily = Poppins,
                fontSize = 16.sp,
                color = textfilecol
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = buttonColor,
        ),
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        isError = !isPasswordValid,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = { isPasswordVisible = !isPasswordVisible }
            ) {
                Icon(
                    imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
                )
            }
        },
    )
    if (!isPasswordValid) {
        Text(
            text = "Password must be 8 characters long and contain uppercase, lowercase, number, and special character",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            Color.Red,
            fontFamily = Poppins
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginView()
}