package com.example.hospitalmanagementsystem.ui.theme.screens.patient

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.hospitalmanagementsystem.data.AuthViewModel
import com.example.hospitalmanagementsystem.data.PatientViewModel
import kotlin.contracts.contract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPatientScreen(navController: NavController){
    val patientViewModel: PatientViewModel = viewModel()
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dateOfVisit by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var illness by remember { mutableStateOf("") }
    val options = listOf("Male", "Female", "Other", "Prefer not to say")
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "AddPatient") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue,
                titleContentColor = Color.White
            ))
    }) {
            padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Box(modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center)
            {
                if (imageUri != null){
                    Image(painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop)
                }else {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
            Button(onClick = {launcher.launch("image/*")},
                modifier = Modifier.align (Alignment.CenterHorizontally))
            { Text(text = "Select Image")}

            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = { Text(text = "Patient's Name")},
                placeholder = {Text(text = "Enter Patient's Name")},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {expanded = !expanded}
            ) {
                OutlinedTextField(
                    value = gender,
                    onValueChange = {},
                    readOnly = true,
                    label = {Text("Patient's Gender")},
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false}
                ) {
                    options.forEach {selectionOption ->
                        DropdownMenuItem(
                            text = {Text(selectionOption)},
                            onClick = {
                                gender  =  selectionOption
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )

                    }
                }
            }


            OutlinedTextField(
                value = age,
                onValueChange = {age = it},
                label = { Text(text = "Patient's Age")},
                placeholder = {Text(text = "Enter Patient's Age")},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = phone,
                onValueChange = {phone = it},
                label = { Text(text = "Patient's Phone Number")},
                placeholder = {Text(text = "Enter Patient's Name")},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = illness,
                onValueChange = {illness = it},
                label = { Text(text = "Patient's Illness")},
                placeholder = {Text(text = "Enter Patient's Illness")},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = dateOfVisit,
                onValueChange = {dateOfVisit = it},
                label = { Text(text = "Date Of Visit")},
                placeholder = {Text(text = "Enter Date Of Visit")},
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.width(20.dp))
            Button (
                onClick = {
                    patientViewModel.uploadPatient(
                        imageUri,
                        name,
                        age,
                        phone,illness, context, navController)

                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )

            {Text(text = "Save Patient")}

        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddPatientScreenPreview(){
    AddPatientScreen(rememberNavController())
}