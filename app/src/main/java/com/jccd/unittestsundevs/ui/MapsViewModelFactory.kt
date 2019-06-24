package com.jccd.unittestsundevs.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jccd.unittestsundevs.net.repository.MapsRepository

class MapsViewModelFactory(private val repository: MapsRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MapsViewModel::class.java!!)) {
                MapsViewModel(this.repository) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
}