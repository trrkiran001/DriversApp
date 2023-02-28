package com.tirupati.network

import com.google.gson.GsonBuilder
import com.tirupati.repo.DriversRepository
import com.tirupati.repo.DriversRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 * Networking module that builds retrofit instance and creates DriversApi to the clients.
 */
@Module
class NetworkModule {

    @Provides
    fun providesApiService(): DriversApi {
        val retrofit = buildRetrofitInstance()
        return retrofit.create(DriversApi::class.java)
    }


    @Singleton
    @Provides
    fun provideDriversRepository(service: DriversApi): DriversRepository = DriversRepositoryImpl(service)
    private fun buildRetrofitInstance(): Retrofit {

        //com.google.gson.stream.MalformedJsonException: Use JsonReader.setLenient(true) to accept malformed JSON at line 1
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder().baseUrl("https://da7749d7-3e59-4c5b-a532-40aa696b5371.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}