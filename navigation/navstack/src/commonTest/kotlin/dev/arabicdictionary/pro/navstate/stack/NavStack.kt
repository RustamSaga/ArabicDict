package dev.arabicdictionary.pro.navstate.stack

import dev.arabicdictionary.pro.navstate.NavEntry
import dev.arabicdictionary.pro.navstate.NavState
import dev.arabicdictionary.pro.navstate.NavStructure
import kotlin.test.Test
import kotlin.test.assertEquals

private val NAV_STACK_DEFAULT = NavStructure.Id("default")

class NavStateTest {
    @Test
    fun buildNavState() {
        val actual = dev.arabicdictionary.pro.navstate.buildNavState {
            add(
                buildNavStack(id = NAV_STACK_DEFAULT) {
                    add(NavEntry(TestNavDestinations.Root))
                },
                setCurrent = true,

                )
        }

        val stack = NavStack(id = NAV_STACK_DEFAULT, entries = listOf(NavEntry(TestNavDestinations.Root)))
        val expected = NavState(
            structures = setOf(stack),
            currentId = stack.id,
        )

        assertEquals(expected, actual)
    }
}