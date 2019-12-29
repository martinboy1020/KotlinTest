package example.com.kotlintest.activity

import android.database.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import example.com.kotlintest.R
import example.com.kotlintest.WeatherBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class NetApiActivity : AppCompatActivity() {

    var toolbar : Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        toolbar = findViewById(R.id.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        initData()
//        val retroFitApiService = RetroFitApiService.create()
//        retroFitApiService.search("CWB-A48AE0AD-CEDE-41B0-A7C1-FF9F8A71812D", 1)
    }

}

private fun initData() {
    val retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")  //注意这里必须以/结尾不然报错
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val ipService = retrofit.create(OldRetroFitApiService::class.java)

    ipService.search("afbb82fe3bf640ee3b9d7e72bc716b93", "Taiwan").enqueue(object : Callback<WeatherBean> {
        override fun onResponse(call: Call<WeatherBean>?, response: Response<WeatherBean>?) {
            Log.d("res wrapped in gson", Gson().toJson(response))
            Log.d("pretty printed gson", GsonBuilder().setPrettyPrinting().create().toJson(response))
            //成功
            Log.d("tag1", "Api Success, response: " + response!!.body().toString())
            var weatherBean: WeatherBean? = response!!.body()
            Log.d("tag1", "Api Success, weatherBean: " + weatherBean.toString())
            Log.d("tag1", "weatherBean.base: " + weatherBean?.base)
            var weatherCoord: WeatherBean.coord = weatherBean!!.coordObject
            var weatherList : List<WeatherBean.weather> = weatherBean!!.weatherList

            Log.d("tag1", "weatherCoord: " + weatherCoord)
            Log.d("tag1", "weatherList: " + weatherList)

//            Log.d("tag1", "weatherCoord lat: " + weatherCoord.lat + " weatherCoord lon:" + weatherCoord.lon)
            for(weather in weatherList) {
                Log.d("tag1", "weather data: " + weather.data)
            }

        }

        override fun onFailure(call: Call<WeatherBean>?, t: Throwable?) {
            //失败
            Log.d("tag1", "Api Fail")
        }
    })

}

interface OldRetroFitApiService {
    @GET("data/2.5/weather")
    fun search(@Query("appid") appid: String,
               @Query("q") location: String): Call<WeatherBean>
}

interface RetroFitApiService {

    @GET("data/2.5/weather")
    fun search(@Query("Authorization") authorization: String,
               @Query("limit") limit: Int): Observable<WeatherBean>

    // companion object => Java Static
    companion object {

        fun create(): RetroFitApiService {

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("https://api.openweathermap.org/")
                    .build()

            return retrofit.create(RetroFitApiService::class.java)

        }

    }

}