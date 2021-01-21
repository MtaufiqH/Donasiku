package id.taufiq.donasiku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.taufiq.donasiku.data.builder.myDonations
import id.taufiq.donasiku.data.response.DonasiItem
import kotlinx.coroutines.launch

/**
 * Created By Taufiq on 1/20/2021.
 *
 */
class DonasiViewModel : ViewModel() {

    private val _allDonations = MutableLiveData<List<DonasiItem>>()
    val allDonations : LiveData<List<DonasiItem>>
    get() = _allDonations

    init {
        getAllDonation()
    }

    private fun getAllDonation(){
        viewModelScope.launch {
            val response = myDonations.donationService.getAllDonasi()
            if (response.isSuccessful){
                _allDonations.value = response.body()
            } else {
                Log.i("GET ALL DONATION : ", response.message().toString())
            }
        }
    }

}