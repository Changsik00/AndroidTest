package study.lowmans.mytest

import android.widget.Button
import com.github.kittinunf.fuel.core.Manager
import com.github.kittinunf.fuel.httpGet

import com.pawegio.kandroid.e
import com.pawegio.kandroid.i
import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpRequestActivityUI : AnkoComponent<HttpRequestActivity> {

    var retrofitButton: Button? = null
    var test: Int

    constructor(test: Int) {
        this.test = test
    }

    override fun createView(ui: AnkoContext<HttpRequestActivity>) = with(ui) {
        verticalLayout {
            retrofitButton = button("Retrofit Get : ") {
                id = test
                onClick {
                    i("#@#", "Retrofit")
                    requestWithRetrofit(retrofitButton)
                }

                requestWithRetrofit()
            }
            button("Fuel Get : ") {
                id = 2
                onClick {
                    i("#@#", "Fuel")
                    requestWithFuel(retrofitButton)
                }
            }.lparams(width = matchParent) { topMargin = dip(10) }

            button("My Api Test : ") {
                id = 3
                onClick {
                    i("#@#", "My Api")
                    myApiTest()
                }
            }.lparams(width = matchParent) { topMargin = dip(10) }
        }
    }


    fun requestWithRetrofit(button: Button? = null) {
        if (button != null) {
            button.text = "onClick"
        }

        try {
            val API_URL = "https://api.github.com"
            val retrofit = Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build()

            val service = retrofit.create(APIService.GitHub::class.java)
            val call: Call<List<APIData.Contributor>> = service.contributors("square", "retrofit")
            call.enqueue(object : Callback<List<APIData.Contributor>> {
                override fun onResponse(call: Call<List<APIData.Contributor>>, response: Response<List<APIData.Contributor>>) {
                    if (response.isSuccess) {
                        val list = response.body();
                        for (item in list) {
                            i("#@#", "item  ${item.login} / ${item.contributions}")
                        }
                    } else {
                        i("#@#", "failure raw : " + response.raw())
                    }
                }

                override fun onFailure(call: Call<List<APIData.Contributor>>, t: Throwable) {
                    i("#@#", "failure error : " + t)
                }
            })
        } catch  (e: Exception) {
            e("#@#", "error : ${e.toString()}")
        }
    }


    fun requestWithFuel(button: Button? = null) {
        //if we set baseURL beforehand, simply use relativePath
        Manager.instance.basePath = "http://httpbin.org"
        "/get".httpGet().responseString { request, response, result ->
            //make a GET to http://httpbin.org/get and do something with response
            val (data, error) = result
            if (error != null) {
                //do something when success
                i("#@#", "error" + error)
            } else {
                //error handling
                i("#@#", "item" + data.toString())
            }
        }
    }

    fun myApiTest() {
        try {
            val API_URL = "https://custom-changsik00.c9users.io:8081"
            val retrofit = Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build()

            val service = retrofit.create(APIService.MyApi::class.java)
            val call: Call<APIData.Test> = service.test(6)
            call.enqueue(object : Callback<APIData.Test> {
                override fun onResponse(call: Call<APIData.Test>, response: Response<APIData.Test>) {
                    if (response.isSuccess) {
                        val test = response.body();
                        i("#@#", "test  ${test}")
                    } else {
                        i("#@#", "failure raw : " + response.raw())
                    }
                }

                override fun onFailure(call: Call<APIData.Test>, t: Throwable) {
                    i("#@#", "failure error : " + t)
                }
            })
        } catch  (e: Exception) {
            e("#@#", "error : ${e.toString()}")
        }
    }
}