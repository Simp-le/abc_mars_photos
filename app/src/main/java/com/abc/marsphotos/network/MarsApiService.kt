package com.abc.marsphotos.network

import com.abc.marsphotos.model.MarsPhoto
import retrofit2.http.GET

/**
 * A public interface that exposes the [getPhotos] method
 */
interface MarsApiService {

    /*
     * Use the @GET annotation to tell Retrofit that this is a GET
     * request and specify an endpoint for that web service method.
     *
     * When the getPhotos() method is invoked, Retrofit appends the
     * endpoint photos to the base URL used to start the request.
     */
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}




/*
 * Warning: Singleton pattern is not a recommended practice. Singletons represent global states that
 * are hard to predict, particularly in tests. Objects should define which dependencies they need,
 * instead of describing how to create them.
 *
 * Use Dependency injection over singleton pattern, you will learn how to implement
 * Dependency injection in a later codelab.
 */

/*
 * Retrofit service.
 *
 * The call to create() function on a Retrofit object is expensive in terms of memory, speed,
 * and performance. The app needs only one instance of the Retrofit API service, so you expose
 * the service to the rest of the app using object declaration.
 *
 * This object is the public singleton object that the rest of the app can access.
 */

/*
 * A public Api object that exposes the lazy-initialized Retrofit service.
 *
 * WE REPLACED IT WITH DEPENDENCY INJECTION. SEE AppContainer.kt FILE AND ABOVE WARNING.
 *
 * object MarsApi {
 *     // A lazily initialized retrofit object property.
 *     // Remember "lazy initialization" is when object creation is purposely delayed, until you
 *     // actually need that object, to avoid unnecessary computation or use of other computing resources.
 *     val retrofitService: MarsApiService by lazy {
 *         retrofit.create(MarsApiService::class.java)
 *     }
 * }
 */
