package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.domain.Recipe
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import kotlinx.coroutines.InternalCoroutinesApi

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                vertical = 6.dp,
                horizontal = 8.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {

            val painter = rememberGlidePainter(
                request = recipe.featuredImage ?: "",
                shouldRefetchOnSizeChange = { _, _ -> false },
            )

            Box {
                Image(
                    painter = painter,
                    contentDescription = "Food Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(250.dp),
                    contentScale = ContentScale.Crop,
                )

                when (painter.loadState) {
                    ImageLoadState.Empty, ImageLoadState.Loading ->
                        Box(Modifier.matchParentSize()) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }
                    is ImageLoadState.Success -> {}
                    is ImageLoadState.Error -> Image(
                        painter = painterResource(R.drawable.image_not_available),
                        contentDescription = "Placeholder Image",
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(
                        vertical = 12.dp,
                        horizontal = 8.dp
                    )
                    .fillMaxWidth()
            ) {
                Text(
                    text = recipe.title ?: "",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                )

                Text(
                    text = recipe.rating.toString(),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically)
                )

            }
        }
    }
}