package study.lowmans.mytest

import android.widget.Button
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

    override fun createView(ui: AnkoContext<HttpRequestActivity>) = with(ui) {
        verticalLayout {
            retrofitButton = button("Retrofit Get : ") {
                id = 1
                onClick {
                    i("#@#", "onClick")
                    requestRetrofit(retrofitButton)
                }

                requestRetrofit()
            }
            button("Fuel Get : ") {
                id = 2
            }.lparams(width = matchParent) { topMargin = dip(10) }
        }
    }


    fun requestRetrofit(button: Button? = null) {

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
}