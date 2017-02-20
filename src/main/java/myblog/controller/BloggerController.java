package myblog.controller;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myblog.dao.BlogMapper;
import myblog.model.Blog;
import myblog.model.Blogger;
import myblog.service.BloggerService;
import myblog.service.BlogService;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
	@Resource
	private BloggerService bloggerService;
	@Resource
	private BlogService blogService;
	@Autowired // 自动注入
	private BlogMapper blogMapper;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		String bloggerId = request.getParameter("id");
		// int bloggerId = Integer.parseInt(request.getParameter("id"));
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
		if (blogger != null && pwd.equals(blogger.getPassword())) {
			url = "successlogin";
		} else {
			url = "faillogin";
		}
		ModelAndView view = new ModelAndView(url);
		return view;
	}

	@RequestMapping("/write")
	public ModelAndView writeblog(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String blogtitle = request.getParameter("title");
		String blogtype = request.getParameter("type");
		String blogbody = request.getParameter("inputbox");
		String blogtitleutf8 = "";
		String blogtypeutf8 = "";
		String blogbodyutf8 = "";
		Date now = new Date();
		try {
			blogtitleutf8 = new String(blogtitle.getBytes("iso-8859-1"), "utf-8");
			blogtypeutf8 = new String(blogtype.getBytes("iso-8859-1"), "utf-8");
			blogbodyutf8 = new String(blogbody.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Blog blog = new Blog();
		if (blogtitle != null && blogtype != null) {

			blog.setTitle(blogtitleutf8);
			blog.setArticletype(blogtypeutf8);
			blog.setArticlebody(blogbodyutf8);
			blog.setPubtime(now);
			blogMapper.insert(blog);
		}
		model.addAttribute("blog", blog);
		ModelAndView view = new ModelAndView("../../jsp/blogdetail.jsp?id=" + blog.getBlogid());
		return view;
	}

	@RequestMapping("/getAllBlog")//请求映射
	public ModelAndView getAllBlog(HttpServletRequest request, Model model) {
		List<Blog> blogs = new ArrayList<Blog>();
		blogs = this.blogService.getAllBlog();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../../jsp/bloglist");
		modelAndView.addObject("blogs", blogs);
		return modelAndView;
	}

}
