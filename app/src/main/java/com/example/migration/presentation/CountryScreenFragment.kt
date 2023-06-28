package com.example.migration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.domain.models.Method
import com.example.migration.databinding.FragmentCoutryScreenBinding
import com.example.migration.presentation.view_models.MethodsScreenViewModel
import com.example.migration.presentation.view_models.MethodsScreenViewModelFactory
import com.migration.app.App
import com.migration.domain.models.Country
import com.migration.presentation.CountryAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ARG_COUNTRY = "country"

class CountryScreenFragment : Fragment(), MethodAdapter.Listener {
    private var country: Country? = null

    lateinit var binding: FragmentCoutryScreenBinding

    @Inject
    lateinit var vmFactory: MethodsScreenViewModelFactory

    private lateinit var vm: MethodsScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getSerializable(ARG_COUNTRY) as Country
        }

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory).get(MethodsScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCoutryScreenBinding.inflate(inflater, container, false)

        with(binding){
            name.text = country?.name ?: ""
            Glide.with(requireContext()).load(country?.backUrl).into(backgroundImage)
            Glide.with(requireContext()).load(country?.flagUrl).into(flagImage)
        }

        val adapter = MethodAdapter(this)
        country?.let { initRC(adapter, it.methods_path) }

        vm.methodList.observe(viewLifecycleOwner) {
            adapter.addMethodList(it)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(country: Country) =
            CountryScreenFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_COUNTRY, country)
                }
            }
    }

    private fun initRC(adapter: MethodAdapter, path: String){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(requireContext())
            rcView.adapter = adapter
            lifecycleScope.launch {
                vm.rcLoad(path)
            }
        }
    }

    override fun onClick(method: Method) {
        println(method.title)
    }
}