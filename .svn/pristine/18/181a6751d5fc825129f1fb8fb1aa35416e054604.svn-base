package com.wangqingbo.test;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wangqingbo.entity.ProjectInfo;

/**
 * 测试hibernate的操作
 * @author Administrator
 *
 */
public class HibernateTest {

	public static void main(String[] args) {
		HibernateTest t = new HibernateTest();
		t.saveProject();
		//t.getProject();
		//t.updateProject();
		//t.delProject();
		//t.loadProject();
	}
	
	/**
	 * 保存项目信息
	 */
	public void saveProject()
	{
		// 加载配置文件，不传参数，默认去src下找hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		
		for (int i = 0; i < 100; i++)
		{
		
		// 打开session
		Session session = factory.openSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		// 保存对象，创建对象
		ProjectInfo prj = new ProjectInfo();
		prj.setProjectName("项目名称" + i);
		prj.setProjectCode("jx" + i);
		prj.setCreateUser("克林顿" + i);
		prj.setProjectTotal((i + 500.0));
		prj.setProjectUnit("中国南昌市政府");
		// 开始日期，依次往后添加
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, i);
		prj.setStartTime(cal.getTime());
		// 结束日期，在开始日期的基础上加50天
		cal.add(Calendar.DAY_OF_MONTH, i + 50);
		prj.setEndTime(cal.getTime());
		// 保存对象
		session.save(prj);
		// 提交事务
		tx.commit();
		// 关闭session
		session.close();
		}
		
		
		// 关闭工厂
		factory.close();
	}
	
	/**
	 * 查询项目信息
	 */
	public void getProject()
	{
		// 加载配置文件，不传参数，默认去src下找hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 打开session
		Session session = factory.openSession();
		// 查询项目，使用get方法，参数一：查询结果要封装的对象，参数2：对象的id
		// 如果id对应的数据在数据库中不存在，就返回null
		ProjectInfo prj = session.get(ProjectInfo.class, "4028801f65f636f10165f636f78d0000");
		System.out.println("项目名称：" + prj.getProjectName());
		// 关闭session
		session.close();
		// 关闭工厂
		factory.close();
	}
	
	/**
	 * 查询项目信息
	 */
	public void loadProject()
	{
		// 加载配置文件，不传参数，默认去src下找hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 打开session
		Session session = factory.openSession();
		// 查询项目，使用load方法，参数一：查询结果要封装的对象，参数2：对象的id
		// 如果id对应的数据在数据库中不存在，就会抛出异常 No row with the given identifier exists
		ProjectInfo prj = session.load(ProjectInfo.class, "4028801f65f636f10165f636f78d0000");
		System.out.println("项目名称：" + prj.getProjectName());
		// 关闭session
		session.close();
		// 关闭工厂
		factory.close();
	}
	
	/**
	 * 修改项目信息
	 */
	public void updateProject()
	{
		// 加载配置文件，不传参数，默认去src下找hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 打开session
		Session session = factory.openSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		// 查询对象
		ProjectInfo prj = session.get(ProjectInfo.class, "4028801f65f636f10165f636f78d0000");
		// 修改对象的属性值
		prj.setCreateUser("奥巴马");
		prj.setProjectName("奥巴马项目");
		prj.setStartTime(new Date());
		prj.setVol("1000KV");
		// 修改对象
		session.update(prj);
		// 提交事务
		tx.commit();
		// 关闭session
		session.close();
		// 关闭工厂
		factory.close();
	}
	
	/**
	 * 删除项目信息
	 */
	public void delProject()
	{
		// 加载配置文件，不传参数，默认去src下找hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		// 创建sessionFactory
		SessionFactory factory = config.buildSessionFactory();
		// 打开session
		Session session = factory.openSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		// 查询对象
		//ProjectInfo prj = session.get(ProjectInfo.class, "4028801f65f636f10165f636f78d0000");
		// 自己构造对象，对象要设置id
		ProjectInfo prj = new ProjectInfo();
		prj.setProjectId("946254052D5B4D79858DDB99891BCBC6");
		// 删除对象，如果对象不存在，就会报错
		session.delete(prj);
		// 提交事务
		tx.commit();
		// 关闭session
		session.close();
		// 关闭工厂
		factory.close();
	}
	
	

}
