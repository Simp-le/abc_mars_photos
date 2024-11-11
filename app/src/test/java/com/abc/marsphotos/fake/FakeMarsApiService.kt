package com.abc.marsphotos.fake

import com.abc.marsphotos.model.MarsPhoto
import com.abc.marsphotos.network.MarsApiService

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}