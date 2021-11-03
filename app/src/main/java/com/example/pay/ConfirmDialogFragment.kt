package com.example.pay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*

class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.receiverName
        val amount = args.amount

        tv_message.text = "Do you want to send ₨$amount to $receiverName?"

        btn_yes.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "$amount has been sent to $receiverName",
                Toast.LENGTH_SHORT
            ).show()
            val bundle = Bundle()
            bundle.putLong("amount",amount)
            dismiss()
            findNavController().navigate(R.id.action_confirmDialogFragment_to_homeFragment,bundle)
        }

        btn_no.setOnClickListener {
            dismiss()
        }

    }
}