package com.example.adptest.ui.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.Glide
import com.example.adptest.R
import com.example.adptest.data.model.UserData
import com.example.adptest.databinding.FragmentUserDetailsBinding

class UserDetailsFragment( userData: UserData) : Fragment() {

    private lateinit var binding: FragmentUserDetailsBinding

    private val _data = userData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailsBinding.inflate(layoutInflater)

        Glide.with(this).load(_data.results?.component1()?.picture?.medium).into(binding.ivUserPhoto)

        val userName = _data.results?.component1()?.name?.last + " " +
                _data.results?.component1()?.name?.first + " " +
                _data.results?.component1()?.name?.title

        val address = _data.results?.component1()?.location?.city + ", " +
                _data.results?.component1()?.location?.state + ", " +
                _data.results?.component1()?.location?.street?.name + " " +
                _data.results?.component1()?.location?.street?.number

        binding.tvUserName.text = userName
        binding.tvEmails.text = _data.results?.component1()?.email
        binding.tvPhone.text = _data.results?.component1()?.phone
        binding.tvAddress.text = address
        binding.tvDob.text = _data.results?.component1()?.dob?.date
        binding.tvIdUser.text = _data.results?.component1()?.login?.username
        binding.tvCountry.text = _data.results?.component1()?.location?.country

        binding.buttonBack.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_cont, MainFragment())
                .commit()
        }

        binding.switchShow.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.tvPhone.setTextColor(Color.BLACK)
                binding.tvPhone.background = Color.WHITE.toDrawable()
                binding.tvIdUser.setTextColor(Color.BLACK)
                binding.tvIdUser.background = Color.WHITE.toDrawable()
                binding.tvAddress.setTextColor(Color.BLACK)
                binding.tvAddress.background = Color.WHITE.toDrawable()
            } else {
                binding.tvPhone.setTextColor(Color.BLACK)
                binding.tvPhone.background = Color.BLACK.toDrawable()
                binding.tvIdUser.setTextColor(Color.BLACK)
                binding.tvIdUser.background = Color.BLACK.toDrawable()
                binding.tvAddress.setTextColor(Color.BLACK)
                binding.tvAddress.background = Color.BLACK.toDrawable()
            }
        }


        return binding.root
    }

}