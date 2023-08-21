package com.example.retrofit.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.Common.Common
import com.example.retrofit.Model.MovieModel
import com.example.retrofit.Network.APIService
import com.example.retrofit.Repositories.MainRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val mainRepo: MainRepo

    private var _getMovieList = MutableLiveData<List<MovieModel>>()
    var getMovieList: LiveData<List<MovieModel>> = _getMovieList

    private val apiService: APIService

    companion object{
        private const val TAG = "MainRepo"
    }

    init{
        apiService = Common.getAPIService
    }


    init {
        mainRepo = MainRepo()
    }

    fun getMovieModelLiveData(){

            apiService.getMovieList().enqueue(object : Callback<MutableList<MovieModel>> {
                override fun onResponse(
                    call: Call<MutableList<MovieModel>>,
                    response: Response<MutableList<MovieModel>>
                ) {
                    //Log.e(MainRepo.TAG,"onResponse: " + response.code())
                    if(response.isSuccessful){
                        _getMovieList.value = response.body()
                        Log.d(response.toString(), "onResponse: ")
                    }
                    else
                    {

                    }
                }

                override fun onFailure(call: Call<MutableList<MovieModel>>, t: Throwable) {
                    /*Log.e(MainRepo.TAG,"onResponse: " + t.message)
                    data.value = null*/
                }
            })

        }


}