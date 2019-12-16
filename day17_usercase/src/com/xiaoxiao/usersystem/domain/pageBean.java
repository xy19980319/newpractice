package com.xiaoxiao.usersystem.domain;

import java.util.List;

/**
 * @author Xiaoyu
 * @date 2019/12/16 - 17:03
 */
public class pageBean<T> {
  private int totalCounts;
  private int totalPages;
  private List<T> list;
  private int currentPage;
  private int rows;

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "totalCounts=" + totalCounts +
                ", totalPages=" + totalPages +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
