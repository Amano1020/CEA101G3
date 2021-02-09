package com.emp.model;

import java.util.HashSet;
import java.util.Set;

import com.emp_func.model.EmpFuncVO;

public class EmpVO implements java.io.Serializable{
	private String emp_id;
	private String emp_user_id;
	private String emp_user_pwd;
	private String emp_name;
	private Integer emp_status;
	
	private Set<EmpFuncVO> empFuncs = new HashSet<EmpFuncVO>();
	

	public Set<EmpFuncVO> getEmpFuncs() {
		return empFuncs;
	}
	public void setEmpFuncs(Set<EmpFuncVO> empFuncs) {
		this.empFuncs = empFuncs;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_user_id() {
		return emp_user_id;
	}
	public void setEmp_user_id(String emp_user_id) {
		this.emp_user_id = emp_user_id;
	}
	public String getEmp_user_pwd() {
		return emp_user_pwd;
	}
	public void setEmp_user_pwd(String emp_user_pwd) {
		this.emp_user_pwd = emp_user_pwd;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_status() {
		return emp_status;
	}
	public void setEmp_status(Integer emp_status) {
		this.emp_status = emp_status;
	}
	
	
}
