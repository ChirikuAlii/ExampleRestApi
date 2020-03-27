package info.chirikualii.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val baseApp =BaseApp()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        baseApp.getApiService()
            .getTopheadline(
                country = "us",
                key = "452a8b968c514facb39fd8fff27381bb"
            )
            .enqueue(object : Callback<TopheadlineResponse>{
                override fun onFailure(call: Call<TopheadlineResponse>, t: Throwable) {
                    Log.e("MainActivity,","error list news : ${t.message}")
                }

                override fun onResponse(
                    call: Call<TopheadlineResponse>,
                    response: Response<TopheadlineResponse>
                ) {
                    runOnUiThread {
                        //adapter
                        tv_title.text = response.body()!!.articles[0].title
                    }
                    Log.d("MainActivity","list news ${Gson().toJsonTree(response.body()?.articles)}")
                }

            })

    }
}
