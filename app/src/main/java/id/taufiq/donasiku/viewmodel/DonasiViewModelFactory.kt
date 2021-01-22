package id.taufiq.donasiku.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created By Taufiq on 1/22/2021.
 *
 */


class DonasiViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DonasiViewModel::class.java)) {
            return DonasiViewModel(application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class!")
    }

}