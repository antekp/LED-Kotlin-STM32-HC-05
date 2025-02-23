package com.example.bluetoothhc_05.presentation

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.example.bluetoothhc_05.R

@Composable
fun MainScreen(
    modifier: Modifier,
    takePermission: ActivityResultLauncher<String>,
    onBluetoothDisableClick:() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .alpha(1f)
    ){
        Image(
            painter = painterResource(id = R.drawable.background2_digital),
            contentDescription = "wallpaper",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 1f
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
            Text("Control LED on your STM32", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 26.sp)

            }
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonColors(containerColor = Color.Black, contentColor = Color.Black, Color.Black, Color.Black),
                    modifier = Modifier
                        .width(164.dp)
                        .height(64.dp)
                        .alpha(0.7f),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {takePermission.launch(android.Manifest.permission.BLUETOOTH_CONNECT)}

                ) {
                    Text("Bluetooth On", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
                Button(
                    colors = ButtonColors(containerColor = Color.Black, contentColor = Color.Black, Color.Black, Color.Black),
                    modifier = Modifier
                        .width(164.dp)
                        .height(64.dp)
                        .alpha(0.7f),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {
                        onBluetoothDisableClick()
                    }
                ) {
                    Text("Bluetooth Off", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }

            }
            Spacer(modifier = Modifier.height(64.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonColors(containerColor = Color.Black, contentColor = Color.Black, Color.Black, Color.Black),
                    modifier = Modifier
                        .height(64.dp)
                        .alpha(0.7f),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {}
                ) {
                    Text("Connect to HC-05 Bluetooth module", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }
            Spacer(modifier = Modifier.height(64.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    colors = ButtonColors(containerColor = Color.Black, contentColor = Color.Black, Color.Black, Color.Black),
                    modifier = Modifier
                        .width(164.dp)
                        .height(64.dp)
                        .alpha(0.7f),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {}
                ) {
                    Text("LED ON", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
                Button(
                    colors = ButtonColors(containerColor = Color.Black, contentColor = Color.Black, Color.Black, Color.Black),
                    modifier = Modifier
                        .width(164.dp)
                        .height(64.dp)
                        .alpha(0.7f),
                    shape = RoundedCornerShape(16.dp),
                    onClick = {}
                ) {
                    Text("LED OFF", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }

        }
    }
}
