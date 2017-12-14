package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Indent;
import com.entity.Items;

@Repository // 注册dao层bean等同于@Component
public class IndentDao extends BaseDao{

	/**
	 * 获取订单列表
	 * @param page
	 * @param row
	 */
	public List<Indent> getList(int status, int page, int rows) {
		return getSession().createQuery("from Indent where status="+status+" order by id desc", Indent.class)
				.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	/**
	 * 获取总数
	 * @return
	 */
	public long getTotal(int status) {
		return getSession().createQuery("select count(*) from Indent where status="+status, Long.class).uniqueResult();
	}

	/**
	 * 订单项列表
	 * @param indentid
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Items> getItemList(int indentid, int page, int rows) {
		return getSession().createQuery("from Items where indent_id="+indentid, Items.class)
				.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}

	/**
	 * 订单项总数
	 * @return
	 */
	public long getItemTotal(int indentid) {
		return getSession().createQuery("select count(*) from Items where indent_id="+indentid, Long.class).uniqueResult();
	}

	/**
	 * 按用户名查找
	 * @param userid
	 * @return
	 */
	public List<Indent> getListByUserid(int userid) {
		return getSession().createQuery("from Indent where user_id="+userid+" order by id desc", Indent.class).list();
	}
	

}
