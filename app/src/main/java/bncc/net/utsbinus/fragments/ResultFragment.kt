package bncc.net.utsbinus.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import bncc.net.utsbinus.R
import bncc.net.utsbinus.databinding.FragmentResultBinding
import bncc.net.utsbinus.firestore.IkanActivity

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var binding: FragmentResultBinding
    lateinit var username: String
    lateinit var nama: String
    lateinit var nim: String
    lateinit var uriImage: Uri

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        username = arguments?.getString("username").toString()
        nama = arguments?.getString("nama").toString()
        nim = arguments?.getString("nim").toString()
        uriImage = Uri.parse(arguments?.getString("image").toString())

        binding.textNim.text = "NIM : $nim"
        binding.textNama.text = "Nama : $nama"
        binding.textHello.text = "Hello, $username"
        binding.imageProfile.setImageURI(uriImage)

        binding.btnList.setOnClickListener {
            val intent = Intent(requireContext(), IkanActivity::class.java)
            startActivity(intent)
        }
    }
}