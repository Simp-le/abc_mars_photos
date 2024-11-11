package com.abc.marsphotos.rules

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/*
 * The TestWatcher class enables to take actions on different execution phases of a test.
 *
 * The UnconfinedTestDispatcher class inherits from the TestDispatcher class and it specifies that
 * tasks must not be executed in any particular order. This pattern of execution is good for simple
 * tests as coroutines are handled automatically. Unlike UnconfinedTestDispatcher, the
 * StandardTestDispatcher class enables full control over coroutine execution.
 * This way is preferable for complicated tests that require a manual approach.
 *
 * The primary goal of this test rule is to replace the Main dispatcher with a test dispatcher
 * before a test begins to execute.
 */
@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatcherRule(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {

    override fun starting(description: Description) = Dispatchers.setMain(testDispatcher)
    override fun finished(description: Description) = Dispatchers.resetMain()
}