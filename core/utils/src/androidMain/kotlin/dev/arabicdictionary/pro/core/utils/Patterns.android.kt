package dev.arabicdictionary.pro.core.utils

import androidx.core.util.PatternsCompat

public actual fun validateEmail(email: String): Boolean = PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
