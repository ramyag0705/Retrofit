package com.example.retrofit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.HomeFragment
import com.example.retrofit.Model.MovieModel
import com.example.retrofit.databinding.LayoutMovieListBinding
import com.squareup.picasso.Picasso


class MovieListAdapter(
    var movieModelList: List<MovieModel>,
    //private var onItemClickListener: ((String) -> Unit)? = null

):RecyclerView.Adapter<MovieListAdapter.MyViewModel>(){
    private var mlistener: OnItemClickListener? = null
    interface OnItemClickListener {
        fun onItemClick(position: Int, currentItem: List<MovieModel>)
    }
    fun setOnItemClickListener(listener: HomeFragment) {
        mlistener = listener
    }


    class MyViewModel(val binding: LayoutMovieListBinding,private var onItemClickListener: ((String) -> Unit)? = null) : RecyclerView.ViewHolder(binding.root){
//        fun bind(movie: MovieModel){
//            binding.txtMovieName.text = movie.name
//            binding.txtTeam.text = movie.team
//            binding.txtCreatedby.text = movie.createdby
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val binding = LayoutMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewModel(binding)
    }

//    fun MovieListAdapter.setOnItemClickListener(listener: (String) -> Unit){
//        onItemClickListener = listener
//    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        Picasso.get().load(movieModelList[position].imageurl).into(holder.binding.imgMovie)
        holder.binding.txtMovieName.text = movieModelList[position].name
        holder.binding.txtTeam.text = movieModelList[position].team
        holder.binding.txtCreatedby.text = movieModelList[position].createdby

//        holder.itemView.setOnClickListener{
//            val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment(movieModelList[position].name)
//            it.findNavController().navigate(action)
//        }
        holder.itemView.setOnClickListener {
            mlistener?.onItemClick(position,movieModelList)
        }

    }

    override fun getItemCount(): Int {
        return movieModelList.size
    }
}

