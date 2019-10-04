package com.j4h.mall.model.system;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 19:58
 */
public class StorageQuery {
    private int page;
    private int limit;
    private String key;
    private String name;
    private String sort;
    private String order;

    @Override
    public String toString() {
        return "StorageList{" +
                "page=" + page +
                ", limit=" + limit +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
