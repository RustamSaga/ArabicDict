package dev.arabicdictionary.pro.navstate

public fun interface NavInterceptor {
    public suspend fun intercept(
        navCommand: NavCommand,
        oldState: NavState,
        newState: NavState,
    ): NavState
}
