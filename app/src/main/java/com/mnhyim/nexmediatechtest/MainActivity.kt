package com.mnhyim.nexmediatechtest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mnhyim.nexmediatechtest.ui.navigation.MainNavHost
import com.mnhyim.nexmediatechtest.ui.theme.NexMediaTechTestTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NexMediaTechTestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->
                    MainNavHost()
                }
            }
        }
    }
}
