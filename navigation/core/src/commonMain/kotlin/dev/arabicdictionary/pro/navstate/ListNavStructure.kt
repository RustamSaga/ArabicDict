package dev.arabicdictionary.pro.navstate

public interface ListNavStructure :
    NavStructure,
    Iterable<NavEntriesStructure> {
    public val structures: List<NavEntriesStructure>
    public val current: NavStructure?

    public operator fun get(id: NavStructure.Id): NavEntriesStructure?
}

public open class NavGroup(
    override val id: NavStructure.Id,
    public override val structures: List<NavEntriesStructure>,
) : ListNavStructure,
    Iterable<NavEntriesStructure> by structures {
    override val current: NavStructure? = null

    public override operator fun get(id: NavStructure.Id): NavEntriesStructure? =
        structures.find { structure -> structure.id == id }

    override fun validate() {
        check(structures.isNotEmpty()) { "Must have at least one NavStructure" }
    }
}
