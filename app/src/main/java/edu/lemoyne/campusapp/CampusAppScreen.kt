package edu.lemoyne.campusapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

// Screen owner: holds currentScreen and decides which screen to show.
@Composable
fun CampusAppScreen(
    showcaseState: ShowcaseUiState,
    onRefreshShowcase: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "supabase" -> InterestsScreen(
            state = showcaseState,
            onBack = { currentScreen = "home" },
            onRefresh = onRefreshShowcase, // Lab 21: Task 1
            modifier = modifier
        )
        else -> HomeScreen(
            modifier = modifier,
            onSupabase = { currentScreen = "supabase" }
        )
    }
}
