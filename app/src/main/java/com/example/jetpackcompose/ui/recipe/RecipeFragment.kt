package com.example.jetpackcompose.ui.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment : BaseFragment() {

    @Composable
    override fun MainContent() {
        Column(modifier = Modifier.padding(16.dp)) {

        }
    }
}