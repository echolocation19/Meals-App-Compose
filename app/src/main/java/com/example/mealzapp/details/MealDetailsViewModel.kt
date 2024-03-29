package com.example.mealzapp.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealsResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealsResponse?>(null)
    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }

}