package di.alireza.nomrehshomar.ui.screens.home

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri

@Composable
fun AboutMeDialog(onDismiss: () -> Unit) {

    val context = LocalContext.current

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Dialog(onDismissRequest = { onDismiss() }) {


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color(0xffeae4e9)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "نمره شمار",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 6.dp)
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    "گاهی جمع زدن نمرات امتحانی کاری خسته کننده‌ست. با این شمارنده می‌شه کمی این کار رو آسون تر کرد.",
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 6.dp)
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "علیرضا دهقانی - 1404",
                    color = Color.DarkGray,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 6.dp)
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "کانال تلگرام:",
                    color = Color.DarkGray,
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 6.dp)
                )

                Text(
                    text = "https://t.me/alureka",
                    color = Color(0xFF0088cc), // Telegram blue
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .clickable {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                "https://t.me/alureka".toUri()
                            )
                            context.startActivity(intent)
                        }
                )
            }
        }
    }
}