package kz.assylkhanov.jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import kz.assylkhanov.jetpackcompose.R

@Composable
fun InputScreen(navController: NavController) {
    val enteredText = remember { mutableStateOf("") }
    val text = null
    InputScreenInternal(enteredText = enteredText.value,
        onTextChange = { enteredText.value = it },
        onClearClick = { enteredText.value = "" },
        onDoneClick = { navController.navigate("result?") }
    )
}

@Composable
private fun InputScreenInternal(
    enteredText: String,
    onTextChange: (String) -> Unit,
    onClearClick: () -> Unit,
    onDoneClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = enteredText)

        TextField(value = enteredText, onValueChange = {

            onTextChange(it)
        })
        Button(onClick = onClearClick) {
            Text(text = stringResource(id = R.string.clear))
        }

        Button(onClick = onDoneClick) {
            Text(text = stringResource(id = R.string.done))
        }
    }
}