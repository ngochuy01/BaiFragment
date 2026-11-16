package vn.ndu.ute.kt04_fragment_2415141122108

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
class XacNhanFragment : Fragment() {
    private lateinit var txtMaVe: TextView
    private lateinit var txtHoTen: TextView
    private lateinit var txtSoLuong: TextView
    private lateinit var txtTienGoc: TextView
    private lateinit var btnQuayLai: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_xac_nhan, container, false)

        txtMaVe = view.findViewById(R.id.txtMaVe)
        txtHoTen = view.findViewById(R.id.txtHoTen)
        txtSoLuong = view.findViewById(R.id.txtSoLuong)
        txtTienGoc = view.findViewById(R.id.txtTienGoc)
        btnQuayLai = view.findViewById(R.id.btnQuayLai)

        arguments?.let { bundle ->
            val maVe = bundle.getString("maVe", "")
            val hoTen = bundle.getString("hoTen", "")
            val soLuong = bundle.getInt("soLuong", 0)

            txtMaVe.text = "Mã vé: $maVe"
            txtHoTen.text = "Họ tên: $hoTen"
            txtSoLuong.text = "Số lượng: $soLuong"

            val thanhTien = soLuong * 50000
            txtTienGoc.text = "Thành tiền: %,d VNĐ".format(thanhTien)
        }

        btnQuayLai.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
    companion object {
        fun newInstance(bundle: Bundle): XacNhanFragment {
            val fragment = XacNhanFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}