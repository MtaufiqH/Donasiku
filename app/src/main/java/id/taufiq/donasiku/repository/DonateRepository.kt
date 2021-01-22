package id.taufiq.donasiku.repository

import id.taufiq.donasiku.data.db.DonationDao
import id.taufiq.donasiku.data.db.DonationEntity

/**
 * Created By Taufiq on 1/22/2021.
 *
 */
class DonateRepository(private val donateDao: DonationDao) {
    val getAllDonation = donateDao.getAllDonation()

    suspend fun insertDonate(donate: DonationEntity){
        donateDao.insertDonation(donate)
    }
}