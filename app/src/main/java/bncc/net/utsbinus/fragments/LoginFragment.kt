package bncc.net.utsbinus.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import bncc.net.utsbinus.R
import bncc.net.utsbinus.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    val username = "fikri"
    val password = "123qweasd"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            if (binding.edtUsername.text.toString().equals(username) &&
                binding.edtPassword.text.toString().equals(password)
            ) {
                val bundle = Bundle()
                bundle.putString("username", binding.edtUsername.text.toString())
                bundle.putString("password", binding.edtUsername.text.toString())

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            } else {
                Toast.makeText(requireContext(), "Username atau Password salah", Toast
                    .LENGTH_LONG).show()
            }
        }
    }

}