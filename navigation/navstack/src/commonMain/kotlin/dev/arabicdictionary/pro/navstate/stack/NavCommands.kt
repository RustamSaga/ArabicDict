package dev.arabicdictionary.pro.navstate.stack

import dev.arabicdictionary.pro.navstate.NavCommand
import dev.arabicdictionary.pro.navstate.NavEntry
import dev.arabicdictionary.pro.navstate.NavStructure
import dev.arabicdictionary.pro.navstate.buildNavState


public fun NavCommand.popTop(count: Int = 1): NavCommand {
    require(count > 0) { "Count must be positive value" }
    return then { state ->
        state.buildNavState {
            add(
                (state.current as NavStack)
                    .let { entriesContainer ->
                        val entries = entriesContainer.entries
                        val newEntries = entries.subList(0, (entries.size - count).coerceAtLeast(1))
                        entriesContainer.copy(entries = newEntries)
                    },
            )
        }
    }
}

public fun NavCommand.newStack(
    id: NavStructure.Id,
    entry: NavEntry,
): NavCommand {
    return then { state ->
        state.buildNavState {
            add(NavStack(id, listOf(entry)))
        }
    }
}