package edu.lemoyne.campusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme

class MainActivity : ComponentActivity() {
    private val showcaseViewModel: ShowcaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val showcaseState by showcaseViewModel.state.collectAsStateWithLifecycle()
            CampusAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CampusAppScreen(
                        showcaseState = showcaseState,
                        onRefreshShowcase = showcaseViewModel::refresh,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// --- Class 6 · Step 1: my own screen ---
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onSupabase: () -> Unit = {}) {
    // --- Class 6 · Step 3: a column, so things stack ---
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        // --- Class 6 · Step 4: real styling ---
        Text(text = "One Step", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Just the next small thing",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Serve toss practice, 10 minutes", fontSize = 18.sp)
        Text(text = "Reply to coach about Saturday", fontSize = 18.sp)
        Text(text = "Review class notes", fontSize = 18.sp)
        Text(text = "Stretch after practice", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onSupabase) { Text("Open Supabase") }
    }
}

// --- Class 6 · Step 2: preview, no build required ---
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CampusAppTheme {
        HomeScreen()
    }
}