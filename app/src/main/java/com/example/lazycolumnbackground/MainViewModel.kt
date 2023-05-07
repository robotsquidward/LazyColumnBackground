package com.example.lazycolumnbackground

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {

    private val _items: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val items: StateFlow<List<String>> = _items

    init {
        updateItems()
    }

    private fun updateItems() {
        _items.value = listOf(
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
    }
}