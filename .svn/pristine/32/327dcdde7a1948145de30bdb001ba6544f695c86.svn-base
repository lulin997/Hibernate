package com.wangqingbo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wangqingbo.entity.ProjectInfo;
import com.wangqingbo.util.HibernateUtil;

/**
 * 缓存测试类
 * @author Administrator
 */
public class CacheTest
{

	public static void main(String[] args)
	{
		CacheTest t = new CacheTest();
		t.oneCacheTest2();

	}

	/**
	 * 一级缓存测试，只做查询
	 */
	public void oneCacheTest()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 使用get方法查询项目信息
		// 查询过程：先去缓存中查找，如果找不到，就到数据中找
		ProjectInfo prj = session.get(ProjectInfo.class, "40288001660e7f5601660e7f59cc0001");
		System.out.println(prj);
		// 清掉缓存，将对象从缓存中清除
		//session.evict(prj);
		// 清空缓存
		session.clear();
		// 查询过程：先去缓存中查找，如果找不到，就到数据中找
		ProjectInfo prj2 = session.get(ProjectInfo.class, "40288001660e7f5601660e7f59cc0001");
		System.out.println(prj2);
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 一级缓存测试，二级缓存存在序列化的过程
	 */
	public void oneCacheTest2()
	{
		// 拿到session
		Session session = HibernateUtil.getSessionFactory().openSession();
		// 使用get方法查询项目信息
		// 查询过程：先去缓存中查找，如果找不到，就到数据中找
		ProjectInfo prj = session.get(ProjectInfo.class, "40288001660e7f5601660e7f59cc0001");
		System.out.println(prj);
		// 关闭session
		session.close();
		// 拿到session
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		// 查询过程：先去缓存中查找，如果找不到，就到数据中找
		ProjectInfo prj2 = session2.get(ProjectInfo.class, "40288001660e7f5601660e7f59cc0001");
		// fd3dc1
		System.out.println(prj2);
		// 关闭session
		session2.close();
		
	}

}
