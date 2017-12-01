package com.pramati.sample;

import java.util.HashMap;

/**
 * Created by Vivek on 30-11-2017.
 */

public class ResponseModel {

    HashMap<String,ChildCategory>mapOfCategories;


    public HashMap<String, ChildCategory> getMapOfCategories() {
        return mapOfCategories;
    }

    public void setMapOfCategories(HashMap<String, ChildCategory> mapOfCategories) {
        this.mapOfCategories = mapOfCategories;
    }

    public class ChildCategory {
        HashMap<String,SubCategory>mapOfSubCategory;

        public HashMap<String, SubCategory> getMapOfSubCategory() {
            return mapOfSubCategory;
        }

        public void setMapOfSubCategory(HashMap<String, SubCategory> mapOfSubCategory) {
            this.mapOfSubCategory = mapOfSubCategory;
        }

        private class SubCategory {

            HashMap<String,String> subCategoryDetails;

            public HashMap<String, String> getSubCategoryDetails() {
                return subCategoryDetails;
            }

            public void setSubCategoryDetails(HashMap<String, String> subCategoryDetails) {
                this.subCategoryDetails = subCategoryDetails;
            }
        }
    }
}
