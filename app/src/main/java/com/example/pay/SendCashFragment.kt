package com.example.pay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    private val args: SendCashFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.receiverName


        tv_receiver.text = "Send cash to $receiverName"

        btn_send.setOnClickListener {
            if (et_amount.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Enter some amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = et_amount.text.toString().toLong()
            if (amount <= 15000) {
                val action = SendCashFragmentDirections
                    .actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
                findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext(), "Insufficient funds", Toast.LENGTH_SHORT).show()
            }


        }

        btn_cancel.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToChooseReceiverFragment()
            findNavController().navigate(action)
        }

    }
}