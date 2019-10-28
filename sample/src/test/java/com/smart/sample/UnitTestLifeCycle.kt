package com.smart.sample

import org.junit.*

class UnitTestLifeCycle {

    @Before
    fun setUp() {
        println("TrendViewModelTestMock.setUp")
    }

    @Before
    fun setUp2() {
        println("TrendViewModelTestMock.setUp2")
    }

    @After
    fun tearDown() {
        println("TrendViewModelTestMock.tearDown")
    }

    @After
    fun tearDown2() {
        println("TrendViewModelTestMock.tearDown2")
    }

    @Test
    fun get() {
        println("TrendViewModelTestMock.get")
    }

    @Test
    fun call() {
        println("TrendViewModelTestMock.call")
    }

    companion object {

        @BeforeClass
        @JvmStatic
        fun init() {
            println("TrendViewModelTestMock.init")
        }

        @AfterClass
        @JvmStatic
        fun finalized() {
            println("TrendViewModelTestMock.finalize")
        }
    }
}
