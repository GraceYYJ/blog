package myblog.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myblog.model.Blogger;
import myblog.service.BloggerService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Resource
	private BloggerService bloggerService;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		String bloggerId=request.getParameter("id");
		//int bloggerId = Integer.parseInt(request.getParameter("id"));
		Blogger blogger = this.bloggerService.getBloggerById(bloggerId);
		model.addAttribute("blogger", blogger);
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
			e1.printStackTrace();
		}
		String bloggerid = request.getParameter("id");
		String usernameutf8 = "";
		try {
			usernameutf8 = new String(bloggerid.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String pwd = request.getParameter("pwd");
		Blogger blogger = this.bloggerService.getBloggerById(usernameutf8);
		String url = "login";
		if (blogger!= null && pwd.equals(blogger.getPassword())) {
			url = "successlogin";
		} else {
			url = "faillogin";
		}
		ModelAndView view = new ModelAndView(url);
		return view;
	}
}
