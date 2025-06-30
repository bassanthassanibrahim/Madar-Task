package com.example.madartask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.madartask.presentation.navigation.AppNavGraph
import com.example.madartask.ui.theme.MadarTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MadarTaskTheme {
                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MadarTaskTheme {
        val navController = rememberNavController()
        AppNavGraph(navController = navController)
    }
}