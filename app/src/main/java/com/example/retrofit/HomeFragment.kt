package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Adapter.MovieListAdapter
import com.example.retrofit.Model.MovieModel
import com.example.retrofit.ViewModel.HomeViewModel
import com.example.retrofit.databinding.FragmentHomeBinding

/*class HomeFragment : Fragment(), MovieListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    //private val binding by lazy { _binding!! }
    private lateinit var navController: NavController
    var homeViewModel: HomeViewModel? = null
    private lateinit var recyclerView: RecyclerView
    var layoutManager: LinearLayoutManager? = null
    private lateinit var rvAdapter: MovieListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel!!.getMovieModelLiveData()


        homeViewModel!!.getMovieList.observe(viewLifecycleOwner) { movieModels ->

            if (movieModels != null) {
                val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(requireActivity())
                binding.recyclerView.layoutManager = layoutManager
                rvAdapter = MovieListAdapter(movieModels)
                binding.recyclerView.adapter = rvAdapter
            }
            rvAdapter.setOnItemClickListener(this)
        }


//        val rvAdapter = MovieListAdapter()
//        binding.recyclerView.adapter = rvAdapter.apply {
//            setOnItemClickListener {
//                val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment(it)
//                findNavController().navigate(action)
//            }
//        }
    }
    override fun onItemClick(position: Int, currentItem: List<MovieModel>) {
       val jhjyfcyt= currentItem[position].imageurl
        val  action = jhjyfcyt?.let { HomeFragmentDirections.actionHomeFragmentToSecondFragment(it) }
        if (action != null){
            navController.navigate(action)
        }
    }
}*/
class HomeFragment : Fragment(), MovieListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    var homeViewModel: HomeViewModel? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            navController = findNavController()
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel!!.getMovieModelLiveData()

        homeViewModel!!.getMovieList.observe(viewLifecycleOwner) { movieModels ->
            if (movieModels != null) {
                val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(requireActivity())
                binding.recyclerView.layoutManager = layoutManager
                rvAdapter = MovieListAdapter(movieModels)
                rvAdapter.setOnItemClickListener(this) // moved inside if block
                binding.recyclerView.adapter = rvAdapter
            }
        }
    }

    override fun onItemClick(position: Int, currentItem: List<MovieModel>) {
        currentItem.forEach {
            if(findNavController().currentDestination?.id==R.id.homeFragment)
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSecondFragment(it)
                )
            //navController.navigate(HomeFragmentDirections.actionHomeFragmentToSecondFragment(it))
        }
    }
}

