package test.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import test.model.User;
import test.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/index")
	public ModelAndView toIndex(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

	@RequestMapping("/login2")
	public ModelAndView login(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String username = request.getParameter("name");
		String usernameutf8 = "";
		try {
			usernameutf8 = new String(username.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwd = request.getParameter("pwd");
		User user = this.userService.getUserByName(usernameutf8);
		String url = "login";
		if (user != null && pwd.equals(user.getPassword())) {
			url = "successlogin";
		} else {
			url = "faillogin";
		}
		ModelAndView view = new ModelAndView(url);
		return view;
	}
}
