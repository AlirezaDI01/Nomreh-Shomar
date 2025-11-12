package di.alireza.nomrehshomar.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import di.alireza.nomrehshomar.util.NumberToText.toText
import di.alireza.nomrehshomar.viewmodels.MainViewModel

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: MainViewModel = viewModel()) {

    if (viewModel.isAboutMeDialogShown.value) {
        AboutMeDialog { viewModel.showDialog() }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xff19344e),
                        Color(0xff4e95d9)
                    )
                )
            )
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight(.45f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                "درباره برنامه",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .clickable { viewModel.showDialog() }
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = ": مجموع", fontSize = 32.sp, color = Color(0xfffde2e4))
                Spacer(Modifier.height(32.dp))
                Text(
                    text = toText(viewModel.totalMark.floatValue),
                    fontSize = 48.sp,
                    color = Color(0xfffde2e4)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {

                MarksHistory(viewModel.marksHistoryText.value)

                Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                    ScoreBox(
                        score = 0.25f,
                        color = Color(0xfffde2e4),
                        modifier = Modifier.weight(1f),
                        isMinus = viewModel.isMinusModeOn.value
                    ) {
                        viewModel.addScore(0.25f)
                    }
                    ScoreBox(
                        score = 0.5f,
                        color = Color(0xffcddafd),
                        modifier = Modifier.weight(1f),
                        isMinus = viewModel.isMinusModeOn.value
                    ) {
                        viewModel.addScore(0.5f)

                    }
                    ScoreBox(
                        score = 0.75f,
                        color = Color(0xffd9f2d0),
                        modifier = Modifier.weight(1f),
                        isMinus = viewModel.isMinusModeOn.value
                    ) {
                        viewModel.addScore(0.75f)
                    }
                }

                Row(modifier = Modifier.padding(horizontal = 4.dp)) {
                    ScoreBox(
                        score = 1f,
                        color = Color(0xffeae4e9),
                        modifier = Modifier.weight(1f),
                        isMinus = viewModel.isMinusModeOn.value
                    ) {
                        viewModel.addScore(1f)
                    }
                    ScoreBox(
                        score = 2f,
                        color = Color(0xfff2cfee),
                        modifier = Modifier.weight(1f),
                        isMinus = viewModel.isMinusModeOn.value
                    ) {
                        viewModel.addScore(2f)
                    }
                }

                Spacer(Modifier.height(32.dp))


                Row(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                ) {
                    MyButton(
                        text = "بازنشانی",
                        textColor = Color(0xfffde2e4),
                        color = Color(0xffee0000),
                        modifier = Modifier.weight(.65f)
                    ) {
                        viewModel.resetTotal()
                    }
                    MyButton(
                        text = if (viewModel.isMinusModeOn.value) "افزایش" else "کاهش",
                        textColor = Color.Black,
                        color = Color(0xfffed9b7),
                        modifier = Modifier.weight(.35f)
                    ) {
                        viewModel.turnMinusModeOnAndOff()
                    }

                }
            }
        }
    }
}