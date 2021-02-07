package http

import entry.GoogleTranslation
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=zh_TW&q=calculate
    @GET(value = "http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto")
    fun getTranslation(@Query("q") q:String, @Query("tl")tl:String):Call<GoogleTranslation>
}