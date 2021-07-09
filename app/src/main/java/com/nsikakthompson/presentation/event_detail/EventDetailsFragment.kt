package com.nsikakthompson.presentation.event_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nsikakthompson.R
import com.nsikakthompson.databinding.FragmentEventDetailsBinding

class EventDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEventDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventDetailsBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      var eventArgs = EventDetailsFragmentArgs.fromBundle(requireArguments())
        binding.toolbarLayout.title = eventArgs.event?.name

        binding.apply {
            event = eventArgs.event
        }
    }
}