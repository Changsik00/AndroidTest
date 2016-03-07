package study.lowmans.mytest

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var _listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = MainListAdpater(this);
        _listView = listView

    }

    class MainListAdpater(context: Context) : BaseAdapter() {

        var context: Context
        var titleArray: Array<String>
        var activityArray: Array<Class<*>>

        init {
            titleArray = arrayOf(
                    "Anko DSL",
                    "Http Request"
            )

            activityArray = arrayOf(
                    AnkoDSLActivity::class.java,
                    HttpRequestActivity::class.java
            )

            this.context = context
        }

        override fun getCount(): Int {
            return titleArray.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var view = convertView
            if (view == null) {
                view = TextView(context)
                view.gravity = Gravity.CENTER
                view.textSize = 25f
                view.setBackgroundResource(R.drawable.ripple)
                view.setPadding(0, 50, 0, 50)
            } else {
                view as TextView
            }

            view.text = titleArray.get(position)
            view.setOnClickListener() {
                context.startActivity(Intent(context, activityArray.get(position)))

            }

            return view
        }

        override fun getItem(p0: Int): Any? {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }
    }
}
