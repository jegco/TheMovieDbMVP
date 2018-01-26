package com.example.jorge_caro.daggertest.moviesCollection.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result (var id: Int? = null, var title: String? = null,
              @SerializedName("poster_path") @Expose var posterPath: String? = null)

