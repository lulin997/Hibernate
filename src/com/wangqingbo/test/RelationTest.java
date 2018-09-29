package com.wangqingbo.test;

import com.wangqingbo.dao.RelationDao;
import com.wangqingbo.dao.impl.RelationDaoImpl;

/**
 * 关联关系测试类
 * @author Administrator
 *
 */
public class RelationTest
{

	/**
	 * 关联关系测试主方法
	 * @param args 参数
	 */
	public static void main(String[] args)
	{
		RelationDao dao = new RelationDaoImpl();
		// dao.saveOneToOne();
		// dao.queryPerson();
		// dao.saveOneToMany();
		// dao.queryOneToMany();
		// dao.saveManyToMany();
		dao.queryManyToMany();

	}

}
