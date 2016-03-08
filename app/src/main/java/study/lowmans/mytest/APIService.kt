package study.lowmans.mytest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

class APIService {
    interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        fun contributors(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<APIData.Contributor>>
    }
}