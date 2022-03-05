package com.yangqiang.tuku.model;

import java.util.List;

public class ImagesPageData {

    private List<Tuku> tukuList;
    private int pageCount;
    private int total;

    public List<Tuku> getTukuList() {
        return tukuList;
    }

    public void setTukuList(List<Tuku> tukuList) {
        this.tukuList = tukuList;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ImagesPageData() {
    }

    public ImagesPageData(List<Tuku> tukuList, int pageCount, int total) {
        this.tukuList = tukuList;
        this.pageCount = pageCount;
        this.total = total;
    }


}
