package com.ylx.blog.util;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName PageUtil
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/24 16:24
 * @Version 1.0
 **/
public class PageUtil<T> {
    /*需要分页的数据集*/
    private List<T> pageData;
    /*页号*/
    private Integer pageNum = 1;
    /*每一页的数据量*/
    private Integer pageSize = 2;
    /*总数据量*/
    private Integer total;

    /*获取总页数*/
    public int getPageCount(){
        if (this.total % this.pageSize == 0) {
            return this.total / this.pageSize;
        }
        return this.total / this.pageSize + 1;
    }

    public PageUtil() {
    }

    public PageUtil(List<T> pageData, Integer total) {
        this.pageData = pageData;
        this.total = total;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /*是否为首页*/
    public boolean isFirst()
    {
        return (this.pageNum == 1) || (this.total == 0);
    }
    /*是否为尾页*/
    public boolean isLast() {
        return (this.total == 0) || (this.pageNum >= getPageCount());
    }
    /*是否有下一页*/
    public boolean isHasNext()
    {
        return this.pageNum < getPageCount();
    }
    /*是否有上一页*/
    public boolean isHasPrev() {
        return this.pageNum > 1;
    }
    /*获取下一页页号*/
    public Integer getNextPage()
    {
        if (this.pageNum >= getPageCount()) {
            return getPageCount();
        }
        return this.pageNum + 1;
    }
    //获取上一页页号
    public Integer getPrevPage() {
        if (this.pageNum <= 1) {
            return 1;
        }
        return this.pageNum - 1;
    }

    List<T> list;
    ListIterator<T> iterator;
    int preNum;
    //开始分页
    public List<T> startPaging(){
        list = new ArrayList<>();
        iterator = pageData.listIterator();
        preNum=(pageNum-1)*pageSize;
        while(preNum-- >0){
            iterator.next();
        }
        for (Integer size = pageSize; size>0 && iterator.hasNext(); size--) {
            list.add(iterator.next());
        }
        return list;
    }
    //到最后一页
    public List<T> lastPage(int totalPageNum){
        list= new ArrayList<>();
        iterator= pageData.listIterator();
        int preNum=(totalPageNum-1)*pageSize;
        while(preNum-- >0){
            iterator.next();
        }
        for (Integer size = pageSize; size>0 && iterator.hasNext(); size--) {
            list.add(iterator.next());
        }
        pageNum=totalPageNum;
        return list;
    }
    //到第一页
    public List<T> firstPage(){
        list= new ArrayList<>();
        iterator= pageData.listIterator();
        for (Integer size = pageSize; size>0 && iterator.hasNext(); size--) {
            list.add(iterator.next());
        }
        pageNum=1;
        return list;
    }

}
