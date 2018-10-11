package com.github.bkhezry.extramaputils.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.github.bkhezry.extramaputils.listener.onGeoJsonEventListener;
import com.github.bkhezry.extramaputils.listener.onKMLEventListener;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class ViewOption implements Parcelable {
    private String title;
    private LatLng centerLatLng;
    private boolean forceCenterMap;
    private float mapsZoom;
    private List<ExtraMarker> markers = new ArrayList<>();
    private List<ExtraPolygon> polygons;
    private List<ExtraPolyline> polylines;
    private boolean isListView;
    private StyleDef styleName;
    private String geoJsonUrl;
    private int geoJsonRes = Integer.MAX_VALUE;
    private onGeoJsonEventListener geoJsonEventListener;
    private String kmlUrl;
    private int kmlRes;
    private onKMLEventListener kmlEventListener;

    public enum StyleDef {
        NIGHT, RETRO, GRAY_SCALE, DEFAULT
    }

    public ViewOption(String title, LatLng centerCoordinates, boolean forceCenterMap, float mapsZoom,
                      List<ExtraMarker> markers, List<ExtraPolygon> polygons,
                      List<ExtraPolyline> polylines, boolean isListView, StyleDef styleName, String geoJsonUrl, int geoJsonRes, onGeoJsonEventListener geoJsonEventListener, String kmlUrl, int kmlRes, onKMLEventListener kmlEventListener) {
        this.title = title;
        this.centerLatLng = centerCoordinates;
        this.forceCenterMap = forceCenterMap;
        this.mapsZoom = mapsZoom;
        this.markers = markers;
        this.polygons = polygons;
        this.polylines = polylines;
        this.isListView = isListView;
        this.styleName = styleName;
        this.geoJsonUrl = geoJsonUrl;
        this.geoJsonRes = geoJsonRes;
        this.geoJsonEventListener = geoJsonEventListener;
        this.kmlUrl = kmlUrl;
        this.kmlRes = kmlRes;
        this.kmlEventListener = kmlEventListener;
    }

    public LatLng getCenterLatLng() {
        return centerLatLng;
    }

    public void setCenterLatLng(LatLng centerLatLng) {
        this.centerLatLng = centerLatLng;
    }

    public boolean isForceCenterMap() {
        return forceCenterMap;
    }

    public void setForceCenterMap(boolean forceCenterMap) {
        this.forceCenterMap = forceCenterMap;
    }

    public float getMapsZoom() {
        return mapsZoom;
    }

    public void setMapsZoom(float mapsZoom) {
        this.mapsZoom = mapsZoom;
    }

    public List<ExtraMarker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<ExtraMarker> markers) {
        this.markers = markers;
    }

    public List<ExtraPolygon> getPolygons() {
        return polygons;
    }

    public void setPolygons(List<ExtraPolygon> polygons) {
        this.polygons = polygons;
    }

    public List<ExtraPolyline> getPolylines() {
        return polylines;
    }

    public void setPolylines(List<ExtraPolyline> polylines) {
        this.polylines = polylines;
    }

    public boolean isListView() {
        return isListView;
    }

    public void setListView(boolean listView) {
        isListView = listView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StyleDef getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleDef styleName) {
        this.styleName = styleName;
    }

    public String getGeoJsonUrl() {
        return geoJsonUrl;
    }

    public void setGeoJsonUrl(String geoJsonUrl) {
        this.geoJsonUrl = geoJsonUrl;
    }

    public int getGeoJsonRes() {
        return geoJsonRes;
    }

    public void setGeoJsonRes(int geoJsonRes) {
        this.geoJsonRes = geoJsonRes;
    }

    public onGeoJsonEventListener getGeoJsonEventListener() {
        return geoJsonEventListener;
    }

    public void setGeoJsonEventListener(onGeoJsonEventListener geoJsonEventListener) {
        this.geoJsonEventListener = geoJsonEventListener;
    }

    public String getKmlUrl() {
        return kmlUrl;
    }

    public void setKmlUrl(String kmlUrl) {
        this.kmlUrl = kmlUrl;
    }

    public int getKmlRes() {
        return kmlRes;
    }

    public void setKmlRes(int kmlRes) {
        this.kmlRes = kmlRes;
    }
    public onKMLEventListener getKmlEventListener() {
        return kmlEventListener;
    }

    public void setKmlEventListener(onKMLEventListener kmlEventListener) {
        this.kmlEventListener = kmlEventListener;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeParcelable(this.centerLatLng, flags);
        dest.writeByte(this.forceCenterMap ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.mapsZoom);
        dest.writeTypedList(this.markers);
        dest.writeTypedList(this.polygons);
        dest.writeTypedList(this.polylines);
        dest.writeByte(this.isListView ? (byte) 1 : (byte) 0);
        dest.writeInt(this.styleName == null ? -1 : this.styleName.ordinal());
        dest.writeString(this.geoJsonUrl);
        dest.writeInt(this.geoJsonRes);
        dest.writeString(this.kmlUrl);
        dest.writeInt(this.kmlRes);
    }

    protected ViewOption(Parcel in) {
        this.title = in.readString();
        this.centerLatLng = in.readParcelable(LatLng.class.getClassLoader());
        this.forceCenterMap = in.readByte() != 0;
        this.mapsZoom = in.readFloat();
        this.markers = in.createTypedArrayList(ExtraMarker.CREATOR);
        this.polygons = in.createTypedArrayList(ExtraPolygon.CREATOR);
        this.polylines = in.createTypedArrayList(ExtraPolyline.CREATOR);
        this.isListView = in.readByte() != 0;
        int tmpStyleName = in.readInt();
        this.styleName = tmpStyleName == -1 ? null : StyleDef.values()[tmpStyleName];
        this.geoJsonUrl = in.readString();
        this.geoJsonRes = in.readInt();
        this.kmlUrl = in.readString();
        this.kmlRes = in.readInt();
    }

    public static final Creator<ViewOption> CREATOR = new Creator<ViewOption>() {
        @Override
        public ViewOption createFromParcel(Parcel source) {
            return new ViewOption(source);
        }

        @Override
        public ViewOption[] newArray(int size) {
            return new ViewOption[size];
        }
    };
}
