package com.example.github.repositories

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainFragment : Fragment() {

    private val viewModel = MainViewModel()

    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerview: RecyclerView
    private lateinit var loading: ProgressBar
    private lateinit var tvError: AppCompatTextView
    private lateinit var btnRetry: AppCompatButton
    private var shouldRefresh: Boolean = false

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        swipeRefresh = view.findViewById(R.id.swipe_refresh)
        recyclerview = view.findViewById(R.id.news_list)
        tvError = view.findViewById(R.id.tvError)
        btnRetry = view.findViewById(R.id.btnRetry)
        loading = view.findViewById(R.id.loadingIndicator)

        if(requireActivity().isConnected) {
            fetchItems()
        } else {
            showRetryScreen()
        }

        swipeRefresh.setOnRefreshListener { viewModel.refresh() }

        recyclerview.layoutManager = LinearLayoutManager(context)

        btnRetry.setOnClickListener {
            if(requireActivity().isConnected) {
                hideRetryScreen()
                fetchItems()
            }
        }

        viewModel.repositories.observeForever {
            hideRetryScreen()
            hideLoader()
            val adapter = RepositoryAdapter(it.take(20).toMutableList(), requireActivity())
            recyclerview.adapter = adapter
        }
        return view
    }

    private fun fetchItems() {
        loading.show()
        viewModel.fetchItems()
    }

    private fun hideLoader() {
        loading.hide()
    }

    private fun showRetryScreen() {
        tvError.show()
        btnRetry.show()
    }

    private fun hideRetryScreen() {
        swipeRefresh.isRefreshing = false
        tvError.hide()
        btnRetry.hide()
    }
}