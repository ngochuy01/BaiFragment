package vn.ndu.ute.kt04_fragment_2415141122108

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.google.android.material.textfield.TextInputEditText
class NhapVeFragment : Fragment() {
    private lateinit var edtHoTen: TextInputEditText
    private lateinit var edtSoLuong: TextInputEditText
    private lateinit var btnXemVe: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nhap_ve, container, false)

        edtHoTen = view.findViewById(R.id.edtHoTen)
        edtSoLuong = view.findViewById(R.id.edtSoLuong)
        btnXemVe = view.findViewById(R.id.btnXemVe)

        btnXemVe.setOnClickListener {
            xemVe_2108()
        }
        return view
    }
    fun xemVe_2108() {
        val rawName = edtHoTen.text.toString()
        val rawSoLuong = edtSoLuong.text.toString()

        val hoTenChuan = rawName.chuanHoanAten_2108()
        if (hoTenChuan.length !in 2..40) {
            edtHoTen.error = "Họ tên phải từ 2 đến 40 ký tự!"
            return
        }
        val nameRegex = Regex("^[a-zA-ZàáảãạăắằẳẵặâấầẩẫậèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵđĐ\\s]+$")
        if (!nameRegex.matches(hoTenChuan)) {
            edtHoTen.error = "Họ tên không được chứa số hoặc ký tự đặc biệt!"
            return
        }
        val soLuong = rawSoLuong.toIntOrNull()
        if (soLuong == null || soLuong !in 1..9) {
            edtSoLuong.error = "Số lượng vé phải từ 1 đến 9!"
            return
        }

        val maVe = QuyTacPhieu_2108.taoMaTuDong()

        val bundle = Bundle().apply {
            putString("maVe", maVe)
            putString("hoTen", hoTenChuan)
            putInt("soLuong", soLuong)
        }
        setFragmentResult("requestKey_ve", bundle)
        (activity as? MainActivity)?.chuyenSangXacNhanFragment()
    }
}