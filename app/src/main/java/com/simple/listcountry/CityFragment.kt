package com.simple.listcountry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CityFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        cityAdapter = CityAdapter(requireContext())
        recyclerView.adapter = cityAdapter

        val countryName = arguments?.getString(ARG_COUNTRY_NAME)

        val cities = getCitiesForCountry(countryName)
        cityAdapter.setData(cities)

        return view
    }

    private fun getCitiesForCountry(countryName: String?): List<String> {
        return when (countryName) {
            "Indonesia" -> listOf("Jakarta", "Surabaya", "Bandung", "Medan", "Semarang")
            "United States" -> listOf("New York", "Los Angeles", "Chicago", "Houston", "Phoenix")
            "India" -> listOf("Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai")
            "China" -> listOf("Shanghai", "Beijing", "Guangzhou", "Shenzhen", "Chongqing")
            "Brazil" -> listOf("São Paulo", "Rio de Janeiro", "Brasília", "Salvador", "Fortaleza")
            "Japan" -> listOf("Tokyo", "Osaka", "Nagoya", "Sapporo", "Fukuoka")
            "South Korea" -> listOf("Seoul", "Busan", "Incheon", "Daegu", "Daejeon")
            "North Korea" -> listOf("Pyongyang", "Hamhung", "Chongjin", "Nampo", "Wonsan")
            "Russia" -> listOf("Moscow", "Saint Petersburg", "Novosibirsk", "Yekaterinburg", "Kazan")
            "Iran" -> listOf("Tehran", "Mashhad", "Isfahan", "Karaj", "Tabriz")
            "Palestine" -> listOf("Gaza City", "Ramallah", "Hebron", "Nablus", "Jericho")
            "UAE" -> listOf("Dubai", "Abu Dhabi", "Sharjah", "Al Ain", "Ajman")
            "Singapore" -> listOf("Singapore")
            "United Kingdom" -> listOf("London", "Manchester", "Birmingham", "Glasgow", "Liverpool")
            "Italy" -> listOf("Rome", "Milan", "Naples", "Turin", "Palermo")
            "Germany" -> listOf("Berlin", "Hamburg", "Munich", "Cologne", "Frankfurt")
            "France" -> listOf("Paris", "Marseille", "Lyon", "Toulouse", "Nice")
            "Ireland" -> listOf("Dublin", "Cork", "Galway", "Limerick", "Waterford")
            "Sweden" -> listOf("Stockholm", "Gothenburg", "Malmö", "Uppsala", "Västerås")
            "Finland" -> listOf("Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu")
            else -> emptyList()
        }
    }

    companion object {
        private const val ARG_COUNTRY_NAME = "countryName"

        fun newInstance(countryName: String): CityFragment {
            val fragment = CityFragment()
            val args = Bundle()
            args.putString(ARG_COUNTRY_NAME, countryName)
            fragment.arguments = args
            return fragment
        }
    }
}
