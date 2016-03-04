package study.lowmans.mytest

import org.jetbrains.anko.*

class AnkoDSLActivityUI : AnkoComponent<AnkoDSLActivity> {

    val nameId = 1
    val buttonId = 2


    override fun createView(ui: AnkoContext<AnkoDSLActivity>) = with(ui) {
        verticalLayout {
            val name = editText() {
                id = nameId
            }
            button("Say Hello") {
                id = buttonId
                onClick { ctx.toast("Hello, ${name.text}!") }
            }

            button("Say Hello") {
                id = buttonId
                onClick { ctx.toast("Hello, ${name.text}!") }
            }.lparams(width = matchParent) { margin = dip(12) }
        }
    }
}