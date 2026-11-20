1. In dark mode, the background went from near-white to near-black and the "Hello Emmanuel!" text went from dark to light, both on their own.

2. I'm not sure exactly, but I think my first build was around 10 seconds, and later runs were about 5 seconds. I didn't notice a big difference. I think Gradle reuses work from earlier builds, so later ones can be faster.

3. In dark mode the status bar icons were almost invisible in one screenshot but white in the next. I don't understand what controls their colour or why it changed.

## Week 13, Wednesday: Lab 21

1. When InterestsScreen first opens, a LaunchedEffect(Unit) at the top of the screen runs and calls onRefresh(), which is showcaseViewModel.refresh. I think it only runs once when the screen shows up, not every time it redraws.

2. When I tap the Refresh items button, its onClick calls onRefresh, which is the same function the LaunchedEffect calls. So opening the screen and tapping the button do the exact same thing.

3. The screen gets onRefresh instead of the ViewModel because it only needs to say "load again". It doesn't need to know how the loading works. MainActivity keeps the ViewModel, and I think that also makes the screen simpler.

4. A successful [] means the request worked and Supabase just had no rows, so the app shows "No items yet." A network failure means the request never got an answer, so the app catches the error and shows the Error message instead.

5. Both my website and my Android app read the same showcase_items table in my Supabase project, using the same URL and publishable key. I compared a couple of titles on interests.html with the Android screen, and they matched.
