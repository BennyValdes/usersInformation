package com.example.adptest.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adptest.ui.viewmodel.MainViewModel
import com.example.adptest.R
import com.example.adptest.adapter.UsersAdapter
import com.example.adptest.data.model.UserData
import com.example.adptest.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        viewModel.onCreate()

        viewModel.userModel.observe(viewLifecycleOwner) {
            if (it != null) {
                initRecyclerView(it)
            }
        }

        return binding.root
    }

    private fun initRecyclerView(listUsers: List<UserData>) {
        val manager = LinearLayoutManager(activity)
        manager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewUsers.layoutManager = manager
        binding.recyclerViewUsers.adapter = UsersAdapter(listUsers) {user -> onUserSelected(user) }
    }

    private fun onUserSelected(userData: UserData) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_cont, UserDetailsFragment(userData))
            .commit()
    }

}