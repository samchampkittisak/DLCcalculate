package e.a5835512034.dlccalculate;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by 5835512034 on 4/20/2018.
 */

public class MyData implements Parcelable {
    public String data = "Parcelable";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data);
    }

    public MyData() {
    }

    protected MyData(Parcel in) {
        this.data = in.readString();
    }

    public static final Parcelable.Creator<MyData> CREATOR = new Parcelable.Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel source) {
            return new MyData(source);
        }

        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };
}
