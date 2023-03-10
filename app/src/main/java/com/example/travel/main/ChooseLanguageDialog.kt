package com.example.travel.main

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.travel.R
import com.example.travel.api.data.LangType
import com.example.travel.callback.ChooseLanguageHandler
import com.example.travel.databinding.ChooseLanguageFragmentBinding
import com.example.travel.fragment.BaseBottomSheetDialogFragment

class ChooseLanguageDialog(private val handler: ChooseLanguageHandler) : BaseBottomSheetDialogFragment<ChooseLanguageFragmentBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogCircle)
        initView(handler)
        setEvent()
    }

    private fun initView(handler: ChooseLanguageHandler) {
        val languageList = listOf(
            LangType.TW, LangType.CN, LangType.EN, LangType.JP, LangType.KO, LangType.ES, LangType.ID, LangType.TH, LangType.VI
        )
        binding.rvLanguage.run {
            adapter = ChooseLanguageAdapter(languageList, onItemClick = { langInfo ->
                handler.onLanguageChoose().invoke(langInfo)
                dialog?.dismiss()
            })
            val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                setDrawable(ColorDrawable(R.drawable.divider_common))
            }
            addItemDecoration(itemDecoration)
        }
    }

    override fun onDestroyView() {
        binding.rvLanguage.adapter = null
        super.onDestroyView()
    }

    private fun setEvent() {
        binding.apply {
            tvDismiss.setOnClickListener { dialog?.dismiss() }
        }
    }

    override fun bindingCallback(): (LayoutInflater, ViewGroup?) -> ChooseLanguageFragmentBinding =
        { layoutInflater, viewGroup -> ChooseLanguageFragmentBinding.inflate(layoutInflater, viewGroup, false) }
}