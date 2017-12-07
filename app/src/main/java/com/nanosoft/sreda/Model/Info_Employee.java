package com.nanosoft.sreda.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nanosoft-Android on 11/19/2017.
 */

public class Info_Employee implements Parcelable {

    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;


    public Info_Employee(){}

    protected Info_Employee(Parcel in) {
        postId = in.readInt();
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        body = in.readString();
    }

    public static final Creator<Info_Employee> CREATOR = new Creator<Info_Employee>() {
        @Override
        public Info_Employee createFromParcel(Parcel in) {
            return new Info_Employee(in);
        }

        @Override
        public Info_Employee[] newArray(int size) {
            return new Info_Employee[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(postId);
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(body);
    }
}
