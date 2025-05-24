package dev.arabicdictionary.pro.navstate


/**
 * Switch between already created task. If task doesn't exist then do nothing
 */
public fun NavCommand.switchCurrent(currentId: NavStructure.Id): NavCommand =
    then { state ->
        val hasEntriesStruct = state.structures.any { it.id == currentId && it is NavEntriesStructure }
        if (hasEntriesStruct) state.copy(currentId = currentId) else state
    }

public fun NavCommand.remove(stackId: NavStructure.Id): NavCommand =
    then { state ->
        state.copy(structures = state.filterNot { it.id == stackId }.toSet())
    }

public fun NavCommand.add(structure: NavStructure): NavCommand =
    then { state ->
        state.copy(
            structures = state.structures + structure,
            currentId = structure.id,
        )
    }

public fun NavCommand.add(
    structure: NavStructure,
    setCurrent: Boolean,
): NavCommand {
    if (setCurrent) {
        return then { state ->
            state.copy(
                structures = state.structures + structure,
                currentId = structure.id,
            )
        }
    } else {
        return add(structure)
    }
}

public fun NavCommand.forward(
    dest: NavDest,
    tags: List<Any> = emptyList(),
): NavCommand =
    then { state ->
        val curNavEntriesStruct = state.current
        check(curNavEntriesStruct is NavEntriesStructure.Forward)
        state.buildNavState {
            add(curNavEntriesStruct.forward(NavEntry(dest, tags)))
        }
    }

public fun NavCommand.forward(
    dest: NavDest,
    structId: NavStructure.Id,
    tags: List<Any> = emptyList(),
): NavCommand =
    then { state ->
        val curNavEntryStruct = state.structures
            .asSequence()
            .filterIsInstance<NavEntriesStructure.Forward>()
            .first { it.id == structId }
        state.buildNavState {
            add(curNavEntryStruct.forward(NavEntry(dest, tags)))
        }
    }

public fun NavCommand.back(): NavCommand {
    return then { state ->
        state.buildNavState {
            add(
                checkNotNull((state.current as NavEntriesStructure.Back).back(stepsBack = 1)) {
                    "Can't go back from ${state.current}"
                },
            )
        }
    }
}