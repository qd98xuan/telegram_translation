package http

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpServer {
    companion object{
        var apiService:ApiService?=null
        fun getInstance():ApiService{
            if (apiService!=null){
                return apiService!!
            }
            val retrofit = Retrofit.Builder()
                .baseUrl("http://translate.google.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService = retrofit.create(ApiService::class.java)
            return apiService
        }
    }
}