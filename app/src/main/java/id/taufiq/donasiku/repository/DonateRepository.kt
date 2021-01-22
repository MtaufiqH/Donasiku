package id.taufiq.donasiku.repository

import id.taufiq.donasiku.data.db.DonationDao
import id.taufiq.donasiku.data.network.response.DonasiItem

/**
 * Created By Taufiq on 1/22/2021.
 *
 */
class DonateRepository(private val donateDao: DonationDao) {
    val getAllDonation = donateDao.getAllDonation()

    suspend fun insertDonate(donate: DonasiItem){
        donateDao.insertDonation(donate)
    }
}