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

    var run by remember {
        mutableStateOf("")
    }

    var especialidad by remember {
        mutableStateOf("")
    }

    var fechaReserva by remember {
        mutableStateOf("")
    }

    var horaReserva by remember {
        mutableStateOf("")
    }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ){

        Text(text = "Ingresa datos requeridos para reserva")

        Spacer(modifier = Modifier.height(16.dp))

        //Ingreso de RUN
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Ingrese RUN")
        OutlinedTextField(value = run, onValueChange = {
            run = it

        }, label = {
            Text(text = "Run")
        })

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Especialidad
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Especialidad")
        OutlinedTextField(value = especialidad, onValueChange = {
            especialidad = it
        }, label = {
            Text(text = "Especialidad")
        })

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Fecha
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Fecha")
        OutlinedTextField(value = fechaReserva, onValueChange = {
            fechaReserva = it
        }, label = {
            Text(text = "Fecha")
        })

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Hora
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Hora")
        OutlinedTextField(value = horaReserva, onValueChange = {
            horaReserva = it
        }, label = {
            Text(text = "Hora")
        })

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            navController.navigate("Reservas")
        }) {
            Text(text = "Reservar")
        }

        Spacer(modifier = Modifier.height(32.dp))


        Text(text = "Presione para volver al login")
        Button(onClick = {
            navController.navigate("Login")
        }) {
            Text(text = "Ir a Login")
        }
    }
    
}