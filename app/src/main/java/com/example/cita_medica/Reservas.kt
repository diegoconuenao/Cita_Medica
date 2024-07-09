package com.example.cita_medica

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date


@RequiresApi(Build.VERSION_CODES.N)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reservas(navController: NavController){


    var showDialogReserva by remember {
        mutableStateOf(false)
    }

    var showDialogConfirmar by remember {
        mutableStateOf(false)
    }
    /*
    if (showDialog){
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(onClick = { }) {
                    Text(text = "Actualizar")
                    }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false
                }) {
                    Text(text = "Cancelar")
                }
            },
            title = { Text("Confirmar")},
            text = {
                Text(text = "Seguro")
            }
        )
    }

     */

    var run by remember {
        mutableStateOf("")
    }

    var isExpandedEsp by remember {
        mutableStateOf(false)
    }

    var especialidad by remember {
        mutableStateOf("")
    }

    //-----------------------------------------------------------
    val fecha = rememberDatePickerState()
    var showDialogFecha by remember {
        mutableStateOf(false)
    }

    var fechaReserva by remember {
        mutableStateOf("")
    }
    /*
    Button(onClick = {
        showDialogFecha=true

    }) {
        Text(text = "Mostrar Fecha")
        
    }
    if (showDialogFecha){
        DatePickerDialog(
            onDismissRequest = {
                showDialogFecha=false },
            confirmButton = {
                Button(onClick = {showDialogFecha=false}) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {showDialogFecha=false}) {
                    Text(text = "Cancelar")
                }
            }
        ) {
            DatePicker(state = fechaReserva)
        }
    }
    val date = fechaReserva.selectedDateMillis
    date?.let {
        val localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
        Text(text = "Fecha Seleccionada: ${localDate.dayOfMonth}/${localDate.month}/${localDate.year}")
    }

    //-----------------------------------

     */

    var isExpandedHora by remember {
        mutableStateOf(false)
    }

    var horaReserva by remember {
        mutableStateOf("")
    }
/*
    var datosReserva by remember {
        mutableStateOf("")
    }
*/
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

        ExposedDropdownMenuBox(
            expanded = isExpandedEsp,
            onExpandedChange = {isExpandedEsp = it})
        {
            TextField(
                value = especialidad,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedEsp)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpandedEsp,
                onDismissRequest = { isExpandedEsp=false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "Cardiologo")
                    },
                    onClick = {
                        especialidad = "Cardiologo"
                        isExpandedEsp = false

                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "Nutricionista")
                    },
                    onClick = {
                        especialidad = "Nutricionista"
                        isExpandedEsp = false

                    }
                )

            }


        }


        /*
        OutlinedTextField(value = especialidad, onValueChange = {
            especialidad = it
        }, label = {
            Text(text = "Especialidad")
        })

         */

        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Fecha
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Fecha")

        Button(onClick = {
            showDialogFecha=true

        }) {
            Text(text = "Mostrar Fecha")

        }
        if (showDialogFecha){
            DatePickerDialog(
                onDismissRequest = {
                    showDialogFecha=false },
                confirmButton = {
                    Button(onClick = {showDialogFecha=false}) {
                        Text(text = "Confirmar")
                    }
                },
                dismissButton = {
                    OutlinedButton(onClick = {showDialogFecha=false}) {
                        Text(text = "Cancelar")
                    }
                }
            ) {
                DatePicker(state = fecha)
            }
        }
        val date = fecha.selectedDateMillis
        date?.let {
            val localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
            Text(text = "Fecha Seleccionada: ${localDate.dayOfMonth}/${localDate.month}/${localDate.year}")
            fechaReserva = localDate.toString()
        }




        Spacer(modifier = Modifier.height(16.dp))

        //Seleccion de Hora
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Seleccione Hora")

        ExposedDropdownMenuBox(
            expanded = isExpandedHora,
            onExpandedChange = {isExpandedHora = it})
        {
            TextField(
                value = horaReserva,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedHora)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isExpandedHora,
                onDismissRequest = { isExpandedHora=false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text(text = "08:00")
                    },
                    onClick = {
                        horaReserva = "08:00"
                        isExpandedHora = false

                    }
                )
                DropdownMenuItem(
                    text = {
                        Text(text = "08:30")
                    },
                    onClick = {
                        horaReserva = "08:30"
                        isExpandedHora = false

                    }
                )

            }


        }
        /*
        OutlinedTextField(value = horaReserva, onValueChange = {
            horaReserva = it
        }, label = {
            Text(text = "Hora")
        })
        */

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDialogReserva = true
            //navController.navigate("Reservas")
        }


        ) {
            Text(text = "Reservar")
            if (showDialogReserva){
                AlertDialog(
                    onDismissRequest = {
                        //showDialogReserva = false
                    },
                    confirmButton = {
                        TextButton(onClick = {showDialogConfirmar = true})
                        {
                            Text(text = "Confirmar Reserva")

                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDialogReserva = false
                        }) {
                            Text(text = "Cancelar")
                        }
                    },

                    title = { Text("Datos de Reserva")},

                    text = {
                        Column {
                            Text(text = "RUN: " + run)
                            Text(text = "Especialidad: " + especialidad)
                            Text(text = "Fecha Reservada: " + fechaReserva)
                            Text(text = "Hora: " + horaReserva)

                        }
                    }

                )
            }
            if (showDialogConfirmar){
                AlertDialog(
                    onDismissRequest = {
                        //showDialogConfirmar = false
                    },
                    confirmButton = {
                        TextButton(onClick = {showDialogConfirmar=false }) {
                            Text(text = "Listo")

                        }
                    },
                    text = {
                        Column {
                            Text(text = "¡Reserva realizada con Éxito!")
                            showDialogReserva=false
                            run=""
                            especialidad=""

                            horaReserva=""
                        }
                    }

                )
            }
        }
        /*
        //--------------------------

        if (showDialogReserva){
            AlertDialog(
                onDismissRequest = {
                    //showDialogReserva = false
                },
                confirmButton = {
                    TextButton(onClick = {showDialogConfirmar = true})
                    {
                        Text(text = "Confirmar Reserva")

                        if (showDialogConfirmar){
                            AlertDialog(
                                onDismissRequest = {
                                    //showDialogConfirmar = false
                                },
                                confirmButton = {
                                    TextButton(onClick = {showDialogConfirmar=false }) {
                                        Text(text = "Listo")

                                    }
                                },
                                text = { Column {
                                    Text(text = "¡Reserva realizada con Éxito!")
                                    //showDialogReserva=false
                                }
                                }

                            )
                        }

                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialogReserva = false
                    }) {
                        Text(text = "Cancelar")
                    }
                },

                title = { Text("Datos de Reserva")},

                text = {
                    Column {
                        Text(text = "RUN: " + run)
                        Text(text = "Especialidad: " + especialidad)
                        Text(text = "Fecha: " + fechaReserva)
                        Text(text = "Hora: " + horaReserva)
                    }
                }

            )
        }

         */
        //---------------------------

        Spacer(modifier = Modifier.height(32.dp))


        Text(text = "Presione para volver al login")
        Button(onClick = {
            navController.navigate("Login")
        }) {
            Text(text = "Ir a Login")
        }

        Spacer(modifier = Modifier.height(32.dp))



        Button(onClick = {
            navController.navigate("Listar")
        }) {
            Text(text = "Listar Reservas")
        }

    }

}

