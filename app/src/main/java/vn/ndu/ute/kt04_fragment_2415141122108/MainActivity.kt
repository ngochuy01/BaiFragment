package vn.ndu.ute.kt04_fragment_2415141122108

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khi mở lần đầu hiển thị NhapVeFragment; khi Activity được tạo lại không chèn thêm Fragment đầu
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, NhapVeFragment())
                .commit()
        }

        // Lắng nghe kết quả trả về từ NhapVeFragment
        supportFragmentManager.setFragmentResultListener("requestKey_ve", this) { _, bundle ->
            val xacNhanFragment = XacNhanFragment.newInstance(bundle)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, xacNhanFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    fun chuyenSangXacNhanFragment() {
        // Việc chuyển đổi được điều phối qua listener của Fragment Result API phía trên
    }
}