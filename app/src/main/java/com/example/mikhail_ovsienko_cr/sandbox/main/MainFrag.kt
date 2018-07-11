package com.example.mikhail_ovsienko_cr.sandbox.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mikhail_ovsienko_cr.sandbox.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainFrag : Fragment(), OnMapReadyCallback {

    companion object {
        private const val MAP_FRAGMENT_TAG = "MAP_FRAGMENT"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.frag_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMapToContainer()
    }


    private fun addMapToContainer() {
        (childFragmentManager.findFragmentById(R.id.mapFragmentContainer) as SupportMapFragment).getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
    }
}