package com.jftshop.dao;

import com.jftshop.util.JFTBeanUtils;

import java.util.List;

/**
 * Created by ThinkPad on 2017/6/17.
 */
public class Pagination {

    int draw=-1;
    int start;
    int length;
    List data;
    int recordsTotal;
    int recordsFiltered;

    /*
    *The data to be displayed in the table. This is an array of data source objects,
    * one for each row,
    * which will be used by DataTables.
    * Note that this parameter's name can be changed using the ajax option's dataSrc property.
    * */
    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    /*
    * Total records, before filtering (i.e. the total number of records in the database)
    *
    * */
    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    /*
    *Total records, after filtering (i.e. the total number of records after filtering has been applied - not just the number of records being returned for this page of data).
    *
    * */
    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /*Draw counter.
          This is used by DataTables to ensure that the Ajax returns from server-side processing
          requests are drawn in sequence by DataTables
        */
    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    /*
    * Paging first record indicator. This is the start point in the current data set (0 index based - i.e. 0 is the first record).
    * */
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /*
    *	Number of records that the table can display in the current draw.
    * */
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String toJson(){
        return  JFTBeanUtils.toJson( this );
    }


}
