package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.accompanist.glide.GlideImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(content = {

                item {
                    GlideImage(
                        data = "https://i.pinimg.com/originals/ae/25/43/ae2543119b521e558af0f625fb701b32.jpg",
                        contentDescription = "My content description",
                        fadeIn = true,
                    )
                }

                itemsIndexed(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)) { index, item ->
                    Text(
                        text = "Hi $index",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.ExtraBold
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                }

            })
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}