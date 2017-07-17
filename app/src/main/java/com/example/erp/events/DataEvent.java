package com.example.erp.events;

import com.example.erp.network.responses.ProductResponse;

/**
 * Created by myolwin00 on 7/11/17.
 */

public class DataEvent {

    public static class ProductEvent {
        private ProductResponse mProductResponse;

        public ProductEvent(ProductResponse mProductResponse) {
            this.mProductResponse = mProductResponse;
        }

        public ProductResponse getProductResponse() {
            return mProductResponse;
        }
    }
}
