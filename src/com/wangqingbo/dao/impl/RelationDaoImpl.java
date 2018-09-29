package com.wangqingbo.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wangqingbo.dao.RelationDao;
import com.wangqingbo.entity.EngineerInfo;
import com.wangqingbo.entity.PassportInfo;
import com.wangqingbo.entity.PersonInfo;
import com.wangqingbo.entity.TechnologyInfo;
import com.wangqingbo.entity.Torder;
import com.wangqingbo.entity.TorderLine;
import com.wangqingbo.util.HibernateUtil;

/**
 * 关联映射的实现类
 * @author Administrator
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RelationDaoImpl implements RelationDao
{

	/**
	 * 保存一对一的关系
	 */
	public void saveOneToOne()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 事务
		Transaction tx = session.beginTransaction();
		// 创建对象人
		PersonInfo pi = new PersonInfo();
		pi.setAge(20);
		pi.setPersonName("特朗普");
		// 创建对象 护照
		PassportInfo pp = new PassportInfo();
		pp.setPassportBh("A250");
		// 设置关联关系，将护照和人关联
		pi.setPassportInfo(pp);
		// 把人给护照
		pp.setPersonInfo(pi);
		// 保存人，护照信息也会一并保存
		session.save(pi);
		// 提交事务
		tx.commit();
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 查询人员信息
	 */
	public void queryPerson()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		String hql = "from PersonInfo";
		// 创建一个查询对象
		Query query = session.createQuery(hql, PersonInfo.class);
		// 结果集
		List<PersonInfo> list = query.list();
		// 输出人员姓名和护照编号
		if (list != null && list.size() > 0)
		{
			for (PersonInfo p : list)
			{
				System.out.println(p.getPersonName() + "," + p.getPassportInfo().getPassportBh());
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 保存一对多
	 */
	public void saveOneToMany()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 事务
		Transaction tx = session.beginTransaction();
		// 创建对象订单
		Torder t = new Torder();
		t.setOrderTime(new Date());
		t.setShopperTime(new Date());
		t.setTotal(1234.34);
		// 创建set对象，存放订单详情
		Set<TorderLine> tlSet = new HashSet<TorderLine>();
		// 创建对象，订单详情1
		TorderLine tl1 = new TorderLine();
		tl1.setPrice(200.21);
		tl1.setQuantity(10);
		tl1.setProductName("电风扇");
		tlSet.add(tl1);
		// 订单详情2
		TorderLine tl2 = new TorderLine();
		tl2.setPrice(100.21);
		tl2.setQuantity(2);
		tl2.setProductName("Java从入门到放弃");
		tlSet.add(tl2);
		// 订单详情3
		TorderLine tl3 = new TorderLine();
		tl3.setPrice(523.26);
		tl3.setQuantity(23);
		tl3.setProductName("数据库从删库到跑路");
		tlSet.add(tl3);
		// 把set列表设置给订单
		t.setTorderLines(tlSet);
		// 保存订单
		session.save(t);
		// 提交事务
		tx.commit();
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 查询一对多
	 */
	public void queryOneToMany()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		String hql = "from Torder";
		// 创建一个查询对象
		Query query = session.createQuery(hql, Torder.class);
		// 结果集
		List<Torder> list = query.list();
		// 输出订单和订单详情
		if (list != null && list.size() > 0)
		{
			for (Torder t : list)
			{
				// 订单id
				System.out.println(t.getId());
				// 订单详情,这里执行懒加载操作
				Set<TorderLine> tls = t.getTorderLines();
				// 输出订单详情
				for (TorderLine tl : tls)
				{
					System.out.println(tl.getProductName());
				}
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 保存多对多
	 */
	public void saveManyToMany()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 事务
		Transaction tx = session.beginTransaction();
		// 创建对象工程师1
		EngineerInfo ei1 = new EngineerInfo();
		ei1.setAge(18);
		ei1.setCompany("IBM");
		ei1.setName("李宏刚");

		// 创建对象工程师2
		EngineerInfo ei2 = new EngineerInfo();
		ei2.setAge(15);
		ei2.setCompany("微软");
		ei2.setName("谢宝达");
		// 技术列表
		Set<TechnologyInfo> tiSet1 = new HashSet<TechnologyInfo>();
		Set<TechnologyInfo> tiSet2 = new HashSet<TechnologyInfo>();
		// 创建技术1
		TechnologyInfo ti1 = new TechnologyInfo();
		ti1.setCategory("编程");
		ti1.setName("JAVA");
		tiSet1.add(ti1);
		tiSet2.add(ti1);
		// 创建技术2
		TechnologyInfo ti2 = new TechnologyInfo();
		ti2.setCategory("编程");
		ti2.setName("C++");
		tiSet1.add(ti2);
		tiSet2.add(ti2);
		// 创建技术3
		TechnologyInfo ti3 = new TechnologyInfo();
		ti3.setCategory("编程");
		ti3.setName("C");
		tiSet1.add(ti3);
		tiSet2.add(ti3);
		// 创建技术4
		TechnologyInfo ti4 = new TechnologyInfo();
		ti4.setCategory("数据库");
		ti4.setName("Oracle");
		tiSet1.add(ti4);
		// 创建技术5
		TechnologyInfo ti5 = new TechnologyInfo();
		ti5.setCategory("前端");
		ti5.setName("HTML");
		tiSet2.add(ti5);

		// 设置关联关系
		ei1.setTechnologyInfos(tiSet1);
		ei2.setTechnologyInfos(tiSet2);
		// 保存工程师
		session.save(ei1);
		session.save(ei2);
		// 提交事务
		tx.commit();
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 查询多对多
	 */
	public void queryManyToMany()
	{
		// 拿到session
		Session session = HibernateUtil.currentSession();
		String hql = "from EngineerInfo";
		// 创建一个查询对象
		Query query = session.createQuery(hql, EngineerInfo.class);
		// 结果集
		List<EngineerInfo> list = query.list();
		// 输出工程师和他所学的技术
		if (list != null && list.size() > 0)
		{
			for (EngineerInfo ei : list)
			{
				// 工程师名称
				System.out.println(ei.getName());
				// 工程师所学的技术
				Set<TechnologyInfo> tis = ei.getTechnologyInfos();
				// 输出订单详情
				for (TechnologyInfo ti : tis)
				{
					System.out.println(ti.getName());
				}

				System.out.println("*******************************");
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
}
