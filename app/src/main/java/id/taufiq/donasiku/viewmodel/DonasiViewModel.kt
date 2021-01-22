package id.taufiq.donasiku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.taufiq.donasiku.data.network.response.builder.myDonations
import id.taufiq.donasiku.data.network.response.DonasiItem
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created By Taufiq on 1/20/2021.
 *
 */
class DonasiViewModel : ViewModel() {
    private val TAG = "DonasiViewModel"

    private val _allDonations = MutableLiveData<List<DonasiItem>>()
    val allDonations: LiveData<List<DonasiItem>>
        get() = _allDonations

    init {
        getAllDonation()
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

}