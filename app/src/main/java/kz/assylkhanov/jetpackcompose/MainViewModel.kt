package kz.assylkhanov.jetpackcompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text: MutableState<String> = mutableStateOf("")
    val text: State<String> = _text


    fun onTextChange(newText: String) {
        _text.value = newText
    }

    fun onClearButtonClick() {
        _text.value = ""
    }


}