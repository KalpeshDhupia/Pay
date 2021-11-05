package com.example.pay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_next.setOnClickListener {
            val receiverName = et_receiver_name.text.toString()
            if (receiverName.isNotEmpty()) {
                val action = ChooseReceiverFragmentDirections
                    .actionChooseReceiverFragmentToSendCashFragment(receiverName)
                findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext(), "Enter Name", Toast.LENGTH_SHORT).show()
            }


        }

        btn_cancel.setOnClickListener {
            val action =
                ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }
}