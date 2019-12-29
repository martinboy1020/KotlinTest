package example.com.kotlintest.interfacce

import example.com.kotlintest.bean.UsersList
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    //urls
    @get:GET("users?q=rokano")
    val users: Call<UsersList>
}

//public interface Api {
//    //urls
//    @GET("users?q=rokano")
//    Call<UsersList> getUsers();
//}