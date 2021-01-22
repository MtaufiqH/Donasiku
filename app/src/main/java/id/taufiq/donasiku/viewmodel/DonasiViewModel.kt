package id.taufiq.donasiku.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.taufiq.donasiku.data.db.DonationDb
import id.taufiq.donasiku.data.db.DonationEntity
import id.taufiq.donasiku.data.network.response.builder.myDonations
import id.taufiq.donasiku.data.network.response.DonasiItem
import id.taufiq.donasiku.repository.DonateRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created By Taufiq on 1/20/2021.
 *
 */
class DonasiViewModel(application: Application): ViewModel() {
    private val TAG = "DonasiViewModel"

    private val donateDao = DonationDb.getInstance(application).donateDao()
    private val repo : DonateRepository

    private val _allDonations = MutableLiveData<List<DonasiItem>>()
    val allDonations: LiveData<List<DonasiItem>>
        get() = _allDonations

    var allDonate: LiveData<List<DonationEntity>>

    init {
        getAllDonation()
        repo = DonateRepository(donateDao)
        allDonate = repo.getAllDonation
    }

    private fun getAllDonation() {
        viewModelScope.launch {
            try {
                val response = myDonations.donationService.getAllDonasi()
                if (response.isSuccessful) {
                    _allDonations.value = response.body()
                } else {
                    Log.i("GET ALL DONATION : ", response.message().toString())
                }
            } catch (e: HttpException) {
                Log.d(TAG, "getAllDonation: $e ")
            }

        }
    }


    fun insertDonation(donate: DonationEntity){
        viewModelScope.launch {
            repo.insertDonate(donate)
        }
    }

}