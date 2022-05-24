package com.example.aac_paging_dddd.ui.feature.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun getLiveData() {
        _isFavorite.value?.let {
            _isFavorite.value = it
        }
        _isFavorite.value = true
    }

    fun setLiveData() {
        _isFavorite.postValue(false)
    }
}