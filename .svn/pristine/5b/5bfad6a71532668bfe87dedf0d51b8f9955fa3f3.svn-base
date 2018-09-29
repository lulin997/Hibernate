package com.wangqingbo.test;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.wangqingbo.entity.ProjectFeeInfo;
import com.wangqingbo.entity.ProjectInfo;
import com.wangqingbo.util.HibernateUtil;

/**
 * hql测试类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class HqlTest {

	public static void main(String[] args) {
		HqlTest t = new HqlTest();
		 t.queryAllProjects();
		// t.queryProjectsPartColum();
		// t.queryProjectsByParams3();
		 //t.queryFunc1();
		 //t.queryProjectPage("马",1);
		// t.delProject();
		//t.saveFeeInfo();
		//t.queryProjectAndFee1();
		 //t.queryProjectsPartColum();
	}

	/**
	 * 查询所有的项目信息
	 */
	public void queryAllProjects() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写,order by  后面不区分大小写
		String hql = "From ProjectInfo ORDER BY projectTotal DESC";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql, ProjectInfo.class);
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
	 * 查询所有的项目信息，只查询部分字段，不推荐使用这种方式
	 */
	public void queryProjectsPartColum() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写
		// select后面跟对象的属性名
		String hql = "select projectId,projectName,projectCode From ProjectInfo";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql);
		// 将查询结果返回,list中存放的是数组，数组中元素对应select后面属性的值
		List<Object[]> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (Object[] prj : list) {
				System.out.println(prj[0]);
				System.out.println(prj[1]);
				System.out.println(prj[2]);
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 查询所有的项目信息，带条件查询
	 */
	public void queryProjectsByParams() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写，where后面跟对象的属性
		// “?”后面跟数字，自己定义占位符的位置,如果有多个参数，？后面的数字要连续
		// ? 后面不能出现字母，一定是数字
		String hql = "From ProjectInfo where projectId = ?1 or projectCode = ?2 ";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略

		Query query = session.createQuery(hql, ProjectInfo.class);
		// 给参数赋值
		query.setParameter(1, "4028801f65f636f10165f636f78d0000");
		query.setParameter(2, "Tee2");
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
	 * 查询所有的项目信息，带条件查询
	 */
	public void queryProjectsByParams2() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写，where后面跟对象的属性
		// :变量，变量的名称自己定义
		// :后面不能直接跟数字
		String hql = "From ProjectInfo where projectId = :prjId or projectCode = :prjCode ";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql, ProjectInfo.class);
		// 给参数赋值,参数一：hql语句中自己定义的占位符变量，要去掉“：”
		query.setParameter("prjId", "4028801f65f636f10165f636f78d0000");
		query.setParameter("prjCode", "Tee2");
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
	 * 查询所有的项目信息，带条件查询
	 */
	public void queryProjectsByParams3() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写，where后面跟对象的属性
		// :变量，变量的名称自己定义
		// :后面不能直接跟数字
		// String hql = "From ProjectInfo where projectId = ?1 or projectCode =
		// :prjCode ";
		String hql = "From ProjectInfo where projectId = :prjId or projectCode = :prjCode or projectName like :prjName ";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql, ProjectInfo.class);
		// 给参数赋值,参数一：hql语句中自己定义的占位符变量，要去掉“：”
		query.setParameter("prjId", "4028801f65f636f10165f636f78d0000");
		query.setParameter("prjCode", "Tee2");
		query.setParameter("prjName", "%事%");
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
	 * 函数查询，查询总数 分组函数的返回值，跟数据库中字段类型有关 count : Long avg : Double sum : Double
	 * max/min : Double
	 * 
	 */
	public void queryFunc1() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写，where后面跟对象的属性
		// 函数名不区分大小写,总数 返回Long类型
		// String hql = "select count(*) from ProjectInfo ";
		// 平均数,空值不参与运算 返回Double类型
		// String hql = "select avg(projectTotal) from ProjectInfo ";
		// 和,空值不参与运算 返回Double类型
		// String hql = "select sum(projectTotal) from ProjectInfo ";
		// 最大,空值不参与运算 返回Double类型
		String hql = "select max(projectTotal) from ProjectInfo group by Project_Code ";

		// 创建一个查询对象,参数一：hql语句
		Query query = session.createQuery(hql);
		// 将查询结果返回，返回唯一的一个结果对象
		//Integer prjCount = (Integer) query.uniqueResult();
		List<Object> list = query.list();
		// 输出
		System.out.println(list.size());
		
		
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 分页查询
	 */
	public void queryProjectPage(String prjName, int currentPage) {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写
		String hql = "from ProjectInfo where 1=1 ";
		// 查询条件成立
		if (prjName != null && prjName.trim().length() > 0) {
			hql += " and ProjectName like ?1 ";
		}
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql, ProjectInfo.class);
		// 设置参数
		// 查询条件成立
		if (prjName != null && prjName.trim().length() > 0) {
			query.setParameter(1, "%" + prjName + "%");
		}

		// 设置分页查询的条件
		// 设置分页的数据开始行
		query.setFirstResult((currentPage - 1) * 10);
		// 每页显示的数据条数
		query.setMaxResults(10);
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
	 * 更新数据
	 */
	public void updateProject() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		// hql,操作的是对象，对象区分大小写，关键字不区分大小写
		String hql = "update ProjectInfo set projectName = ?1  where projectId = ?2 ";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql);
		// 设置参数
		query.setParameter(1, "20180925修改项目名称");
		query.setParameter(2, "40288001660e7f5601660e7f592f0000");
		// 执行更新，返回数据更新的数据条数
		int num = query.executeUpdate();
		// 提交事务
		tx.commit();
		System.out.println("数据更新条数：" + num);
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 删除数据
	 */
	public void delProject() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 打开事务
		Transaction tx = session.beginTransaction();
		// hql,操作的是对象，对象区分大小写，关键字不区分大小写
		String hql = "delete from  ProjectInfo where projectId = ?2 ";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql);
		// 设置参数
		query.setParameter(2, "40288001660e7f5601660e7f592f0000");
		// 执行更新，返回数据更新的数据条数
		int num = query.executeUpdate();
		// 提交事务
		tx.commit();
		System.out.println("数据删除条数：" + num);
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 保存项目的费用信息
	 */
	public void saveFeeInfo() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 事务
		Transaction tx = session.beginTransaction();
		// hql,操作的是对象，对象区分大小写，from不区分大小写
		String hql = "From ProjectInfo";
		// 创建一个查询对象,参数一：hql语句，参数2：要返回的对象，可以省略
		Query query = session.createQuery(hql, ProjectInfo.class);
		// 将查询结果返回
		List<ProjectInfo> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (ProjectInfo prj : list) {
				// 插入费用信息
				ProjectFeeInfo fee = new ProjectFeeInfo();
				// 设置费用信息的项目id，关联项目信息表中的项目id
				fee.setProjectId(prj.getProjectId());
				fee.setAzfy(234.12);
				fee.setJsfy(332.93);
				fee.setJsfy(453.23);
				// 保存数据
				session.save(fee);
			}
		}
		// 提交事务
		tx.commit();
		// 关闭session
		HibernateUtil.closeSession();
	}

	/**
	 * 输出项目的项目名称和单项费用
	 */
	public void queryProjectAndFee() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写
		String hql = "From ProjectInfo p, ProjectFeeInfo pf where p.projectId = pf.projectId";
		// 创建一个查询对象,参数一：hql语句
		Query query = session.createQuery(hql);
		// 将查询结果返回,列表中存放的是对象数组
		// 数组中的元素和hql语句中from后面的对象一致的
		// 数组中 0：ProjectInfo    1：ProjectFeeInfo 
		// 如果还有多个对象，按照顺序，依次往后排
		List<Object[]> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (Object[] obj : list) {
				// 数组中 0 ： ProjectInfo，需要强制转换
				ProjectInfo prj = (ProjectInfo)obj[0];
				// 数组中 1 ： ProjectFeeInfo，需要强制转换
				ProjectFeeInfo fee = (ProjectFeeInfo)obj[1];
				System.out.println("项目名称：" + prj.getProjectName());
				System.out.println("安装费用：" + fee.getAzfy());
				System.out.println("建设费用：" + fee.getJsfy());
				System.out.println("其他费用：" + fee.getQtfy());
				System.out.println("*******************************************");
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}
	
	/**
	 * 输出项目的项目名称和单项费用,只查询部分字段
	 */
	public void queryProjectAndFee1() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// hql,操作的是对象，对象区分大小写，from不区分大小写,如果要增加查询字段，最好添加在最后面
		String hql = "select p.projectName,pf.azfy,pf.jsfy,pf.qtfy From ProjectInfo p, ProjectFeeInfo pf where p.projectId = pf.projectId";
		// 创建一个查询对象,参数一：hql语句
		Query query = session.createQuery(hql);
		// 将查询结果返回,列表中存放的是对象数组
		// 数组中的元素和hql语句中from后面的字段对应的值
		// 数组中 0：projectName    1：azfy  2： jsfy  3：qtfy
		// 如果还有多个字段，按照顺序，依次往后排
		List<Object[]> list = query.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (Object[] obj : list) {
				System.out.println("项目名称：" + obj[0]);
				System.out.println("安装费用：" + obj[1]);
				System.out.println("建设费用：" + obj[2]);
				System.out.println("其他费用：" + obj[3]);
				System.out.println("*******************************************");
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

}
