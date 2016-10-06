package study.lowmans.mytest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.setContentView

class HttpRequestActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainView = HttpRequestActivityUI(124).setContentView(this)
        //        mainView.find<Button>(1).setOnClickListener(this)
        //        mainView.find<Button>(2).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            1 -> {
            }

            2 -> {
            }
        }
    }
}