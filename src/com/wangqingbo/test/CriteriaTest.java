package com.wangqingbo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.wangqingbo.entity.ProjectInfo;
import com.wangqingbo.util.HibernateUtil;

/**
 * QBC查询
 * 
 * @author Administrator
 *
 */
@SuppressWarnings({ "unchecked", "deprecation" })
public class CriteriaTest {

	public static void main(String[] args) {
		CriteriaTest t = new CriteriaTest();
		t.queryAllProjectByLike();
	}

	/**
	 * 查询全部项目信息
	 */
	public void queryAllProjects() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 创建一个Criteria,一个参数，传实体类对象
		Criteria cri = session.createCriteria(ProjectInfo.class);
		// 返回结果
		List<ProjectInfo> list = cri.list();
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
	 * 查询全部项目信息,条件
	 */
	public void queryAllProjectByParams() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 创建一个Criteria,一个参数，传实体类对象
		Criteria cri = session.createCriteria(ProjectInfo.class);
		// 这是将查询条件分开来写
		// 设置查询条件, 相当于 where propertyName = value
		Criterion c = Restrictions.eq("projectId", "40288001660e7f5601660e7f59cc0002");
		// 把查询条件添加到查询中
		cri.add(c);
		// 返回结果
		List<ProjectInfo> list = cri.list();
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
	 * 查询全部项目信息,条件,模糊查询
	 *  //>  gt
		//< lt
		//= eq
		//>= ge
		//<= le
		//like 
		//between
	 * 
	 */
	public void queryAllProjectByLike() {
		// 拿到session
		Session session = HibernateUtil.currentSession();
		// 创建一个Criteria,一个参数，传实体类对象
		Criteria cri = session.createCriteria(ProjectInfo.class);
		// 使用链式结构来添加查询条件，推荐使用这种方式
		List<ProjectInfo> list = cri.add(Restrictions.like("projectName", "%项目%"))
				// 项目金额大于500
				.add(Restrictions.gt("projectTotal", 500D))
				// 使用项目金额降序排序，使用Order中的desc方法，参数是要排序的属性
				.addOrder(Order.desc("projectTotal"))
				// 设置分页条件，从第10条开始
				.setFirstResult(10)
				// 每页显示的最大条数
				.setMaxResults(8)
				// 返回结果 
				.list();
		// 输出
		if (list != null && list.size() > 0) {
			for (ProjectInfo prj : list) {
				System.out.println(prj.getProjectTotal() + "," + prj.getProjectName());
			}
		}
		// 关闭session
		HibernateUtil.closeSession();
	}

}
