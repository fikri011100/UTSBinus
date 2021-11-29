package bncc.net.utsbinus.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import bncc.net.utsbinus.R
import bncc.net.utsbinus.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    lateinit var username: String
    lateinit var uriImage: Uri
    private val REQUEST_CODE = 100

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        username = arguments?.getString("username").toString()
        binding.textUsername.text = username

        binding.imageUpload.setOnClickListener {
            openGalleryForImage()
        }

        binding.btnNext.setOnClickListener {
            if (binding.edtNama.text.toString().equals("") && binding.edtNim.text.toString()
                    .equals("")) {
                Toast.makeText(requireContext(), "Nama dan NIM harus diisi", Toast
                    .LENGTH_LONG).show()
            } else {
                val bundle = Bundle()
                bundle.putString("username", username)
                bundle.putString("nama", binding.edtNama.text.toString())
                bundle.putString("nim", binding.edtNim.text.toString())
                bundle.putString("image", uriImage.toString())

                findNavController().navigate(R.id.action_homeFragment_to_resultFragment, bundle)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            binding.imageUpload.setImageURI(data?.data)
            uriImage = data?.data!!
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }
}