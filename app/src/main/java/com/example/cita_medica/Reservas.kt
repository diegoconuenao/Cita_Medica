package com.example.cita_medica

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Reservas(navController: NavController){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = "Ingresa datos requeridos para realizar reserva")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it

        }, label = {
            Text(text = "Ingrese Email")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "Contraseña")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("Reservas")
        }) {
            Text(text = "Acceder")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "¿Olvidó Contraseña?", modifier = Modifier.clickable {
        })

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "O ingrese con")

        Image(painter = painterResource(id = R.drawable.gmail),
            contentDescription = "Gmail",
            modifier = Modifier
                .size(60.dp)
                .clickable {
                    //Click de Gmail
                }
        )


        Text(text = "Presione para volver al login")
        Button(onClick = {
            navController.navigate("Login")
        }) {
            Text(text = "Ir a Login")
        }
    }
    
}