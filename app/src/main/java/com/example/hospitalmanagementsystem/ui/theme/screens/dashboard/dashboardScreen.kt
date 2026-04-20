package com.example.hospitalmanagementsystem.ui.theme.screens.dashboard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalmanagementsystem.data.AuthViewModel
import com.example.hospitalmanagementsystem.navigation.ROUTE_ADD_PATIENT
import com.example.hospitalmanagementsystem.navigation.ROUTE_PATIENT_LIST


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    Scaffold(
        topBar =  {
            TopAppBar(title = { Text(text = "EduAfya Hospital") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {authViewModel.logout(
                        navController = navController,
                        context = context)})
                    { Icon(
                        Icons.Default.ExitToApp,
                        contentDescription = "Logout",
                        tint = Color.White) }
                })}

    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(16.dp)){
            Text(text = "Welcome to EduAfya Hospital",
                fontSize = 22.sp,
                color = Color.Blue)

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Card(modifier = Modifier.size(100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Blue),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = RoundedCornerShape(12.dp)
                )  { Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "120", color = Color.White)
                    Text(text = "Patients", color = Color.White)
                }}
                Card(modifier = Modifier.size(100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF00897B)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = RoundedCornerShape(12.dp)
                )  { Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "45", color = Color.White)
                    Text(text = "Doctors", color = Color.White)
                }}
                Card(modifier = Modifier.size(100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF5E35B1)),
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = RoundedCornerShape(12.dp)
                )  { Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "30", color = Color.White)
                    Text(text = "Staff", color = Color.White)
                }}
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Add Patient Card
            Card(
                onClick = { navController.navigate(ROUTE_ADD_PATIENT) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                elevation = CardDefaults.cardElevation(6.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Add Patient",
                        tint = Color(0xFF1565C0),
                        modifier = Modifier.size(40.dp))
                    Column(modifier = Modifier.padding(start = 12.dp)) {
                        Text("Add Patient", fontSize = 18.sp, color = Color.Black)
                        Text("Register new patient details", fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }

            // View Patient Card
            Card(
                onClick = { navController.navigate(ROUTE_PATIENT_LIST) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                elevation = CardDefaults.cardElevation(6.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.List,
                        contentDescription = "View Patients",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(40.dp))
                    Column(modifier = Modifier.padding(start = 12.dp)) {
                        Text("View Patients", fontSize = 18.sp, color = Color.Black)
                        Text("See all registered patients", fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview(){
    DashboardScreen(rememberNavController())
}