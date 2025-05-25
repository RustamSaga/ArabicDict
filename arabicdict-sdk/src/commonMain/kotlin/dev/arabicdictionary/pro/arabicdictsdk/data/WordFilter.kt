package dev.arabicdictionary.pro.arabicdictsdk.data

import dev.arabicdictionary.pro.arabicdictsdk.data.words.WordType

data class WordFilter(
    val word: String?,
    val wordType: WordType,
)
