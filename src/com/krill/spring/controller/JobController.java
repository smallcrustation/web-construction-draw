package com.krill.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krill.spring.entity.Draw;
import com.krill.spring.entity.Job;
import com.krill.spring.entity.LineItem;
import com.krill.spring.service.JobService;
import com.krill.spring.service.LineItemService;
import com.krill.spring.service.DrawService;

@Controller
@RequestMapping("/job")
public class JobController {
	
	//@Autowired for Service class('s)
	@Autowired
	private JobService jobService;
	
	@Autowired
	private DrawService drawService;
	
	@Autowired
	private LineItemService lineItemService;
	
	@GetMapping("/list")
	public String home(Model model) {
		// get the job list from dao
		List<Job> jobList = jobService.getJobList();
		
		// push it into the view
		model.addAttribute("jobs", jobList);
		
		return "list-jobs";
	}
	
	@GetMapping("/showFormForAddJob")
	public String showFormForAddJob(Model model) {
		// create a new Job() object
		Job job = new Job();
		
		// give the model the object data it need to generate the form 
		model.addAttribute("job", job);
		
		return "job-form";
	}
	
	@PostMapping("/saveJob")
	public String saveJob(@Valid @ModelAttribute("job")Job job, BindingResult bindingResult) {
		// test binding result
		if (bindingResult.hasErrors()) {
			return "job-form";
		}
		
		else {
			// save job to database through jobService
			jobService.saveJob(job);
		
			return "redirect:/job/list";
		}
	}
	
	@GetMapping("/deleteJob")
	public String deleteJob(@RequestParam("jobId")int jobId) {
		// get job by Id
		Job job = jobService.getJob(jobId);
		
		// delete Id
		jobService.delete(job);
		
		return "redirect:/job/list";
	}
	
	@GetMapping("/jobSelected")
	public String jobSelected(@RequestParam("jobId")int jobId, Model model) {
		// get job
		Job job = jobService.getJob(jobId);

		// pass job info into model
		model.addAttribute("job", job);
		
		return "job-selected";
	}
	
	@GetMapping("/drawSelected")
	public String drawDetails(@RequestParam("drawId")int drawId, Model model) {
		// get draw
		Draw draw = drawService.getDraw(drawId);
		
		// pass draw info into model
		model.addAttribute("draw", draw);
		
		return "draw-selected";
	}
	
	@GetMapping("/showFormForAddDraw")
	public String showFormForAddDraw(@RequestParam("jobId")int jobId, Model model) {
		// create a new draw object
		Draw draw = new Draw();
		// get the job
		Job job = jobService.getJob(jobId);
		
		// give the model the object
		model.addAttribute("draw", draw);
		model.addAttribute("job", job);
		
		return "draw-form";
	}
	
	@PostMapping("/saveDraw")
	public String saveDraw(@RequestParam("jobId") int jobId, 
						@RequestParam("applicationNumber")int applicationNumber,
						@RequestParam("endingPeriod")String endingPeriod){
		
		// set the attributes to draw
		Draw draw = new Draw();
		draw.setApplicationNumber(applicationNumber);
		draw.setEndingPeriod(endingPeriod);
		// connect draw to a job
		draw.setJob(jobService.getJob(jobId));
		
		// save draw to database
		drawService.saveDraw(draw);
		
		// redirect to job list page
		return "redirect:/job/jobSelected?jobId="+jobId;
	}
	
	@GetMapping("/showLineItemForm")
	public String showFormForLineItem(@RequestParam("drawId")int drawId, Model model) {
		// get draw
		Draw draw = drawService.getDraw(drawId);
		
		// make a line item class
		LineItem lineItem = new LineItem();
		
		// give model lineItem & draw
		model.addAttribute("lineItem", lineItem);
		model.addAttribute("draw", draw);
		
		return "line-item-form";
	}
	
	@PostMapping("/showLineItemForm/saveLineItem")
	public String saveLineItem(@ModelAttribute("lineItem")LineItem lineItem, @RequestParam("drawId")int drawId) {
		// get draw
		Draw draw = new Draw();
		draw = drawService.getDraw(drawId);
		
		// connect lineItem to draw
		lineItem.setDraw(draw);
		
		// save lineItem to db
		lineItemService.save(lineItem);
		
		// redirect to draw
		return "redirect:/job/drawSelected?drawId="+lineItem.getDraw().getId();
	}

}
