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
    loginState: LoginUiState,
    onRefreshShowcase: () -> Unit,
    onLogin: (String, String, () -> Unit) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "login" -> LoginScreen(
            state = loginState,
            onLogin = { email, password ->
                onLogin(email, password) { currentScreen = "interests" }
            },
            modifier = modifier
        )
        "interests" -> InterestsScreen(
            state = showcaseState,
            onRefresh = onRefreshShowcase,
            onBack = { currentScreen = "home" },
            modifier = modifier
        )
        else -> HomeScreen(
            modifier = modifier,
            onInterestsClick = { currentScreen = "login" }
        )
    }
}
