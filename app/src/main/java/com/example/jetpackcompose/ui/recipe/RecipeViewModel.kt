package com.example.jetpackcompose.ui.recipe

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.model.domain.Recipe
import com.example.jetpackcompose.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {

    val recipe by lazy { mutableStateOf<Recipe?>(null) }

    fun getRecipe(id: Int?) {
        viewModelScope.launch {
            try {
                val response = repository.getRecipe(id = id)
                recipe.value = response
            } catch (e: Exception) {
                Log.d(TAG, "get recipe: $e")
            }
        }
    }

    companion object {
        private const val TAG = "RecipeViewModel"
    }
}