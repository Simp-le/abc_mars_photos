package com.abc.marsphotos

import com.abc.marsphotos.fake.FakeDataSource
import com.abc.marsphotos.fake.FakeNetworkMarsPhotosRepository
import com.abc.marsphotos.rules.TestDispatcherRule
import com.abc.marsphotos.ui.screens.MarsUiState
import com.abc.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
        /*
         * runTest() method to ensure that the test is run from a coroutine.
         *
         * The TestDispatcher needs to be used instead of the Main dispatcher for any unit test in
         * which a new coroutine is made, as is the case with the getMarsPhotos() function from
         * the view model.
         */

        val marsViewModel = MarsViewModel(marsPhotosRepository = FakeNetworkMarsPhotosRepository())

        assertEquals(
            MarsUiState.Success(FakeDataSource.photosList),
            marsViewModel.marsUiState
        )
    }
}