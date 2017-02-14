package test.controller;  
  
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
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        return "showUser";          
    } 
	 @RequestMapping("/index")  
	    public ModelAndView toIndex(HttpServletRequest request){  
		 ModelAndView view = new ModelAndView("login");
		return view;
} 
	 @RequestMapping("/login2")  
	 public ModelAndView login(HttpServletRequest request,Model model){
		 String username = request.getParameter("name");
		 String pwd = request.getParameter("pwd");
		 User user = this.userService.getUserByName(username);
		 String url="login";
		 if(user!=null&&pwd.equals(user.getPassword())){
			 url="successlogin";
		 }else{
			 url="faillogin";
		 }
		 ModelAndView view = new ModelAndView(url);
		 return view;
	 } 
}  

