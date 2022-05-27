package com.sina.covidreportviacompose.ui.theme.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.compose.AsyncImage
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.sina.covidreportviacompose.R
import com.sina.covidreportviacompose.domain.model.BottomMenuContent
import com.sina.covidreportviacompose.domain.model.Photo
import com.sina.covidreportviacompose.ui.theme.AquaBlue
import com.sina.covidreportviacompose.ui.theme.ButtonBlue
import com.sina.covidreportviacompose.ui.theme.DeepBlue

const val TAG = "CovidHomeScreen"

@Composable
fun CovidHomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val namesState = homeViewModel.state
    var name = remember {
        mutableStateOf("")
    }
    val isRefreshing = homeViewModel.isRefreshing
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { homeViewModel.refresh() },
            modifier = Modifier

        ) {
            LazyColumn() {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .background(MaterialTheme.colors.primaryVariant)
                    )
                    {

                        WorldStatComp(state = homeViewModel.state) {
                            homeViewModel.getWorldStat()
                        }
                    }

                }
            }
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_profile),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun WorldStatComp(state: WorldStatState, onFetch: () -> Unit) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
        )
        {
            if (state.isLoading == true) {
                CircularProgressIndicator()
            } else if (state.worldStat != null) {
                Text(
                    text = state.worldStat.cases ?: "fetch",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Composable
fun PhotosList(photos: List<Photo>?) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        photos?.let {
            items(it) { photo ->
                Log.d(TAG, "PhotosList: ${photo.title}")
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = photo.title?.substring(0, 8).toString(),
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        RoundPhoto(imageUrl = photo.thumbnailUrl.toString())
                    }
                }


            }
        }
    }
}

@Composable
fun Greeting(names: List<String>, isSelected: Int) {
    var value by remember { mutableStateOf(names) }
    Column(
        modifier = Modifier
            .border(5.dp, Color.Magenta, RectangleShape)
    ) {
        for (i in names.indices) {
            var rowColor = MaterialTheme.colors.primary
            if (names[i].contains("mi")) {
                rowColor = MaterialTheme.colors.secondary
            }
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(rowColor)
                    .align(CenterHorizontally)
                    .clickable { println("${names[i]} clicked ") }
            ) {
                Text("Hello ${names[i]}",
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .clickable { println("text clicked ") }
                        .background(MaterialTheme.colors.primary, shape = RoundedCornerShape(4.dp))
                        .align(Alignment.CenterVertically)
                        .padding(4.dp)

                )
            }

        }
    }

}

@Composable
fun HelloContent(name: String, onTextFieldChange: (String) -> Unit, click: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = { onTextFieldChange(it) },
            label = { Text("Name") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { click.invoke() }) {
            Text(text = "Remove Space")
        }
    }
}

@Composable
fun RoundPhoto(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        alignment = Alignment.Center,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .padding(4.dp)
            .size(24.dp)
            .clip(CircleShape)

    )
/*    GlideImage(
        modifier = modifier
            .width(50.dp)
            .height(50.dp)
            .clip(CircleShape),
        imageModel = imageUrl,
        // Crop, Fit, Inside, FillHeight, FillWidth, None
        contentScale = ContentScale.Crop,
        // shows an image with a circular revealed animation.
        circularReveal = CircularReveal(duration = 250),
        // shows a placeholder ImageBitmap when loading.

        // shows an error ImageBitmap when the request failed.

    )*/
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)

            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CovidHomeScreen()
}