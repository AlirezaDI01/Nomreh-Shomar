package di.alireza.nomrehshomar.util

object NumberToText {

    fun toText(score: Float): String {
        val t = score.toString().toCharArray()

        if (score == 0f || score % 10 == 0f) {
            return score.toInt().toString()
        }

        t.mapIndexed { index, ch ->
            if (ch == '.') t[index] = '/'
        }

        val result = t.dropLastWhile { ch ->
            (ch == '0' || ch == '/')
        }
            .joinToString(separator = "")

        return result
    }
}