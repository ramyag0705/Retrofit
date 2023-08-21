package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.retrofit.databinding.FragmentSecondBinding
import com.squareup.picasso.Picasso


class SecondFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding
    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(args.movie?.imageurl).into(binding.image)
        binding.name.text = args.movie?.name
        binding.team.text = args.movie?.team
        binding.createdBy.text = args.movie?.createdby
    }
}

