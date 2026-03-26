package com.example.cemacuatro

import android.R.attr.entries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cemacuatro.ui.theme.CEMACUATROTheme
import java.net.CookieStore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CEMACUATROTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Screen1(innerPadding)
                }
            }
        }
    }
}

@Preview
@Composable
fun Screen1(paddingValues: PaddingValues){
    var nombres = remember { mutableStateListOf<String>() }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            val usuario: MutableState<String> = remember { mutableStateOf("")}
            TextField(
                value = usuario.value,
                onValueChange = {
                    usuario.value = it
                },
                label = { Text("Ingrese su nombre") },
                placeholder = { Text("Nombre") },
            )
            Button(
                onClick = {
                    if (usuario.value.isNotEmpty()){
                        nombres.add(usuario.value)
                        usuario.value = ""
                    }
                }
            ) {
                Text(text = "Guardar")
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Listado de nombres y \nposicion en la lista")
                Button(
                    onClick = {
                        nombres.clear()
                    }
                ) {
                    Text(text = "Limpiar",
                        textAlign = TextAlign.Left)
                }

            }
            Box(
                modifier = Modifier
                    .border(BorderStroke(2.dp, Color.Blue))
                    .fillMaxSize()
                    .padding(16.dp),
            ){
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .padding(10.dp)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    LazyColumn {
                        itemsIndexed(nombres.toList()) { index, item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = item
                                )
                                Text(
                                    text = (index + 1).toString()
                                )
                            }
                        }
                    }
                }

            }

        }

    }

}