package com.bandtec.finfamily.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bandtec.finfamily.R
import com.bandtec.finfamily.popups.PopAlterPut
import kotlinx.android.synthetic.main.fragment_account_items.*


/**
 * A simple [Fragment] subclass.
 */
class AccountItems : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_account_items, container, false)

        return rootView;
    }
}