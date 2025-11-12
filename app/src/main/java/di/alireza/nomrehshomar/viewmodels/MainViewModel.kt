package di.alireza.nomrehshomar.viewmodels

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import di.alireza.nomrehshomar.util.NumberToText.toText

class MainViewModel : ViewModel() {

    val totalMark = mutableFloatStateOf(0f)
    val isMinusModeOn = mutableStateOf(false)


    var marksHistoryText = mutableStateOf("")
        private set
    var isAboutMeDialogShown = mutableStateOf(false)
        private set

    fun addScore(score: Float) {

        if (isMinusModeOn.value) {
            if (totalMark.floatValue > 0f) {
                totalMark.floatValue -= score
                marksHistoryText.value += " - ${toText(score = score)}"
            }
            if (totalMark.floatValue < 0f) totalMark.floatValue = 0f
        } else {
            totalMark.floatValue += score
            marksHistoryText.value += " + ${toText(score = score)}"
        }
    }

    fun resetTotal() {
        totalMark.floatValue = 0f
        marksHistoryText.value = ""
        isMinusModeOn.value = false
    }

    fun turnMinusModeOnAndOff() {
        isMinusModeOn.value = !isMinusModeOn.value
    }

    fun showDialog() {
        isAboutMeDialogShown.value = !isAboutMeDialogShown.value
    }
}