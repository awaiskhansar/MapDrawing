package com.github.bkhezry.extramaputils.listener;

import com.google.maps.android.data.Feature;
import com.google.maps.android.data.geojson.GeoJsonLayer;

public interface onGeoJsonEventListener {
    void onFeatureClick(Feature feature);
    void onGeoJsonLoaded(GeoJsonLayer geoJsonLayer);
}