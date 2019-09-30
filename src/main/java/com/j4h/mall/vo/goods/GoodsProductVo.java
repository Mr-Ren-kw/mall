package com.j4h.mall.vo.goods;

import java.util.List;

public class GoodsProductVo {

    /**
     * number : 20
     * price : 200
     * id : 0
     * specifications : ["标准"]
     * url : http://192.168.2.100:8081/wx/storage/fetch/hqbxcf1ty97z47hwo1iz.jpg
     */
    private int number;
    private double price;
    private int id;
    private List<String> specifications;
    private String url;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public List<String> getSpecifications() {
        return specifications;
    }

    public String getUrl() {
        return url;
    }
}
