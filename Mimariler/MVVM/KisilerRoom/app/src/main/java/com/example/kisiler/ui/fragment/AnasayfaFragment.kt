package com.example.kisiler.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisiler.R
import com.example.kisiler.data.entity.Kisiler
import com.example.kisiler.databinding.FragmentAnasayfaBinding
import com.example.kisiler.ui.adapter.KisilerAdapter
import com.example.kisiler.ui.viewModel.AnasayfaViewModel
import com.example.kisiler.ui.viewModel.KisiDetayViewModel
import com.example.kisiler.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        with(binding) {
            kisilerAnasayfaFragment = this@AnasayfaFragment
            kisilerTbBaslik = "Kişiler"
            // Toolbarın Aksiyon alabilmesini sağlıyor
            (activity as AppCompatActivity).setSupportActionBar(tbAnasayfa)

            // Verileri güncel tutuyor
            viewModel.kisilerListesi.observe(viewLifecycleOwner) {
                val adapter = KisilerAdapter(requireContext(), it, viewModel)
                kisilerAdapter = adapter
            }
        }
        // Toolbara menüyü bağlıyor
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)
                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Bu yapı(delegate yapısı) değer aktarmaya çok müsait olmadığından bu şekil
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    fun fabOnClick(it: View) {
        Navigation.gecisYap(it, R.id.kisiKayifGecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
        //Anasayfaya tekrar dönüldüğünde verileri tekrardan yükler.
    }

}