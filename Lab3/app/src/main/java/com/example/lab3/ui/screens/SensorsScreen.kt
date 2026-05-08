package com.example.lab3.ui.screens
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview

@Composable
fun SensorScreen1(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProximitySensor()

    }
}


@Composable
fun useSensor(sensorType: Int): List<Float> {
    val context = LocalContext.current
    // Use safe cast and handle null for Preview support as SensorManager might not be available
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as? SensorManager }
    var sensorValues by remember { mutableStateOf(listOf(0f, 0f, 0f)) }
    val sensor = remember(sensorManager, sensorType) { sensorManager?.getDefaultSensor(sensorType) }

    // If sensorManager or sensor is not available (e.g., in Preview), return the initial values
    if (sensorManager == null || sensor == null) return sensorValues

    DisposableEffect(sensorType) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues = it.toList()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues
}

@Composable
fun ProximitySensor () {
    val proximityValues = useSensor(Sensor.TYPE_PROXIMITY)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Proximidad", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Distancia:${proximityValues[0]} cm", fontSize = 18.sp)
        }
    }
}