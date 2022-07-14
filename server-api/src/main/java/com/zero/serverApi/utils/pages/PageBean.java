package com.zero.serverApi.utils.pages;

import com.github.pagehelper.Page;
import lombok.Data;


import java.util.List;

@Data
public class PageBean<T> {
    private int pageNum;
    private int size;
    private long total;
    private int pages;
    private List<T> record;


    public PageBean(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.size = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.record = list;
        }
    }


}
