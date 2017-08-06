
package com.example.erp.data.vos;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.erp.persistence.DataContract.ProductEntry;
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

    public ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(ProductEntry.COLUMN_BRAND_NAME, mBrandName);
        cv.put(ProductEntry.COLUMN_CAT_MYANMAR, mCatMyanmar);
        cv.put(ProductEntry.COLUMN_DRC, mDrc);
        cv.put(ProductEntry.COLUMN_DRC_EXPIRE_DATE, mDrcExpiryDate);
        cv.put(ProductEntry.COLUMN_DRC_REG_NO, mDrcRegNo);
        cv.put(ProductEntry.COLUMN_GENERIC_NAME, mGenericName);
        cv.put(ProductEntry.COLUMN_ITEM_CODE, mItemCode);
        cv.put(ProductEntry.COLUMN_HSCODE, mHscode);
        cv.put(ProductEntry.COLUMN_ID, mId);
        cv.put(ProductEntry.COLUMN_PACK_SIZE, mPackSize);
        cv.put(ProductEntry.COLUMN_VENDOR_TEAM, mVendorTeam);
        cv.put(ProductEntry. COLUMN_VP_CODE, mVpCode);
        return cv;
    }

    public static ProductVO parseFromCursor(Cursor data) {
        ProductVO product = new ProductVO();
        product.mBrandName = data.getString(data.getColumnIndex(ProductEntry.COLUMN_BRAND_NAME));
        product.mCatMyanmar = data.getString(data.getColumnIndex(ProductEntry.COLUMN_CAT_MYANMAR));
        product.mDrc = data.getString(data.getColumnIndex(ProductEntry.COLUMN_DRC));
        product.mDrcExpiryDate = data.getString(data.getColumnIndex(ProductEntry.COLUMN_DRC_EXPIRE_DATE));
        product.mDrcRegNo = data.getString(data.getColumnIndex(ProductEntry.COLUMN_DRC_REG_NO));
        product.mGenericName = data.getString(data.getColumnIndex(ProductEntry.COLUMN_GENERIC_NAME));
        product.mItemCode = data.getString(data.getColumnIndex(ProductEntry.COLUMN_ITEM_CODE));
        product.mHscode = data.getString(data.getColumnIndex(ProductEntry.COLUMN_HSCODE));
        product.mId = Long.parseLong(data.getString(data.getColumnIndex(ProductEntry.COLUMN_ID)));
        product.mPackSize = data.getString(data.getColumnIndex(ProductEntry.COLUMN_PACK_SIZE));
        product.mVendorTeam = data.getString(data.getColumnIndex(ProductEntry.COLUMN_VENDOR_TEAM));
        product.mVpCode = data.getString(data.getColumnIndex(ProductEntry.COLUMN_VP_CODE));
        return product;
    }
}
