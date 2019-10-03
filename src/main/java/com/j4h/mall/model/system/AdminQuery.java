package com.j4h.mall.model.system;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 21:31
 */
public class AdminQuery {
    private int page;
    private int limit;
    private String username;
    private String sort;
    private String order;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "AdminQuery{" +
                "page=" + page +
                ", limit=" + limit +
                ", username='" + username + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
