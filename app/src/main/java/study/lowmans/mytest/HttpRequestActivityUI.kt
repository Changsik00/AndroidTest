package study.lowmans.mytest

import com.pawegio.kandroid.e
import com.pawegio.kandroid.i
import org.jetbrains.anko.*
import retrofit2.Call

class HttpRequestActivityUI : AnkoComponent<HttpRequestActivity> {

    override fun createView(ui: AnkoContext<HttpRequestActivity>) = with(ui) {
        verticalLayout {
            button("Retrofit Get : ") {
                id = 1
                try {
                    val service = APIService.retrofitIntance().create(APIService.GitHub::class.java)
                    val call: Call<List<APIService.Contributor>> = service.contributors("square", "retrofit")
                    async() {
                        var response = call.execute()
                        val raw = response.raw()
                        if (response.isSuccess) {
                            val list = response.body();

                            for (item in list) {
                                i("#@#","item  ${item.login} / ${item.contributions}")
                            }
                        } else {
                            i("#@#","failure")
                        }
                        i("#@#", "raw : $raw ")
                    }

                } catch  (e: Exception) {
                    e("#@#", "error : ${e.toString()}")
                }
            }
            button("Fuel Get : ") {
                id = 2
            }.lparams(width = matchParent) { topMargin = dip(10) }
        }
    }

}