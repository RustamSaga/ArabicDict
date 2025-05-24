package dev.arabicdictionary.pro.navstate

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

public sealed interface NavStructure {
    public val id: Id

    public val parent: NavStructure?
        get() = null

    public operator fun contains(structure: NavStructure): Boolean =
        when {
            this === structure -> true
            this is ListNavStructure -> structures.any { structure in it }
            else -> false
        }

    public fun validate()

    @JvmInline
    @Serializable
    public value class Id(
        public val id: String,
    ) {
        init {
            check(id.isNotBlank())
        }
    }
}

public operator fun NavStructure.contains(entry: NavEntry): Boolean =
    when (this) {
        is ListNavStructure -> structures.any { entry in it }
        is NavEntriesStructure -> contains(entry)
    }

public operator fun NavStructure.get(id: NavStructure.Id): NavStructure? =
    when {
        this.id == id -> this
        this is ListNavStructure -> get(id)
        else -> null
    }