package com.tasklist.TaskList;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tasklist.TaskList.dao.TaskRepo;
import com.tasklist.TaskList.dao.UserRepo;
import com.tasklist.TaskList.entity.Task;
import com.tasklist.TaskList.entity.User;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepo taskRepo;
	
	@Autowired
	UserRepo userRepo;

	@RequestMapping("/")
	public ModelAndView login() {
	ModelAndView mv = new ModelAndView("index");
	mv.addObject("tag", "task list login");
	return mv;
	}
	
	@PostMapping("/home")
	public ModelAndView home (@RequestParam("id") int id, @RequestParam("pw") String pw) {
		ModelAndView hv = new ModelAndView("homepage");
		hv.addObject("tag", id);
		User user = userRepo.findByIduserAndPassword(id, pw);
		if (user != null) {
			hv.addObject("list", user.getTasks());
			hv.addObject("userId", id);
		} else {
			ModelAndView nope = new ModelAndView("index");
			nope.addObject("tag", "try again");
			return nope;
		}
		return hv;
	}
	
	@PostMapping("addtask")
	public ModelAndView newtask(@RequestParam("iduser") String idString) {
		int id = Integer.parseInt(idString);
		ModelAndView addTask = new ModelAndView("new-task");
		addTask.addObject("id", id);
		return addTask;
	}
	
	@PostMapping("/create")
	public ModelAndView create (@RequestParam("iduser") int id, @RequestParam("desc") String taskDesc, @RequestParam("date") Date taskDate) {
		ModelAndView tv = new ModelAndView("homepage");
		tv.addObject("tag", "updated homepage");
		User user = userRepo.findById(id).orElse(null);
		Task task = new Task(taskDesc, taskDate, false, id, user);
		taskRepo.save(task);
		tv.addObject("list", user.getTasks());
		return tv;
	}
}
