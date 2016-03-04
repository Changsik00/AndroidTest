package study.lowmans.mytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import org.jetbrains.anko.*

// https://github.com/Kotlin/anko
class AnkoDSLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainView = AnkoDSLActivityUI().setContentView(this)
        var editText = mainView.find<EditText>(1)
        editText.setText("test")
    }
}
