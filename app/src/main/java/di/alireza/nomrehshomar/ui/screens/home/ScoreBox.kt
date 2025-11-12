package di.alireza.nomrehshomar.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import di.alireza.nomrehshomar.util.NumberToText.toText

@Composable
fun ScoreBox(score: Float, color: Color, modifier: Modifier,isMinus : Boolean ,onClick: () -> Unit) {

    var text by remember {
        mutableStateOf("")
    }

    text = if (isMinus){
        "⛔ ${toText(score = score)}"
    }else{
        toText(score = score)
    }

    Box(
        modifier = modifier
            .height(84.dp)
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = color)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Text(text = text, color = Color.Black, fontSize = 24.sp)
    }


}