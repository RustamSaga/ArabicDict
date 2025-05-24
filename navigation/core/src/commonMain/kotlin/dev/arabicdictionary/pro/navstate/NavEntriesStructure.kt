package dev.arabicdictionary.pro.navstate

public interface NavEntriesStructure :
    NavStructure,
    Iterable<NavEntry> {
    public val entries: List<NavEntry>
    public val current: NavEntry

    public operator fun contains(entry: NavEntry): Boolean = entry in entries

    public fun copy(entries: List<NavEntry>): NavEntriesStructure

    public interface Forward : NavEntriesStructure {
        public fun forward(
            entry: NavEntry,
            tags: List<Any> = emptyList(),
        ): NavEntriesStructure
    }

    public interface Back : NavEntriesStructure {
        public fun back(stepsBack: Int = 1): NavEntriesStructure?
    }
}