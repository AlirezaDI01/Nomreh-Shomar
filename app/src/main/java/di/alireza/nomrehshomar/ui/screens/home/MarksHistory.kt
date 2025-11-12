package di.alireza.nomrehshomar.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MarksHistory(text: String) {

    Text(text = text, maxLines = 6, color = Color.White)

}