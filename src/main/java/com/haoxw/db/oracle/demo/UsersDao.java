package com.haoxw.db.oracle.demo;

import java.util.List;

import com.haoxw.db.oracle.base.OpDao;
import com.haoxw.db.oracle.base.PageModel;

public class UsersDao {

	private static OpDao opDao = new OpDao();

	public boolean Login(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		String sql = "delete from users where id=?";
		Object[] obj = { id };
		return opDao.update(sql, obj, false);
	}

	public boolean delete(String[] userIds) {
		StringBuffer sbStr = new StringBuffer();
		Object[] obj = userIds;
		;
		for (int i = 0; i < userIds.length; i++) {
			sbStr.append("?,");
		}
		String sql = "delete from users where id in("
				+ sbStr.substring(0, sbStr.length() - 1) + ")";
		return opDao.update(sql, obj, false);
	}

	public boolean insert(Users user) {
		String sql = "insert into users(id,name,age) values(?,?,?)";
		Object[] obj = { user.getId(), user.getName(), user.getAge() };
		return opDao.update(sql, obj, false);
	}

	@SuppressWarnings("unchecked")
	public List<Users> query() {
		String sql = "select * from users";
		Object[] obj = {};
		return (List<Users>) opDao.query(sql, obj, new UsersDAOObjectMapper());

	}

	public Users query(String id) {
		String sql = "select * from users where id = ?";
		Object[] obj = {id};
		return (Users) opDao.query(sql, obj, new UsersDAOObjectMapper()).get(0);
	}
	
	public int count() {
		String sql = "select count(*) from users";
		Object[] obj = {};
		return opDao.count(sql, obj);
	}

	public PageModel query(int pageNo, int pageSize) {
		String sql1 = "select * from users";
		Object[] obj1 = {};
		List<Users> list1 = (List<Users>) opDao.query(sql1, obj1,
				new UsersDAOObjectMapper());
		int i = list1.size();
		String sql = "select * from (select j.*,rownum rn from (select * from users) j where rownum<=?) where rn>?";
		Object[] obj = { pageNo * pageSize, (pageNo - 1) * pageSize };
		List<Users> list = (List<Users>) opDao.query(sql, obj,
				new UsersDAOObjectMapper());
		PageModel pagemodel = new PageModel();
		pagemodel.setPageNo(pageNo);
		pagemodel.setPageSize(pageSize);
		pagemodel.setList(list);
		pagemodel.setTotalRecords(i);
		return pagemodel;
	}

	public PageModel query(int pageNo, int pageSize, String condition) {
		String sql1 = "select * from users";
		Object[] obj1 = {};
		List<Users> list1 = (List<Users>) opDao.query(sql1, obj1,
				new UsersDAOObjectMapper());
		int i = list1.size();
		String sql = "select * from (select j.*,rownum rn from (select * from users where id like '"
				+ condition
				+ "%' or name like '"
				+ condition
				+ "%') j where rownum<=?) where rn>?";
		Object[] obj = { pageNo * pageSize, (pageNo - 1) * pageSize };
		List<Users> list = (List<Users>) opDao.query(sql, obj,
				new UsersDAOObjectMapper());
		PageModel pagemodel = new PageModel();
		pagemodel.setPageNo(pageNo);
		pagemodel.setPageSize(pageSize);
		pagemodel.setList(list);
		pagemodel.setTotalRecords(i);
		return pagemodel;
	}

	public boolean update(Users user) {
		String sql = "update users set name=?,age=? where id=?";
		Object[] obj = { user.getName(), user.getAge(), user.getId() };
		return opDao.update(sql, obj, false);
	}

}