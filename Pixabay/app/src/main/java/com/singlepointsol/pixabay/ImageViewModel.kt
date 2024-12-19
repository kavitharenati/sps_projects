package com.singlepointsol.pixabay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    private val _images = MutableLiveData<List<ImageItem>>()
    val images: LiveData<List<ImageItem>> get() = _images

    fun fetchImages(query: String) {
        viewModelScope.launch {
            val response = RetrofitClient.service.getImages("YOUR_PIXABAY_API_KEY", query)
            _images.postValue(response.hits)
        }
    }
}
