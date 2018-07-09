package com.shuyi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shuyi.model.Admin;
import com.shuyi.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * 登录跳转
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/login")
	public String loginGet(Model model) {
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param admin
	 * @param model
	 * @param httpSession
	 * @return
	 */
	@PostMapping("/admin/login")
	public String loginPost(Admin admin, Model model, HttpSession httpSession) {
		Admin adminRes = adminService.findByNameAndPassword(admin);
		if (adminRes != null) {
			httpSession.setAttribute("admin", adminRes);
			model.addAttribute("admin",adminRes);
//			return "redirect:dashboard";
			return "dashboard";
		} else {
			model.addAttribute("error", "用户名或密码错误，请重新登录！");
			return "login";
		}
	}

	/**
	 * 注册
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/register")
	public String register(Model model) {
		return "register";
	}

	/**
	 * 注册
	 * @return
	 */
	@RequestMapping("/admin/registerAdmin")
	public String registerAdmin(Admin admin,boolean agree,Model model){
		if(!agree){
			model.addAttribute("error", "请同意该协议！");
			return "register";
		}
		Admin adminRes = adminService.findByName(admin);
		if (adminRes != null) {
			model.addAttribute("error", "该用户名已存在，请重新注册！");
			return "register";
		} else {
			adminService.insert(admin);
			model.addAttribute("error", "注册成功！");
			return "login";
		}
	}

	/**
	 * 仪表板页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/dashboard")
	public String dashboard(Model model,HttpSession httpSession) {
		Admin admin = (Admin)httpSession.getAttribute("admin");
		model.addAttribute("admin",admin);
		return "dashboard";
	}
}
