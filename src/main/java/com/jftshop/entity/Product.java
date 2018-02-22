package com.jftshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Entity
@Table(name = "product")
public class Product extends  BaseEntity {

    private String id;
    private Integer allocatedstock;
    private String attributevalue0;
    private String attributevalue1;
    private String attributevalue2;
    private String attributevalue3;
    private String attributevalue4;
    private String attributevalue5;
    private String attributevalue6;
    private String attributevalue7;
    private String attributevalue8;
    private String attributevalue9;
    private String attributevalue10;
    private String attributevalue11;
    private String attributevalue12;
    private String attributevalue13;
    private String attributevalue14;
    private String attributevalue15;
    private String attributevalue16;
    private String attributevalue17;
    private String attributevalue18;
    private String attributevalue19;
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
    private String productcategory;

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

    public String getAttributevalue0() {
        return attributevalue0;
    }

    public void setAttributevalue0(String attributevalue0) {
        this.attributevalue0 = attributevalue0;
    }

    public String getAttributevalue1() {
        return attributevalue1;
    }

    public void setAttributevalue1(String attributevalue1) {
        this.attributevalue1 = attributevalue1;
    }

    public String getAttributevalue2() {
        return attributevalue2;
    }

    public void setAttributevalue2(String attributevalue2) {
        this.attributevalue2 = attributevalue2;
    }

    public String getAttributevalue3() {
        return attributevalue3;
    }

    public void setAttributevalue3(String attributevalue3) {
        this.attributevalue3 = attributevalue3;
    }

    public String getAttributevalue4() {
        return attributevalue4;
    }

    public void setAttributevalue4(String attributevalue4) {
        this.attributevalue4 = attributevalue4;
    }

    public String getAttributevalue5() {
        return attributevalue5;
    }

    public void setAttributevalue5(String attributevalue5) {
        this.attributevalue5 = attributevalue5;
    }

    public String getAttributevalue6() {
        return attributevalue6;
    }

    public void setAttributevalue6(String attributevalue6) {
        this.attributevalue6 = attributevalue6;
    }

    public String getAttributevalue7() {
        return attributevalue7;
    }

    public void setAttributevalue7(String attributevalue7) {
        this.attributevalue7 = attributevalue7;
    }

    public String getAttributevalue8() {
        return attributevalue8;
    }

    public void setAttributevalue8(String attributevalue8) {
        this.attributevalue8 = attributevalue8;
    }

    public String getAttributevalue9() {
        return attributevalue9;
    }

    public void setAttributevalue9(String attributevalue9) {
        this.attributevalue9 = attributevalue9;
    }

    public String getAttributevalue10() {
        return attributevalue10;
    }

    public void setAttributevalue10(String attributevalue10) {
        this.attributevalue10 = attributevalue10;
    }

    public String getAttributevalue11() {
        return attributevalue11;
    }

    public void setAttributevalue11(String attributevalue11) {
        this.attributevalue11 = attributevalue11;
    }

    public String getAttributevalue12() {
        return attributevalue12;
    }

    public void setAttributevalue12(String attributevalue12) {
        this.attributevalue12 = attributevalue12;
    }

    public String getAttributevalue13() {
        return attributevalue13;
    }

    public void setAttributevalue13(String attributevalue13) {
        this.attributevalue13 = attributevalue13;
    }

    public String getAttributevalue14() {
        return attributevalue14;
    }

    public void setAttributevalue14(String attributevalue14) {
        this.attributevalue14 = attributevalue14;
    }

    public String getAttributevalue15() {
        return attributevalue15;
    }

    public void setAttributevalue15(String attributevalue15) {
        this.attributevalue15 = attributevalue15;
    }

    public String getAttributevalue16() {
        return attributevalue16;
    }

    public void setAttributevalue16(String attributevalue16) {
        this.attributevalue16 = attributevalue16;
    }

    public String getAttributevalue17() {
        return attributevalue17;
    }

    public void setAttributevalue17(String attributevalue17) {
        this.attributevalue17 = attributevalue17;
    }

    public String getAttributevalue18() {
        return attributevalue18;
    }

    public void setAttributevalue18(String attributevalue18) {
        this.attributevalue18 = attributevalue18;
    }

    public String getAttributevalue19() {
        return attributevalue19;
    }

    public void setAttributevalue19(String attributevalue19) {
        this.attributevalue19 = attributevalue19;
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

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }
}
