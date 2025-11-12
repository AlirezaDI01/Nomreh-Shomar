package di.alireza.nomrehshomar.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyButton(
    text: String,
    textColor: Color,
    color: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .height(68.dp)
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = color)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Text(text = text, color = textColor, fontSize = 24.sp)
    }


}