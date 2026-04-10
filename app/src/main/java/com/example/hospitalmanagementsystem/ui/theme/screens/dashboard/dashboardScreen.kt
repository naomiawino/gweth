package com.example.hospitalmanagementsystem.ui.theme.screens.dashboard

import android.R
import android.R.attr.label
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalmanagementsystem.data.AuthViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController){
    val selectedItem = remember { mutableStateOf(0) }
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
               })},

        bottomBar = {
            NavigationBar(containerColor = Color.Blue){
                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = {selectedItem.value = 0},
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings")},
                    label = {Text(text = "settings")}

                )
            }
            NavigationBar(containerColor = Color.Blue){
                NavigationBarItem(
                    selected = selectedItem.value == 1,
                    onClick = {selectedItem.value = 1},
                    icon = { Icon(Icons.Filled.Email, contentDescription = "email")},
                    label = {Text(text = "Email")}

                )
            }
            NavigationBar(containerColor = Color.Blue){
                NavigationBarItem(
                    selected = selectedItem.value == 2,
                    onClick = {selectedItem.value = 2},
                    icon = { Icon(Icons.Filled.Person, contentDescription = "person")},
                    label = {Text(text = "person")}

                )
            }
        }

    )

    { innerPadding ->
       Column(modifier = Modifier.padding(innerPadding)){
           Text(text = "welcome to EduAfya Hospital",
               fontSize = 25.sp,
               color = Color.Blue)
           Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
               horizontalArrangement = Arrangement.SpaceEvenly) {
               Card(modifier = Modifier.size(100.dp),
                 colors = CardDefaults.cardColors(containerColor = Color.Blue),
                 elevation = CardDefaults.cardElevation(5.dp),
                 shape = RoundedCornerShape(12.dp)
               )  { Column(modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = "120",color = Color.White)
                   Text(text = "Patients",color = Color.White)

               }}
               Card(modifier = Modifier.size(100.dp),
                   colors = CardDefaults.cardColors(containerColor = Color.Blue),
                   elevation = CardDefaults.cardElevation(5.dp),
                   shape = RoundedCornerShape(12.dp)
               )  { Column(modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = "120",color = Color.White)
                   Text(text = "Patients",color = Color.White)

               }}
               Card(modifier = Modifier.size(100.dp),
                   colors = CardDefaults.cardColors(containerColor = Color.Blue),
                   elevation = CardDefaults.cardElevation(5.dp),
                   shape = RoundedCornerShape(12.dp)
               )  { Column(modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = "120",color = Color.White)
                   Text(text = "Patients",color = Color.White)

               }}
           }
           Card(
               onClick = {},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(vertical = 8.dp),
               colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
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
                       tint = Color(0xFF00D4A0), // fixed color
                       modifier = Modifier.size(40.dp))
                   Column {
                       Text("Add Patient", fontSize = 18.sp, color = Color.Black)
                       Text("Register new patient details", fontSize = 14.sp, color = Color.Gray)
                   }

               }

           }
           Row(
               modifier = Modifier.padding(16.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(
                   imageVector = Icons.Filled.Person,
                   contentDescription = "Add Patient",
                   tint = Color(0xFF00D4A0), // fixed color
                   modifier = Modifier.size(40.dp))
               Column {
                   Text("Add Patient", fontSize = 18.sp, color = Color.Black)
                   Text("Register new patient details", fontSize = 14.sp, color = Color.Gray)
               }

           }
           Row(
               modifier = Modifier.padding(16.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(
                   imageVector = Icons.Filled.Person,
                   contentDescription = "Add Patient",
                   tint = Color(0xFF00D4A0), // fixed color
                   modifier = Modifier.size(40.dp))
               Column {
                   Text("Add Patient", fontSize = 18.sp, color = Color.Black)
                   Text("Register new patient details", fontSize = 14.sp, color = Color.Gray)
               }

           }

           Row(
               modifier = Modifier.padding(16.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(
                   imageVector = Icons.Filled.Person,
                   contentDescription = "Add Patient",
                   tint = Color(0xFF00D4A0), // fixed color
                   modifier = Modifier.size(40.dp))
               Column {
                   Text("Add Patient", fontSize = 18.sp, color = Color.Black)
                   Text("Register new patient details", fontSize = 14.sp, color = Color.Gray)
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
