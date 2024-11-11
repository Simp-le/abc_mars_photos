package com.abc.marsphotos

import com.abc.marsphotos.data.NetworkMarsPhotosRepository
import com.abc.marsphotos.fake.FakeDataSource
import com.abc.marsphotos.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest {
        // We're running this test in a runTest() function to use coroutines calls
        val repository = NetworkMarsPhotosRepository(marsApiService = FakeMarsApiService())

        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}