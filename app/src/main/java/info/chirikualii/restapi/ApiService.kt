package info.chirikualii.restapi


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface ApiService {

    //get topheadline

    @GET("top-headlines")
    fun getTopheadline(
        @Query("country")
        country :String,

        @Query("apiKey")
        key :String
    ): Call<TopheadlineResponse>

    //452a8b968c514facb39fd8fff27381bb

    //get news in us

}