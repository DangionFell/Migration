package com.example.migration.presentation.countryscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Country
import com.example.domain.models.MigrationMethod
import com.example.domain.models.SecondScreenItem
import com.example.migration.databinding.FragmentCoutryScreenBinding
import com.example.migration.app.App
import com.example.migration.presentation.countryscreen.delegates.HeaderDelegate
import com.example.migration.presentation.countryscreen.delegates.MigrationMethodDelegate
import com.example.migration.presentation.methodinfoscreen.MethodInfoActivity
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryScreenFragment : Fragment(), MigrationMethodDelegate.Listener {
    private var country: Country? = null

    private lateinit var binding: FragmentCoutryScreenBinding

    private val adapter = ListDelegationAdapter<List<SecondScreenItem>>(
        HeaderDelegate(),
        MigrationMethodDelegate(this)
    )

    @Inject
    lateinit var vmFactory: MethodsScreenViewModelFactory.Factory

    private lateinit var vm: MethodsScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getSerializable(ARG_COUNTRY) as Country
        }

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory.create(country!!)).get(MethodsScreenViewModel::class.java)

        loadData()
    }

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCoutryScreenBinding.inflate(inflater, container, false)

        initRC()

        observeViewModel()

        return binding.root
    }

    companion object {

        private const val ARG_COUNTRY = "country"
        private const val ARG_METHOD = "method"

        @JvmStatic
        fun newInstance(country: Country) =
            CountryScreenFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_COUNTRY, country)
                }
            }
    }

    private fun initRC() {
        with(binding) {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            vm.loadData()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeViewModel() {
        vm.migrationMethodList.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }

    override fun onClick(method: MigrationMethod) {
        startActivity(Intent(requireContext(), MethodInfoActivity::class.java).apply {
            putExtra(ARG_METHOD, method)
        })
    }
}