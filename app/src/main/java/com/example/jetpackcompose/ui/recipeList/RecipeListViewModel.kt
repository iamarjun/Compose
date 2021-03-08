package com.example.jetpackcompose.ui.recipeList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipes by lazy { mutableStateOf<List<Recipe>>(listOf()) }

    init {
        viewModelScope.launch {
            val response = repository.getRecipes("chicken")
            recipes.value = response
        }
    }

}