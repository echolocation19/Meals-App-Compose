package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.details.MealDetailScreen
import com.example.mealzapp.details.MealDetailsViewModel
import com.example.mealzapp.model.response.MealsResponse
import com.example.mealzapp.ui.feautures.MealsCategoriesScreen
import com.example.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodzApp()
            }
        }
    }
}

@Composable
private fun FoodzApp() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController,
        startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            MealsCategoriesScreen { navigationId ->
                navigationController.navigate("destination_meals_details/$navigationId")
            }
        }
        composable(route = "destination_meals_details/{meal_category_id}",
        arguments = listOf(navArgument("meal_category_id") {
            type = NavType.StringType
        })
        ) {
            val viewModel: MealDetailsViewModel = viewModel()
            MealDetailScreen(viewModel.mealState.value)
        }
    }

}
