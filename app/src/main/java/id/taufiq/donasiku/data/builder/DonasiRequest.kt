package id.taufiq.donasiku.data.builder

import id.taufiq.donasiku.data.response.DonasiItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created By Taufiq on 1/20/2021.
 *
 */
interface DonasiRequest {

    @GET("donasi")
    suspend fun getAllDonasi(): Response<List<DonasiItem>>
}