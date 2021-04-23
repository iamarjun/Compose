package com.example.jetpackcompose.ui.recipe

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.BaseFragment
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment : BaseFragment() {

    private val args by navArgs<RecipeFragmentArgs>()
    private val viewModel by viewModels<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getRecipe(args.recipe.id)
    }

    @Composable
    override fun MainContent() {
        val recipe = args.recipe

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = recipe.title.toString()) },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                findNavController().popBackStack()
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back Arrow"
                            )
                        }
                    }
                )
            },
        ) {
            LazyColumn() {

                item {
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
                            is ImageLoadState.Success -> {
                            }
                            is ImageLoadState.Error -> Image(
                                painter = painterResource(R.drawable.image_not_available),
                                contentDescription = "Placeholder Image",
                            )
                        }
                    }

                }

                item {
                    Text(
                        text = "Updated on ${recipe.dateUpdated} by ${recipe.publisher}",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                items(
                    items = recipe.ingredients ?: listOf()
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 8.dp,
                                vertical = 4.dp
                            ),
                        style = MaterialTheme.typography.body1
                    )
                }

            }
        }
    }
}