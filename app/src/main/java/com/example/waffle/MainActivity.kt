package com.example.waffle

import android.net.Uri
import android.os.Build
//import android.net.Uri
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.waffle.composable.WaffleCard
import com.example.waffle.ui.theme.WaffleTheme
import com.example.waffle.composables.WalletConnectButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var activityResultSender = ActivityResultSender(this)
        setContent {
            WaffleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Column(modifier = Modifier.padding(16.dp)) {
                        WalletConnectButton(
                            identityUri = Uri.parse(application.getString((R.string.id_url))),
                            iconUri = Uri.parse(application.getString(R.string.id_favicon)),
                            identityName = application.getString(R.string.app_name),
                            activityResultSender = activityResultSender,
                            modifier = Modifier.align(Alignment.End))
                        WaffleCard(
                            identityUri = Uri.parse(application.getString((R.string.id_url))),
                            iconUri = Uri.parse(application.getString(R.string.id_favicon)),
                            identityName = application.getString(R.string.app_name),
                            intentSender = activityResultSender,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
            }
        }
    }
}

