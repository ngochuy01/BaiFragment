package vn.ndu.ute.kt04_fragment_2415141122108
fun String.chuanHoanAten_2108(): String {
    return this.trim().replace(Regex("\\s+"), " ")
}
object QuyTacPhieu_2108 {
    private var counter = 1
    fun taomaPhieu_2108(soThuTu: Int): String {
        return "VE$soThuTu"
    }
    fun taoMaTuDong(): String {
        return "VE${counter++}"
    }
}