package com.example.recyclerview.another

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerview.R
import com.example.recyclerview.basic.BasicViewModel
import com.example.recyclerview.databinding.FragmentAnotherRecyclerViewBinding
import java.util.*

class AnotherRecyclerViewFragment : Fragment(), OnClickListener , TextToSpeech.OnInitListener {

    private lateinit var textToSpeech: TextToSpeech
    private lateinit var basicViewModel: BasicViewModel
    private lateinit var binding: FragmentAnotherRecyclerViewBinding
    private val adapter : AnotherAdapter by lazy {
        AnotherAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnotherRecyclerViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textToSpeech = TextToSpeech(requireContext(),this)

        basicViewModel = ViewModelProvider(this, BasicViewModel.Factory()).get(BasicViewModel::class.java)

        basicViewModel.list.observe(viewLifecycleOwner){list ->
            if (!list.isNullOrEmpty()){
                adapter.initlist2(list)
            }

            binding.anotherRecyclerView.adapter = adapter
        }




    }

    override fun onDestroy() {
        textToSpeech.stop()
        textToSpeech.shutdown()
        super.onDestroy()
    }

    override fun onItemClick(value: String) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(value, TextToSpeech.QUEUE_FLUSH, null,"")
        }

//        Toast.makeText(requireContext(),value,Toast.LENGTH_SHORT).show()

    }

    override fun onInit(status: Int) {
//        if (status == TextToSpeech.SUCCESS) {
//            // set US English as language for tts
//            val result = textToSpeech.setLanguage(Locale.US)
//
//            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Log.e("TTS","The Language specified is not supported!")
//            }
//        } else {
//            Log.e("TTS", "Initilization Failed!")
//        }
    }
}