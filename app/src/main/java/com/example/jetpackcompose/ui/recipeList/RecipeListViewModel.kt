package com.example.jetpackcompose.ui.recipeList

import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {
}