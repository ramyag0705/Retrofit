package com.example.retrofit.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(var name: String? = null,
                      var realname: String? = null,
                      var team: String? = null,
                      var firstappearance: String? = null,
                      var createdby: String? = null,
                      var publisher: String? = null,
                      var imageurl: String? = null,
                      var bio: String? = null) : Parcelable {
}

