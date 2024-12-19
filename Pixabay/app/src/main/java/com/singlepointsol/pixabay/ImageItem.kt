package com.singlepointsol.pixabay

data class ImageItem(val id: Int,
                     val webformatURL: String,  // Image URL for the image in web format
                     val user: String,          // Username who uploaded the image
                     val tags: String,          // Tags associated with the image
                     val largeImageURL: String )
