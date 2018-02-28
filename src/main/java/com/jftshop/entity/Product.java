package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Entity
@Table(name = "product")
public class Product extends  BaseEntity {

    private String id;
    private Integer allocatedstock;
    private BigDecimal cost;
    private String fullname;
    private Long hits;
    private String image;
    private String longtext;
    private Boolean isgift;
    private Boolean islist;
    private Boolean ismarketable;
    private Boolean istop;
    private String keyword;
    private BigDecimal marketprice;
    private String memo;
    private Long monthhits;
    private Date monthhitsdate;
    private Long monthsales;
    private Date monthsalesdate;
    private String name;
    private Long point;
    private BigDecimal price;
    private Long sales;
    private Float score;
    private Long scorecount;
    private String seodescription;
    private String seokeywords;
    private String seotitle;
    private String sn;
    private Integer stock;
    private String stockmemo;
    private Long totalscore;
    private String unit;
    private Long weekhits;
    private Date weekhitsdate;
    private Long weeksales;
    private Date weeksalesdate;
    private Integer weight;
    private String brand;
    private String goods;
    private ProductCategory productcategory;

    private List<ProductImage> productimages = new ArrayList();
    private List<ProductParameter> productparameters = new ArrayList();
    private List<ProductAttribute> productattributes = new ArrayList();

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAllocatedstock() {
        return allocatedstock;
    }

    public void setAllocatedstock(Integer allocatedstock) {
        this.allocatedstock = allocatedstock;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLongtext() {
        return longtext;
    }

    public void setLongtext(String longtext) {
        this.longtext = longtext;
    }

    public Boolean getIsgift() {
        return isgift;
    }

    public void setIsgift(Boolean isgift) {
        this.isgift = isgift;
    }

    public Boolean getIslist() {
        return islist;
    }

    public void setIslist(Boolean islist) {
        this.islist = islist;
    }

    public Boolean getIsmarketable() {
        return ismarketable;
    }

    public void setIsmarketable(Boolean ismarketable) {
        this.ismarketable = ismarketable;
    }

    public Boolean getIstop() {
        return istop;
    }

    public void setIstop(Boolean istop) {
        this.istop = istop;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getMonthhits() {
        return monthhits;
    }

    public void setMonthhits(Long monthhits) {
        this.monthhits = monthhits;
    }

    public Date getMonthhitsdate() {
        return monthhitsdate;
    }

    public void setMonthhitsdate(Date monthhitsdate) {
        this.monthhitsdate = monthhitsdate;
    }

    public Long getMonthsales() {
        return monthsales;
    }

    public void setMonthsales(Long monthsales) {
        this.monthsales = monthsales;
    }

    public Date getMonthsalesdate() {
        return monthsalesdate;
    }

    public void setMonthsalesdate(Date monthsalesdate) {
        this.monthsalesdate = monthsalesdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Long getScorecount() {
        return scorecount;
    }

    public void setScorecount(Long scorecount) {
        this.scorecount = scorecount;
    }

    public String getSeodescription() {
        return seodescription;
    }

    public void setSeodescription(String seodescription) {
        this.seodescription = seodescription;
    }

    public String getSeokeywords() {
        return seokeywords;
    }

    public void setSeokeywords(String seokeywords) {
        this.seokeywords = seokeywords;
    }

    public String getSeotitle() {
        return seotitle;
    }

    public void setSeotitle(String seotitle) {
        this.seotitle = seotitle;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStockmemo() {
        return stockmemo;
    }

    public void setStockmemo(String stockmemo) {
        this.stockmemo = stockmemo;
    }

    public Long getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Long totalscore) {
        this.totalscore = totalscore;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getWeekhits() {
        return weekhits;
    }

    public void setWeekhits(Long weekhits) {
        this.weekhits = weekhits;
    }

    public Date getWeekhitsdate() {
        return weekhitsdate;
    }

    public void setWeekhitsdate(Date weekhitsdate) {
        this.weekhitsdate = weekhitsdate;
    }

    public Long getWeeksales() {
        return weeksales;
    }

    public void setWeeksales(Long weeksales) {
        this.weeksales = weeksales;
    }

    public Date getWeeksalesdate() {
        return weeksalesdate;
    }

    public void setWeeksalesdate(Date weeksalesdate) {
        this.weeksalesdate = weeksalesdate;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productcategoryid")
    @JsonIgnore
    public ProductCategory getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(ProductCategory productcategory) {
        this.productcategory = productcategory;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductImage> getProductimages() {
        return productimages;
    }

    public void setProductimages(List<ProductImage> productimages) {
        this.productimages = productimages;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductParameter> getProductparameters() {
        return productparameters;
    }

    public void setProductparameters(List<ProductParameter> productparameters) {
        this.productparameters = productparameters;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductAttribute> getProductattributes() {
        return productattributes;
    }

    public void setProductattributes(List<ProductAttribute> productattributes) {
        this.productattributes = productattributes;
    }
}
