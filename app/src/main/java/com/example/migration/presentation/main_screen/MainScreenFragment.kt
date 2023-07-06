package com.example.migration.presentation.main_screen

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
import com.example.migration.app.App
import com.example.domain.models.Country
import com.example.migration.presentation.country_screen.CountryActivity
import kotlinx.coroutines.*
import javax.inject.Inject

private const val ARG_COUNTRY = "country"

class MainScreenFragment : Fragment(), CountryAdapter.Listener {

    private lateinit var binding: FragmentMainScreenBinding

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        loadListOfCountries()
    }

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        val adapter = CountryAdapter(this)
        initRC(adapter)

        observeViewModel(adapter)

        return binding.root
    }

    private fun initRC(adapter: CountryAdapter) {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
        }
    }

    private fun loadListOfCountries() {
        lifecycleScope.launch {
            vm.loadData()
        }
    }

    private fun observeViewModel(adapter: CountryAdapter) {
        vm.countryList.observe(viewLifecycleOwner) {
            adapter.addCountryList(it)
        }
    }

    override fun onClick(country: Country) {
        startActivity(Intent(requireContext(), CountryActivity::class.java).apply {
            putExtra(ARG_COUNTRY, country)
        })
    }
}