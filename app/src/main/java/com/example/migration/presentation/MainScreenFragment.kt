package com.migration.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.migration.databinding.FragmentMainScreenBinding
import com.migration.app.App
import kotlinx.coroutines.*
import javax.inject.Inject

class MainScreenFragment : Fragment(), CountryAdapter.Listener {

    private lateinit var binding: FragmentMainScreenBinding

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        val adapter = CountryAdapter(this@MainScreenFragment)
        initRC(adapter)

        vm.countryList.observe(viewLifecycleOwner) {
            adapter.addCountryList(it)
        }

        return binding.root
    }

    private fun initRC(adapter: CountryAdapter){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
            lifecycleScope.launch {
                vm.rcLoad()
            }
        }
    }

    override fun onClick(country: com.migration.domain.models.Country) {
        startActivity(Intent(requireContext(), CountryActivity::class.java).apply {
            putExtra("country", country)
        })
    }
}