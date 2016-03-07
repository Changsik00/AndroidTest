package study.lowmans.mytest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.find
import org.jetbrains.anko.onClick
import org.jetbrains.anko.setContentView

class HttpRequestActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainView = HttpRequestActivityUI().setContentView(this)
//        mainView.find<Button>(1).setOnClickListener(this)
//        mainView.find<Button>(2).setOnClickListener(this)

    }

    override fun onClick(view: View?) {

    }
}