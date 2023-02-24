package vn.edu.hcmuaf.fit.model;

import java.text.DecimalFormat;
import java.util.List;

public class Product {
    String id;
    String name;
    String type;
    String size;
    int weight;
    String description;
    String introduction;
    List<String> listImg;
    int price;
    List<Comment> comments;
    ProductDetails details;



    public Product(String id, String name, String type, String size, int weight, String description, String introduction, List<String> listImg, int price, List<Comment> comments,  ProductDetails details) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size= size;
        this.weight = weight;
        this.description = description;
        this.introduction=introduction;
        this.listImg = listImg;
        this.price = price;
        this.comments = comments;
        this.details =details;
    }
    public Product(String id, String name, String type, String size, int weight, String description, String introduction, List<String> listImg, int price){
        this.id=id;
        this.name = name;
        this.type = type;
        this.size= size;
        this.weight = weight;
        this.description = description;
        this.introduction=introduction;
        this.listImg = listImg;
        this.price = price;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getListImg() {
        return listImg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }


    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public ProductDetails getDetail() {
        return details;
    }

    public void setListpd(ProductDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                ", introduction='" + introduction + '\'' +
                ", listImg=" + listImg +
                ", price=" + price +
                ", comments=" + comments +
                '}';
    }

    public String getStatus(){
        if(getDetail().getInventory()>1){
            return "Còn hàng";
        }
        else{
            return "Hết hàng";
        }
    }
    public boolean isExistNumber(int slg){
        if(getDetail().getInventory() > slg) return true;
            return false;
    }

    public static String formatNum(int price){
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(price);

    }
//    public static void main(String[] args) {
//
//        System.out.println(formatNum(1234567));
//    }
}