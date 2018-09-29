package com.wangqingbo.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wangqingbo.entity.ProjectFeeInfo;
import com.wangqingbo.entity.ProjectInfo;
import com.wangqingbo.util.HibernateUtil;

/**
 * sql语句查询
 * 
 * @author Administrator
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class SqlTest {

	public static void main(String[] args) {
		SqlTest t = new SqlTest();
		t.queryProjectTwoTable1();

	}

	/**
	 * 查询全部
	 */
	public void queryAllProject() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		String sql = "SELECT * FROM PROJECTINFO ";
		// 创建一个查询对象,参数一：要执行的sql语句，参数二：执行结果要封装的对象
		// 如果不加参数二，返回结果中存放的数组，数组中的元素是数据表的字段对应的值
		//session.createSQLQuery("");
		Query query = session.createNativeQuery(sql,ProjectInfo.class);
		// 将查询结果返回
		List<ProjectInfo> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (ProjectInfo prj : list) {
				System.out.println(prj.getProjectName());
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 查询全部
	 */
	public void queryAllProject2() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		String sql = "SELECT PROJECT_ID,PROJECT_NAME,PROJECT_CODE FROM PROJECTINFO ";
		// 创建一个查询对象,参数一：要执行的sql语句，参数二：执行结果要封装的对象
		// 如果只查询部分字段，查询结果就不能封装成对象，只能返回数组，数组中的元素是数据表的字段对应的值
		Query query = session.createNativeQuery(sql);
		// 将查询结果返回
		List<Object[]> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (Object[] prj : list) {
				System.out.println(prj[1]);
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 查询全部
	 * 占位符支持三种方式
	 * 1：? ，位置从1开始
	 * 2： ?数字  ,位置是自己定义，如果有多个参数，数字要连续
	 * 3： :参数名称，参数名称自己定义，规范参照Java变量的规范
	 * 
	 */
	public void queryAllProjectByParams() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		//String sql = "SELECT * FROM PROJECTINFO WHERE PROJECTNAME LIKE ?1 ";
		String sql = "SELECT * FROM PROJECTINFO WHERE PROJECT_NAME LIKE :prjName ORDER BY PROJECT_TOTAL DESC";
		// 创建一个查询对象,参数一：要执行的sql语句，参数二：执行结果要封装的对象
		// 如果不加参数二，返回结果中存放的数组，数组中的元素是数据表的字段对应的值
		//session.createSQLQuery("");
		Query query = session.createNativeQuery(sql,ProjectInfo.class);
		//query.setParameter(1, "%项目%");
		query.setParameter("prjName", "%项目%");
		// 将查询结果返回
		List<ProjectInfo> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (ProjectInfo prj : list) {
				System.out.println(prj.getProjectTotal() + "," + prj.getProjectName());
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 更新数据
	 */
	public void updateProjectByParams() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 事务
		Transaction tx = session.beginTransaction();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		//String sql = "SELECT * FROM PROJECTINFO WHERE PROJECTNAME LIKE ?1 ";
		String sql = "UPDATE PROJECTINFO SET PROJECT_CODE = ?1  WHERE PROJECT_NAME LIKE ?2 ";
		// 创建一个查询对象,参数一：要执行的sql语句
		Query query = session.createNativeQuery(sql);
		query.setParameter(1, "jx2018_4");
		query.setParameter(2, "%4%");
		// 执行更新(包括update和delete)，返回更新的数据条数
		int num = query.executeUpdate();
		// 提交事务
		tx.commit();
		System.out.println("更新的数据条数：" + num);
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 多表查询项目信息,返回对象
	 */
	public void queryProjectTwoTable1() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		String sql = "SELECT P.PROJECT_ID,P.PROJECT_NAME,P.PROJECT_CODE,P.PROJECT_UNIT,P.START_TIME,P.END_TIME,P.VOL_TAGE,P.CREATE_USER,P.PROJECT_TOTAL,PF.FEEID,PF.PROJECT_ID PFID,PF.AZFY,PF.JSFY,PF.QTFY FROM PROJECTINFO P,PROJECTFEEINFO PF WHERE P.PROJECT_ID=PF.PROJECT_ID";
		// createNativeQuery方法中有两个参数，参数一：sql语句，参数2：要返回的对象类，返回跟参数2对应的对象
		// 在转换对象的过程中注意：
		// 1,数据库的列名要和hbm映射文件中配置的列名保持一致
		// 2,查询的字段要和对象中属性对应的字段全部配对
		Query query = session.createNativeQuery(sql,ProjectInfo.class);
		// 将查询结果返回
		List<ProjectInfo> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (ProjectInfo prj : list) {
				System.out.println(prj.getProjectId() + "," + prj.getProjectName());
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 多表查询项目信息，返回数组
	 */
	public void queryProjectTwoTable2() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 原生的sql语句查询，要写完整的sql语句，不区分大小写
		String sql = "SELECT P.PROJECT_ID PID,P.PROJECT_NAME,P.PROJECT_CODE,P.PROJECT_UNIT,P.START_TIME,P.END_TIME,P.VOL_TAGE,P.CREATE_USER,P.PROJECT_TOTAL,PF.FEEID,PF.PROJECT_ID,PF.AZFY,PF.JSFY,PF.QTFY FROM PROJECTINFO P,PROJECTFEEINFO PF WHERE P.PROJECT_ID=PF.PROJECT_ID";
		// createNativeQuery方法中有两个参数，参数一：sql语句
		// 返回Object数组，数组中存放select后面对应的字段的值，字段不能重复，如果有重复要使用别名
		Query query = session.createNativeQuery(sql);
		// 将查询结果返回
		List<Object[]> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (Object[] prj : list) {
				System.out.println(prj[0] + "," + prj[1]);
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

}
