package com.atguigu.atcrowdfunding.util;

import java.util.ArrayList;
import java.util.List;

//import com.atguigu.atcrowdfunding.bean.MemberCert;

public class Datas<T> {

	private List<Integer> ids = new ArrayList<Integer>();
	
	private List<T> datas = new ArrayList<T>();

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
}
