package dev.arabicdictionary.pro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform