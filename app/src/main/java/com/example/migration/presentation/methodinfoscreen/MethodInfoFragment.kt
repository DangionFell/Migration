package com.example.migration.presentation.methodinfoscreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.MigrationMethod
import com.example.domain.models.MigrationMethodInfo
import com.example.migration.app.App
import com.example.migration.databinding.FragmentMethodInfoBinding
import com.example.migration.presentation.methodinfoscreen.delegates.*
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MethodInfoFragment : Fragment(), BannerDelegate.Listener {

    private var method: MigrationMethod? = null

    private lateinit var binding: FragmentMethodInfoBinding

    private val adapter = ListDelegationAdapter <List<MigrationMethodInfo>>(
        BannerDelegate(this),
        BulletListDelegate(),
        ImageDelegate(),
        TextDelegate(),
        TitleDelegate()
    )

    @Inject
    lateinit var vmFactory: MethodInfoScreenViewModelFactory.Factory

    private lateinit var vm: MethodInfoScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            method = it.getSerializable(ARG_METHOD) as MigrationMethod
        }

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory.create(method!!)).get(MethodInfoScreenViewModel::class.java)

        loadData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMethodInfoBinding.inflate(inflater, container, false)

        initRC()

        observeViewModel()

        return binding.root
    }

    companion object {

        private const val ARG_METHOD = "method"

        @JvmStatic
        fun newInstance(method: MigrationMethod) =
            MethodInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_METHOD, method)
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
        vm.methodInfo.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }

    override fun onClick() {
        println("Click")
    }


}