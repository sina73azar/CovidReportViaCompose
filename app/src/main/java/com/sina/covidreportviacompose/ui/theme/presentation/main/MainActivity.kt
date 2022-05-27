package com.sina.covidreportviacompose.ui.theme.presentation.main

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sina.covidreportviacompose.ui.theme.CovidReportViaComposeTheme
import com.sina.covidreportviacompose.ui.theme.presentation.home.CovidHomeScreen
import com.sina.covidreportviacompose.ui.theme.presentation.home.HomeViewModel
import com.sina.covidreportviacompose.util.TestHilt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
const val TAG="MainActivity"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(ContextCompat.checkSelfPermission(baseContext, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED){
            Log.d(TAG, "onCreate: request")
        }
        else{
            Log.d(TAG, "onCreate: granted")
        }
        setContent {
            MyApp {
                CovidHomeScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    CovidReportViaComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}



@Composable
fun MyScreenContent(names: List<String> = List(1000) { "covid report $it" }) {
    var counterState by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        NamesList(names = names, modifier = Modifier.weight(1f))
        Counter()
    }
}

@Composable
fun NamesList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names){
            CovidItem(name = it)
            Divider()
        }
    }
}

@Composable
fun CovidItem(name: String) {
    Text(
        text = "$name!",
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun Counter() {
    var counter by remember {
        mutableStateOf(0)
    }
    Button(onClick = { counter++ }) {
        Text(text = "I have been clicked for $counter times")

    }
}

