package dev.arabicdictionary.pro.common.features

import dev.arabicdictionary.pro.navstate.NavDest

object ArabicDictNavGraph {
    sealed interface Dest : NavDest {
        class Auth : Dest

        class ProjectNavigator : Dest

        data class AssetNavigator(
            val projectId: String,
        ) : Dest
    }

    sealed interface Alias : NavDest {
        /**
         * Start application navigation from scratch
         */
        data object Root : Alias

        /**
         * Open main authorized screen
         */
        data object Main : Alias

        /**
         * Open authorization screen
         */
        data object Authorization : Alias
    }
}
