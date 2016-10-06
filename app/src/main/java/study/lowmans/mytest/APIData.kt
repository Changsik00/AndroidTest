package study.lowmans.mytest

import java.sql.Date

class APIData {
    data class Contributor(val login: String = "", val contributions: Int = -1)
    data class Data(val id: Int, val title: String, val description: String, val created: String)
    data class Test(val result: Boolean, val message: String, val data: Data)
}
