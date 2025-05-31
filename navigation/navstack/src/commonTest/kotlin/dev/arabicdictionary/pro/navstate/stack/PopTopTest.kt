package dev.arabicdictionary.pro.navstate.stack

import kotlin.test.Test

class PopTopTest {
    @Test
    fun `popTop works correctly`() {
//        val initialState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(TestNavDestinations.Root)
//                        add(TestNavDestinations.DataList)
//                        add(TestNavDestinations.Details("testId"))
//                    },
//                    setCurrent = true,
//                )
//            }

//        val navigator = Navigator(initialState)
//        navigator.enqueue(NavCommand.popTop())

//        val expectedState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(TestNavDestinations.Root)
//                        add(TestNavDestinations.DataList)
//                    },
//                    setCurrent = true,
//                )
//            }
//        assertEquals(expectedState, navigator.currentState)
    }

    @Test
    fun `popTop single entry in root has no effect`() {
//        val initialState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(NavEntry(TestNavDestinations.Root))
//                    },
//                    setCurrent = true,
//                )
//            }

//        val navigator = Navigator(initialState)
//        navigator.enqueue(NavCommand.popTop(count = 1))

//        val expectedState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(NavEntry(TestNavDestinations.Root))
//                    },
//                    setCurrent = true,
//                )
//            }
//        assertEquals(expectedState, navigator.currentState)
    }

    @Test
    fun `After popTop 2 entries in 2 entry Stack root entry remains`() {
//        val initialState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(NavEntry(TestNavDestinations.Root))
//                        add(NavEntry(TestNavDestinations.DataList))
//                    },
//                    setCurrent = true,
//                )
//            }

//        val navigator = Navigator(initialState)
//        navigator.enqueue(NavCommand.popTop(count = 2))

//        val expectedState =
//            buildNavState {
//                add(
//                    buildNavStack(id = NAV_STACK_DEFAULT) {
//                        add(NavEntry(TestNavDestinations.Root))
//                    },
//                    setCurrent = true,
//                )
//            }
//        assertEquals(expectedState, navigator.currentState)
    }
}
