package com.jftshop.entity;

import com.jftshop.util.JFTBeanUtils;
import com.jftshop.util.JFTStringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;




public abstract class BaseEntity  implements Serializable {


	protected  Date create_date =  new Date()  ;// 创建时间.
	protected  Date modify_date;// 修改时间.

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public Map<String,String> toMap( ){
		return JFTBeanUtils.toMap( this );
	}

	public String toJson( ){
		return JFTBeanUtils.toJson( this );
	}

	public Map<String, String> toNotNullMap() {
		Map<String, String> map = JFTBeanUtils.toMap(this);
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			if (map.get(key) == null) map.remove(key);
		}
		return map;
	}

	//处理URL编码并装载参数到BEAN对象
	public void handleUrlDecode() {
		Map<String, String> map = this.toMap();
		Iterator iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = map.get(key);
			map.put(key, JFTStringUtils.getString_UrlDecode_UTF8(value));
		}

		JFTBeanUtils.populate(this, map);
	}


	public <E> E copyProperties(E dest) {
		JFTBeanUtils.copyProperties(dest, this);
		return dest;
	}

	public void populate(Map<String, String> map) {
		JFTBeanUtils.populate(this, map);
	}


}
