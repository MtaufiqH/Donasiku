package id.taufiq.donasiku.data.builder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created By Taufiq on 1/20/2021.
 *
 */


private const val BASE_URL = "http://api.skydu.cloud:8000/"


val logging = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

val client = OkHttpClient.Builder().run {
    addInterceptor(logging).build()
}


val retrofitInstance = Retrofit.Builder().run {
    addConverterFactory(GsonConverterFactory.create())
    baseUrl(BASE_URL)
    client(client)
    build()
}


object myDonations {
    val donationService: DonasiRequest by lazy {
        retrofitInstance.create(DonasiRequest::class.java)
    }

}