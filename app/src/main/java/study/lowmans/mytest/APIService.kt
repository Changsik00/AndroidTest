package study.lowmans.mytest

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call

class APIService {
    interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        fun contributors(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<APIData.Contributor>>
    }

    interface MyApi {
        @GET("/test.php")
        fun test (@Query("id") id: Int) :Call<APIData.Test>
    }
}