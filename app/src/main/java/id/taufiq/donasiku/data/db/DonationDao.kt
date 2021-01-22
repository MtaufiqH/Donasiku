package id.taufiq.donasiku.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import id.taufiq.donasiku.data.network.response.DonasiItem

/**
 * Created By Taufiq on 1/22/2021.
 *
 */

@Dao
interface DonationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonation(donate: DonasiItem)

    @Query("SELECT * FROM donation_table")
    fun getAllDonation(): LiveData<List<DonasiItem>>

    @Query("DELETE FROM donation_table")
    suspend fun deleteAllHistory()
}