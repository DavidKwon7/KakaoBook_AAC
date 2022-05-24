package com.example.aac_paging_dddd.ui.feature.main

import android.app.Application
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.example.aac_paging_dddd.data.bookModel.BookModel
import com.example.aac_paging_dddd.data.model.User
import com.example.aac_paging_dddd.data.remote.paging.GithubPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GithubPagingRepository
) : ViewModel() {

    private var _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun getRemoteUser(): Flowable<PagingData<BookModel.Document>> {
        return repository.getRemoteUser("love")
            .map { pagingData ->
                pagingData.filter { true }
            }.cachedIn(viewModelScope)
    }

    fun clickFavorite() {
        _isFavorite.value?.let {
            _isFavorite.value = it
        }
    }

}

