package com.example.bluetoothhc_05

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.bluetoothhc_05.presentation.MainScreen
import com.example.bluetoothhc_05.ui.theme.BluetoothHC05Theme
import java.util.UUID

class MainActivity : ComponentActivity() {

    lateinit var myBltDevice: BluetoothDevice
    lateinit var bluetoothManager: BluetoothManager
    lateinit var bluetoothAdapter: BluetoothAdapter
    lateinit var takePermission: ActivityResultLauncher<String>
    lateinit var takeResultLauncher: ActivityResultLauncher<Intent>
    val MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    lateinit var btSocket: BluetoothSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter

        takePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it){
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                takeResultLauncher.launch(intent)
            }
            else {
                Toast.makeText(
                    applicationContext,
                    "Bluetooth Permission is not Granted",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        takeResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback { result ->
                    if (result.resultCode == RESULT_OK) {
                        Toast.makeText(applicationContext, "Bluetooth enabled", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(applicationContext, "Bluetooth disabled", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        fun BluetoothDisable(){
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    android.Manifest.permission.BLUETOOTH_CONNECT
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                bluetoothAdapter.disable()
                Toast.makeText(applicationContext, "Bluetooth disabled", Toast.LENGTH_SHORT).show()
            }
        }
        enableEdgeToEdge()
        setContent {
            BluetoothHC05Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainScreen(
                        modifier = Modifier.fillMaxSize(),
                        takePermission = takePermission,
                        onBluetoothDisableClick = {BluetoothDisable()}
                    )
                }
            }
        }
    }
}
