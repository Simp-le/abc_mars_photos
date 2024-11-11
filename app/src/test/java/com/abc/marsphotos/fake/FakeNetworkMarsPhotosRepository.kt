package com.abc.marsphotos.fake

import com.abc.marsphotos.data.MarsPhotosRepository
import com.abc.marsphotos.model.MarsPhoto

class FakeNetworkMarsPhotosRepository: MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> = FakeDataSource.photosList
}