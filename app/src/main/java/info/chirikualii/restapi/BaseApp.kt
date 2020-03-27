package info.chirikualii.restapi

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseApp :Application() {



    companion object {
        lateinit var retrofit :Retrofit
    }


    override fun onCreate() {
        super.onCreate()

        retrofit =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/v2/")
            .build()
    }

    fun getApiService() = retrofit.create(ApiService::class.java)

}