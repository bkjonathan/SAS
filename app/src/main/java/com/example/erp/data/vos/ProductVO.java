
package com.example.erp.data.vos;

import com.google.gson.annotations.SerializedName;

public class ProductVO {

    @SerializedName("brand_name")
    private String mBrandName;
    @SerializedName("cat_myanmar")
    private String mCatMyanmar;
    @SerializedName("drc")
    private String mDrc;
    @SerializedName("drc_expiry_date")
    private String mDrcExpiryDate;
    @SerializedName("drc_reg_no")
    private String mDrcRegNo;
    @SerializedName("generic_name")
    private String mGenericName;
    @SerializedName("hscode")
    private String mHscode;
    @SerializedName("id")
    private Long mId;
    @SerializedName("item_code")
    private String mItemCode;
    @SerializedName("pack_size")
    private String mPackSize;
    @SerializedName("vendor_team")
    private String mVendorTeam;
    @SerializedName("vp_code")
    private String mVpCode;

    public String getBrandName() {
        return mBrandName;
    }

    public void setBrandName(String brandName) {
        mBrandName = brandName;
    }

    public String getCatMyanmar() {
        return mCatMyanmar;
    }

    public void setCatMyanmar(String catMyanmar) {
        mCatMyanmar = catMyanmar;
    }

    public String getDrc() {
        return mDrc;
    }

    public void setDrc(String drc) {
        mDrc = drc;
    }

    public String getDrcExpiryDate() {
        return mDrcExpiryDate;
    }

    public void setDrcExpiryDate(String drcExpiryDate) {
        mDrcExpiryDate = drcExpiryDate;
    }

    public String getDrcRegNo() {
        return mDrcRegNo;
    }

    public void setDrcRegNo(String drcRegNo) {
        mDrcRegNo = drcRegNo;
    }

    public String getGenericName() {
        return mGenericName;
    }

    public void setGenericName(String genericName) {
        mGenericName = genericName;
    }

    public String getHscode() {
        return mHscode;
    }

    public void setHscode(String hscode) {
        mHscode = hscode;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getItemCode() {
        return mItemCode;
    }

    public void setItemCode(String itemCode) {
        mItemCode = itemCode;
    }

    public String getPackSize() {
        return mPackSize;
    }

    public void setPackSize(String packSize) {
        mPackSize = packSize;
    }

    public String getVendorTeam() {
        return mVendorTeam;
    }

    public void setVendorTeam(String vendorTeam) {
        mVendorTeam = vendorTeam;
    }

    public String getVpCode() {
        return mVpCode;
    }

    public void setVpCode(String vpCode) {
        mVpCode = vpCode;
    }

}
