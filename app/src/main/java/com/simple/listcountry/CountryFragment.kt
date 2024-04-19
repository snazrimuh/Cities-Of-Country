package com.simple.listcountry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryFragment : Fragment(), CountryAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_country, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        countryAdapter = CountryAdapter(this)
        recyclerView.adapter = countryAdapter

        return view
    }

    override fun onItemClick(countryName: String) {
        Toast.makeText(requireContext(), "$countryName", Toast.LENGTH_SHORT).show()

        displayCityFragment(countryName)
    }

    private fun displayCityFragment(countryName: String) {
        val action = CountryFragmentDirections.actionCountryFragmentToCityFragment(countryName)
        findNavController().navigate(action)
    }
}

