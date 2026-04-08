package com.example.hospitalmanagementsystem.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalmanagementsystem.R
import com.example.hospitalmanagementsystem.data.AuthViewModel
import com.example.hospitalmanagementsystem.navigation.ROUTE_LOGIN

@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }
    val authViewModel: AuthViewModel= viewModel()
    val context = LocalContext.current




    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A237E), // Deep indigo
            Color(0xFF283593),
            Color(0xFF3949AB)
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = 28.dp, vertical = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hawi),
                    contentDescription = "logo",
                    modifier = Modifier.size(140.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                        .shadow(4.dp, CircleShape)
                )
                Text(
                    text = "Register Here", fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
                OutlinedTextField(
                    value = username,
                    label = { Text(text = "Enter Username") },
                    onValueChange = { username = it },
                    placeholder = { Text(text = "Please Enter Username") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }

                )
                OutlinedTextField(
                    value = email,
                    label = { Text(text = "Enter Your Email") },
                    onValueChange = { email = it },
                    placeholder = { Text(text = "Enter Email") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }

                )
                OutlinedTextField(
                    value = password,
                    label = { Text(text = "Enter Password") },
                    onValueChange = { password = it },
                    placeholder = { Text(text = "Please Enter Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) }

                )

                OutlinedTextField(
                    value = confirmpassword,
                    label = { Text(text = "Confirm Pasword") },
                    onValueChange = { confirmpassword = it },
                    placeholder = { Text(text = "") },
                    leadingIcon = { Icon(Icons.Default.Check, contentDescription = null) }
                )

                Button(onClick = {authViewModel.signup(
                    username =username,
                    email=email,
                    password=password,
                    confirmpassword=confirmpassword,
                    navController = navController,
                    context = context)}
                ) { Text(text = "Register")}
                Row() {
                    Text(text = "Already Registered?", color = Color.Blue, modifier = Modifier.clickable{navController.navigate(
                        ROUTE_LOGIN
                    )})
                    Text(text = "Login Here", color = Color.Red)
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())}
