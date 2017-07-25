
package com.example.erp.network.responses;

import java.util.List;
import javax.annotation.Generated;

import com.example.erp.data.vos.LocationVO;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class LocationResponse {

    @SerializedName("data")
    private List<LocationVO> mData;

    public List<LocationVO> getLocationList() {
        return mData;
    }

    public void setLocationList(List<LocationVO> data) {
        mData = data;
    }

}
