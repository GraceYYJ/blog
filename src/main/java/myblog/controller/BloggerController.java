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
@RequestMapping("/blogger") // 请求映射
public class BloggerController {
	@Resource
	private BloggerService bloggerService;
	@Resource
	private BlogService blogService;
	@Autowired // 自动注入
	private BlogMapper blogMapper;

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		String bloggerId = request.getParameter("id");// 接收id
		// int bloggerId = Integer.parseInt(request.getParameter("id"));
		Blogger blogger = this.bloggerService.getBloggerById(bloggerId);// 根据接收到的id，得到符合的blogger对象
		model.addAttribute("blogger", blogger);// blogger键值对，这个操作能让页面取到blogger的值
		return "showUser";// 返回页面showUser
	}

	@RequestMapping("/index")
	public ModelAndView toIndex(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("login");// 将index映射到login.jsp
		return view;
	}

	@RequestMapping("/login2") // jsp页面表单的action对应到这里的login2
	public ModelAndView login(HttpServletRequest request, Model model) {
		// setCharacterEncoding("utf-8")
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String bloggerid = request.getParameter("id");// 接收id（通过页面输入框的name=id接收到）
		String bloggeridutf8 = "";// 定义utf8编码的id
		// bloggerid.getBytes("iso-8859-1"), "utf-8":将bloggerid转为utf-8类型编码的
		try {
			bloggeridutf8 = new String(bloggerid.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String pwd = request.getParameter("pwd");// 接收pwd（通过页面输入框的name=pwd接收到）
		Blogger blogger = this.bloggerService.getBloggerById(bloggeridutf8);// 根据接收到的id，得到符合的blogger对象
		String url = "login";
		// 得到的blogger不是空值并且接收到的pwd和blogger.getPassword相等
		if (blogger != null && pwd.equals(blogger.getPassword())) {
			url = "redirect:/blogger/getAllBlog";
		} else {
			url = "faillogin";
		}
		ModelAndView view = new ModelAndView(url);
		return view;
	}

	@RequestMapping("/toWrite")
	public ModelAndView toWrite(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("writeblog");// 将index映射到login.jsp
		return view;
	}

	@RequestMapping("/tolist")
	public ModelAndView tolist(HttpServletRequest request, Model model) {
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		Blog blog = blogMapper.selectByPrimaryKey(blogid);
		model.addAttribute("blog", blog);
		ModelAndView view = new ModelAndView("blogdetail");// 将index映射到login.jsp
		return view;
	}

	@RequestMapping("/write")
	public ModelAndView writeblog(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String blogtitle = request.getParameter("title");// 通过页面输入框的name=title接收blogtitle
		String blogtype = request.getParameter("type");// 通过页面输入框的name=type接收blogtype
		String blogbody = request.getParameter("inputbox");// 通过页面输入框的name=inputbox接收blogbody
		// 对应上面定义utf8编码的blogtitle、blogtype、blogbody
		String blogtitleutf8 = "";
		String blogtypeutf8 = "";
		String blogbodyutf8 = "";
		Date now = new Date();
		// 字符串转码
//		try {
//			blogtitleutf8 = new String(blogtitle.getBytes("iso-8859-1"), "utf-8");
//			blogtypeutf8 = new String(blogtype.getBytes("iso-8859-1"), "utf-8");
//			blogbodyutf8 = new String(blogbody.getBytes("iso-8859-1"), "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

		Blog blog = new Blog();// new一个blog的model（对应Blog.model中定义的blog对象），model可看为对应数据库的模型
		if (blogtitle != null && blogtype != null) {
			// 利用Blog模型对应的set方法为blog对象赋值
			blog.setTitle(blogtitle);
			blog.setArticletype(blogtype);
			blog.setArticlebody(blogbody);
			blog.setPubtime(now);
			// blogMapper对应数据库的增删改查操作，利用insert方法将blog对象的值对应插入到数据库中
			blogMapper.insert(blog);
		}
		model.addAttribute("blog", blog);// blog键值对，这个操作能让页面取到blog的值
		ModelAndView view = new ModelAndView("blogdetail.jsp?id=" + blog.getBlogid());// 页面链接传参
		return view;
	}

	@RequestMapping("/getAllBlog") // 请求映射
	public ModelAndView getAllBlog(HttpServletRequest request, Model model) {
		List<Blog> blogs = new ArrayList<Blog>();// new一个ArrayList的对象blogs，对象中每个元素都是一个blog对象
		blogs = this.blogService.getAllBlog();// 获取到所有的blog对象，放入blogs中
		// 或者用ModelAndView view = new ModelAndView("../../jsp/bloglist);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bloglist");// 设置这个请求对应的页面
		// 或者用model.addAttribute("blogs", blogs);
		modelAndView.addObject("blogs", blogs);// 这个操作能让页面取到blogs的值
		return modelAndView;
	}

	@RequestMapping("/toUpdateBlog")
	public ModelAndView toUpdateBlog(HttpServletRequest request, Model model) {
		int blogid = Integer.parseInt(request.getParameter("id"));
		// String blogid = request.getParameter("id");//
		// 接收id（通过页面输入框的name=id接收到）
		// String blogidutf8 = "";// 定义utf8编码的id
		// bloggerid.getBytes("iso-8859-1"), "utf-8":将bloggerid转为utf-8类型编码的
		Blog blog = this.blogService.getBlogById(blogid);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("toUpdateBlog");
		modelAndView.addObject("blog", blog);
		return modelAndView;
	}

	@RequestMapping("/UpdateBlog")
	public ModelAndView UpdateBlog(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		int blogid = Integer.parseInt(request.getParameter("id"));
		String blogtitle = request.getParameter("title");// 通过页面输入框的name=title接收blogtitle
		String blogtype = request.getParameter("type");// 通过页面输入框的name=type接收blogtype
		String blogbody = request.getParameter("inputbox");// 通过页面输入框的name=inputbox接收blogbody
		// 对应上面定义utf8编码的blogtitle、blogtype、blogbody
		String blogtitleutf8 = "";
		String blogtypeutf8 = "";
		String blogbodyutf8 = "";
		Date now = new Date();
		// 字符串转码
		try {
			blogtitleutf8 = new String(blogtitle.getBytes("iso-8859-1"), "utf-8");
			blogtypeutf8 = new String(blogtype.getBytes("iso-8859-1"), "utf-8");
			blogbodyutf8 = new String(blogbody.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Blog blog = new Blog();// new一个blog的model（对应Blog.model中定义的blog对象），model可看为对应数据库的模型
		if (blogtitle != null && blogtype != null) {
			// 利用Blog模型对应的set方法为blog对象赋值
			blog.setBlogid(blogid);
			blog.setTitle(blogtitleutf8);
			blog.setArticletype(blogtypeutf8);
			blog.setArticlebody(blogbodyutf8);
			blog.setPubtime(now);
			// blogMapper对应数据库的增删改查操作，利用insert方法将blog对象的值对应插入到数据库中
			blogMapper.updateByPrimaryKeyWithBLOBs(blog);
		}
		model.addAttribute("blog", blog);// blog键值对，这个操作能让页面取到blog的值
		ModelAndView view = new ModelAndView("blogdetail.jsp?id=" + blog.getBlogid());// 页面链接传参
		return view;
	}

	@RequestMapping("/delBlog")
	public ModelAndView delBlog(HttpServletRequest request, Model model) {
		int blogid = Integer.parseInt(request.getParameter("id"));
		blogMapper.deleteByPrimaryKey(blogid);
		String url = "redirect:/blogger/getAllBlog";
		ModelAndView view = new ModelAndView(url);
		return view;
	}

}
