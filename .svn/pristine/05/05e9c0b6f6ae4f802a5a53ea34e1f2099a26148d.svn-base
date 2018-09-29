package com.wangqingbo.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil 封装session相关内容
 * @author oracle
 */
public class HibernateUtil
{
	// sessionFactory
	private static SessionFactory sessionFactory;

	/**
	 * 获取SessionFactory
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory()
	{
		try
		{
			// sessionFactory为空时，就重新创建
			if (sessionFactory == null)
			{
				// 加载配置文件
				Configuration configuration = new Configuration();
				sessionFactory = configuration.configure().buildSessionFactory();
			}
		}
		catch (Throwable ex)
		{
			ex.printStackTrace();
		}
		return sessionFactory;
	}

	// 定义session
	@SuppressWarnings("rawtypes")
	public static final ThreadLocal session = new ThreadLocal();

	/**
	 * 获取当前session
	 * @return session
	 */
	@SuppressWarnings("unchecked")
	public static Session currentSession()
	{
		Session s = (Session) session.get();
		if (s == null)
		{
			s = getSessionFactory().openSession();
			session.set(s);
		}
		return s;
	}

	/**
	 * 关闭session
	 * @throws HibernateException 异常
	 */
	@SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException
	{
		Session s = (Session) session.get();
		// 从map中把session清除
		session.set(null);
		// 关闭session
		if (s != null)
		{
			s.close();
		}
	}

}