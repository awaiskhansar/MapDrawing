package com.github.bkhezry.mapdrawingtools.model;


import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

public class DataModel implements Parcelable {
    private LatLng[] points;
    private int count;
    private Location currenLocation;

    public Location getCurrenLocation() {
        return currenLocation;
    }

    public void setCurrenLocation(Location currenLocation) {
        this.currenLocation = currenLocation;
    }


    public LatLng[] getPoints() {
        return points;
    }

    public void setPoints(LatLng[] points) {
        this.points = points;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.points, flags);
        dest.writeInt(this.count);
//        dest.writeArray(this.currenLocation);
    }

    public DataModel() {
    }

    protected DataModel(Parcel in) {
        this.points = in.createTypedArray(LatLng.CREATOR);
        this.count = in.readInt();
//        this.currenLocation = in.readValue(Location.CREATOR);
    }

    public static final Parcelable.Creator<DataModel> CREATOR = new Parcelable.Creator<DataModel>() {
        @Override
        public DataModel createFromParcel(Parcel source) {
            return new DataModel(source);
        }

        @Override
        public DataModel[] newArray(int size) {
            return new DataModel[size];
        }
    };
}
