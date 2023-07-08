package com.example.migration.presentation.getconsultationscreen

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.domain.models.ConsultationRequest
import com.example.migration.app.App
import com.example.migration.databinding.FragmentGetConsultationBinding
import com.example.migration.presentation.methodinfoscreen.models.MethodInfoForRequest
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GetConsultationFragment : BottomSheetDialogFragment() {

    private var methodInfo: MethodInfoForRequest? = null

    private lateinit var binding: FragmentGetConsultationBinding

    @Inject
    lateinit var vmFactory: GetConsultationScreenViewModelFactory

    private lateinit var vm: GetConsultationScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            methodInfo = it.getSerializable(ARG_METHOD_INFO) as MethodInfoForRequest
        }

        (requireContext().applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory).get(GetConsultationScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGetConsultationBinding.inflate(layoutInflater, container, false)

        emailFocusListener()
        phoneFocusListener()
        nameFocusListener()

        binding.getConsBanner.setOnClickListener {
            submitForm()
        }

        return binding.root
    }

    companion object {

        private const val ARG_METHOD_INFO = "method_info"
        private const val WRONG_EMAIL = "Введите корректную эл. почту"
        private const val WRONG_PHONE = "Введите корректный телефон"
        private const val WRONG_NAME = "Введите имя"
        private const val WRONG_FORM = "Проверьте правильность введенных данных"
        private const val RIGHT_FORM = "Ваша заявка на консультацию отправлена"

        @JvmStatic
        fun newInstance(methodInfo: MethodInfoForRequest) =
            GetConsultationFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_METHOD_INFO, methodInfo)
                }
            }
    }

    private fun submitForm() {
        val validName = binding.containerName.helperText == null
        val validPhone = binding.containerPhone.helperText == null
        val validEmail = binding.containerEmail.helperText == null

        if (validName && validPhone && validEmail)
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        Toast.makeText(
            requireContext(),
            WRONG_FORM,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun resetForm() {
        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val dateString = dateFormat.format(currentDate)
        val timeString = timeFormat.format(currentDate)

        lifecycleScope.launch {
            vm.saveRequest(
                ConsultationRequest(
                    binding.editTextName.text.toString(),
                    binding.editTextPhone.text.toString(),
                    binding.editTextEmail.text.toString(),
                    binding.editTextQuestion.text.toString(),
                    methodInfo!!.country,
                    methodInfo!!.migrationMethod,
                    "$dateString  $timeString"
                )
            )
        }

        Toast.makeText(
            requireContext(),
            RIGHT_FORM,
            Toast.LENGTH_LONG
        ).show()

        dismiss()
    }

    private fun emailFocusListener() {
        binding.editTextEmail.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.containerEmail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.editTextEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return WRONG_EMAIL
        }
        return null
    }

    private fun phoneFocusListener() {
        binding.editTextPhone.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.containerPhone.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String? {
        val phoneText = binding.editTextPhone.text.toString()
        if(phoneText.length != 10) {
            return WRONG_PHONE
        }
        return null
    }

    private fun nameFocusListener() {
        binding.editTextName.setOnFocusChangeListener { _, focused ->
            if (!focused){
                binding.containerName.helperText = validName()
            }
        }
    }

    private fun validName(): String? {
        val nameText = binding.editTextName.text.toString()
        if(nameText.length < 2) {
            return WRONG_NAME
        }
        return null
    }
}