package com.example.lazycolumnbackground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumnbackground.ui.theme.LazyColumnBackgroundTheme

@Composable
fun LazyColumnWithBackground(
    itemsList: List<String>
) {

    val lazyListState = rememberLazyListState()

    Box(
        contentAlignment = Alignment.TopCenter,
    ) {
        Row(
            modifier = Modifier.graphicsLayer {
                translationY =
                    lazyListState.layoutInfo.visibleItemsInfo.firstOrNull { itemInfo ->
                        itemInfo.key == "Two"
                    }?.let { keyItem ->
                        val centerOfKeyItemOffset = keyItem.offset.toFloat() + (keyItem.size / 2f)
                        if (centerOfKeyItemOffset > 0) centerOfKeyItemOffset else 0f
                    } ?: 0f
            },
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
        }

        LazyColumn(
            state = lazyListState,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(itemsList, key = { it }) { item ->
                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnWithBackgroundPreview() {
    LazyColumnBackgroundTheme {
        LazyColumnWithBackground(
            itemsList = listOf(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Eleven",
                "Twelve",
                "Thirteen",
                "Fourteen",
                "Fifteen",
            )
        )
    }
}