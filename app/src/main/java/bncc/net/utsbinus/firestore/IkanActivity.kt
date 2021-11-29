package bncc.net.utsbinus.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import bncc.net.utsbinus.databinding.ActivityIkanBinding
import bncc.net.utsbinus.model.Ikan
import com.google.firebase.firestore.FirebaseFirestore

class IkanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIkanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIkanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firestore = FirebaseFirestore.getInstance()
        getIkan(firestore)
    }

    private fun getIkan(firestore: FirebaseFirestore) {
        var data: ArrayList<Ikan>?
        data = arrayListOf()
        firestore.collection("ikan").get().addOnSuccessListener { result ->
            data = ArrayList()
            for(document in result) {
                data!!.add(Ikan(
                        document.data["nama"].toString(),
                        document.data["image"].toString()
                ))
            }

            val adapt = IkanAdapter(data!!, applicationContext)
            binding.rvIkan.apply {
                adapter = adapt
                layoutManager = LinearLayoutManager(applicationContext)
            }
        } .addOnFailureListener { exception ->
            Log.d("error firestore", "Error getting document $exception")
        }
    }
}