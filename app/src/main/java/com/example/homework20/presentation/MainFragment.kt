package com.example.homework20.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework20.data.network.retrofit.clients.DogClient.dogService
import com.example.homework20.databinding.FragmentMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListeners()
    }

    private fun setListeners() {
        binding?.btnGetDogPicture?.setOnClickListener {
            dogService.getDog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listOfDogs ->
                    loadImageFromNetworkGlide(
                        imageURL = listOfDogs.first().url,
                        imageView = binding?.ivDogPicture
                    )
                }, {})
        }
    }

    private fun loadImageFromNetworkGlide(imageURL: String, imageView: ImageView?) {
        if (imageView != null) {
            Glide.with(this)
                .load(imageURL)
                .into(imageView)
        }
    }

    override fun onDestroy() {
        binding = null

        super.onDestroy()
    }
}