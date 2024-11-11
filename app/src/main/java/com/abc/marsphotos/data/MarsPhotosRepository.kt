package com.abc.marsphotos.data

import com.abc.marsphotos.model.MarsPhoto
import com.abc.marsphotos.network.MarsApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface MarsPhotosRepository {
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkMarsPhotosRepository(private val marsApiService: MarsApiService): MarsPhotosRepository {

    // DEPRECATED: Use the singleton object MarsApi to call the getPhotos() method from the retrofitService interface.
    // NOW: We use retrofitService implementing MarsApiService with the getPhotos() method.
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getMarsPhotos(): List<MarsPhoto> = marsApiService.getPhotos()
}