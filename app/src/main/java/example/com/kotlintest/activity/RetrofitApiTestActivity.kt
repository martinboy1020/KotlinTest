package example.com.kotlintest.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import example.com.kotlintest.R
import example.com.kotlintest.bean.UsersList
import example.com.kotlintest.interfacce.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiTestActivity : AppCompatActivity() {
    val BASE_URL = "https://api.github.com/search/"
    var tv_user: TextView? = null
    var str:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        tv_user = findViewById(R.id.tv_users)
        getUsers()
    }

    fun getUsers() {

        var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var api = retrofit.create(Api::class.java)

        var call = api.users

        call.enqueue(object : Callback<UsersList> {

            override fun onResponse(call: Call<UsersList>?, response: Response<UsersList>?) {
                Log.d("res wrapped in gson", Gson().toJson(response))
                Log.d("pretty printed gson", GsonBuilder().setPrettyPrinting().create().toJson(response))
                var usres = response?.body()
                var user = usres?.users
                var length = user!!.size

                for (i in 0 until length) {
                    str = str + "\n" + user.get(i).id + " " + user.get(i).login
                }

                tv_user!!.text = str
            }

            override fun onFailure(call: Call<UsersList>?, t: Throwable?) {
                Log.v("Error", t.toString())
            }
        })
    }
}