package dev.arabicdictionary.pro.navstate.stack

import dev.arabicdictionary.pro.navstate.NavDest
import dev.arabicdictionary.pro.navstate.NavEntriesStructure
import dev.arabicdictionary.pro.navstate.NavEntry
import dev.arabicdictionary.pro.navstate.NavStructure
import kotlinx.serialization.Serializable

@Serializable
public data class NavStack(
    override val id: NavStructure.Id,
    override val entries: List<NavEntry>,
    override val parent: NavStructure? = null,
) : NavEntriesStructure,
    NavEntriesStructure.Forward,
    NavEntriesStructure.Back,
    Iterable<NavEntry> by entries.reversed() {
    override val current: NavEntry
        get() = entries.last()

    override fun forward(
        entry: NavEntry,
        tags: List<Any>,
    ): NavEntriesStructure {
        check(entry !in entries) {
            "Entry already exists in the stack $this"
        }
        return NavStack(id, entries + entry, parent)
    }

    override fun back(stepsBack: Int): NavEntriesStructure? {
        require(stepsBack > 0) {
            "Steps count must be greater than 0"
        }
        check(entries.isNotEmpty())
        if (entries.size == 1) return null
        return NavStack(id, entries.subList(0, (entries.size - stepsBack).coerceAtLeast(0)), parent)
    }

    override fun validate() {
        check(entries.isNotEmpty()) {
            "NavStack must have at least one NavEntry"
        }
    }

    override fun copy(entries: List<NavEntry>): NavStack = copy(id = id, entries = entries, parent = parent)
}

public fun NavStack(
    id: NavStructure.Id,
    entry: NavEntry,
    parent: NavStructure? = null,
): NavStack = NavStack(id, listOf(entry), parent)

public class NavStackBuilder
    @PublishedApi
    internal constructor(
        @PublishedApi internal val id: NavStructure.Id,
        entries: List<NavEntry>,
    ) {
        @PublishedApi
        internal val entries: MutableList<NavEntry> = entries.toMutableList()

        public fun add(entry: NavEntry): NavStackBuilder =
            apply {
                entries += entry
            }

        public fun add(vararg entries: NavEntry): NavStackBuilder =
            apply {
                this.entries += entries
            }

        public fun addAll(entries: Iterable<NavEntry>): NavStackBuilder =
            apply {
                this.entries += entries
            }

        public fun add(
            dest: NavDest,
            tags: List<Any> = emptyList(),
        ): NavStackBuilder =
            apply {
                add(NavEntry(dest, tags))
            }
    }

public inline fun buildNavStack(
    id: NavStructure.Id,
    body: NavStackBuilder.() -> Unit,
): NavStack =
    NavStackBuilder(id, entries = emptyList())
        .apply(body)
        .let { builder -> NavStack(builder.id, builder.entries.toList()) }
