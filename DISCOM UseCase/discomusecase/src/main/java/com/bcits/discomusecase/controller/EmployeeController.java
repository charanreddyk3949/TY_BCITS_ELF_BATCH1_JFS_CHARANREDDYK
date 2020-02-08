package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumerSupportRequest;
import com.bcits.discomusecase.beans.ConsumersMasterBean;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.service.ConsumerService;
import com.bcits.discomusecase.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	 private EmployeeService service;
	
	@Autowired
	private ConsumerService servicec;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);	
	}//End of initBinder()
	
	@GetMapping("/employeeLogin")
	public String displayEmployeeLoginForm() {
		
		return "employeeLogin";
		
	}//End of displayEmployeeLoginForm()
	
	@GetMapping("/billGenerationPage")
	public String displayBillGenerationForm() {
		
		return "billGeneration";
		
	}//End of displayBillGenerationForm()
	
	
	@GetMapping("/employeeLogout")
	public String getLogout(HttpSession session,ModelMap  modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "Lougged Out SuccessFully!!");
		
		return "employeeLogin";
		
	}//End of getLogout()
	
	
	@PostMapping("/empLogin")
	public String authenticate(Integer empId, String password,HttpServletRequest req, ModelMap modelMap) {

		EmployeeMaster employeeMaster=service.authenticate(empId, password);
		
		
		if (employeeMaster != null) {
			//Valid credentials
			HttpSession session= req.getSession(true);
			session.setAttribute("loggedinEmpInfo", employeeMaster);
			
			EmployeeMaster master=service.getEmployeedetails(empId);
			if (master != null) {
				modelMap.addAttribute("employeeDetails", master);
			}else {
				modelMap.addAttribute("msg", "No Employee Details Found");
			}	
			return "employeeHome";	
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "employeeLogin";
		}
	}//End of authenticate()
	
	
	//@RequestMapping(path = "/getConsumers" ,method = RequestMethod.GET)
	@GetMapping("/employeeConsumerDetails")
	public String getAllConsumers(HttpSession session,ModelMap modelMap) {
		EmployeeMaster employeemaster=(EmployeeMaster) session.getAttribute("loggedinEmpInfo");
		
		if (session.isNew()) {
			session.invalidate();
             modelMap.addAttribute("errMsg", "Please Login first");
			
			return "empLogin";
			}else {
				if(employeemaster != null) {
			   //Valid Session
			   String region=employeemaster.getRegion();
	           List<ConsumersMasterBean> masterBean= service.getemployeeConsumers(region);
	           
	           modelMap.addAttribute("consumerDetails",masterBean);
	           return "employeeHome";
			   }else {
				modelMap.addAttribute("errMsg", "No consumers in this region");
				return "employeeHome";
			   }
			   
		}
		
	}//End of getAllEmployes()
	@GetMapping("/consumerBillGeneration")
	public String getAllConsumersBillGeneration(HttpSession session,ModelMap modelMap) {
		EmployeeMaster employeemaster=(EmployeeMaster) session.getAttribute("loggedinEmpInfo");
		
		if (session.isNew()) {
			session.invalidate();
             modelMap.addAttribute("errMsg", "Please Login first");
			
			return "employeeLogin";
			}else {
				if(employeemaster != null) {
			   //Valid Session
			   String region=employeemaster.getRegion();
	           List<ConsumersMasterBean> masterBean= service.getemployeeConsumers(region);
	           
	           modelMap.addAttribute("consumerBillDetails",masterBean);
	           return "employeeHome";
			   }else {
				modelMap.addAttribute("errMsg", "No consumers in this region");
				return "employeeHome";
			   }
			   
		}
		
	}//End of getAllConsumersBillGeneration()
	
	@GetMapping("/getBillInputDetails")
	public String setRrNumAndFinalReading(String rrNumber,@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeMaster employeeMaster,ModelMap modelMap,HttpSession session) {
		
	   if (employeeMaster != null) {
		   ConsumersMasterBean consumersMasterBean=service.getConsumer(rrNumber);
//		   Double finalReading=service.getFinalReading(rrNumber);
		   CurrentBill currentBill=servicec.getBill(rrNumber);
		   if (consumersMasterBean != null) {
			   session.setAttribute("finalreadingValue", currentBill);
			 modelMap.addAttribute("consumerDetails", consumersMasterBean);
			 modelMap.addAttribute("finalreadingValue", currentBill); 
		   }
		   return "billGeneration";
		
	}else {
		modelMap.addAttribute("errMsg", "Please Login First");
		return "employeeLogin";
	}
	
	}//End of setRrNumAndFinalReading()
	
	@PostMapping("/billGeneration")
	public String getGenerateBillAmount(Date dueDate,Date initialDate,CurrentBill currentBill,@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeMaster employeeMaster,ModelMap modelMap,HttpSession session) {
		
		if (employeeMaster != null) {
			CurrentBill getCurrentBill=(CurrentBill) session.getAttribute("finalreadingValue");
			currentBill.setRrNumber(getCurrentBill.getRrNumber());
			currentBill.setInitialReading(getCurrentBill.getPresentReading());
			
			boolean currentBill2=service.getBillGenerator(dueDate, currentBill);
					
             if (currentBill2 ) {
				modelMap.addAttribute("msg","Bill is Generated Successfully!!!");
			    }
             return "employeeHome";
		}else {
			modelMap.addAttribute("errMsg", "Bill generation is failed Please try again.");
			
			return "employeeHome";
		  }
		
		
		
	}//getGenerateBillAmount()
	
	@GetMapping("/getBillHistory")
	public String getBillHistory(BillHistory billHistory,HttpSession session,@SessionAttribute (name = "loggedinEmpInfo",required = false) EmployeeMaster employeeMaster,ModelMap modelMap) {
		
		if (employeeMaster != null) {
		        CurrentBill currentBill =(CurrentBill) session.getAttribute("finalreadingValue");
			List<BillHistory> history=servicec.getBillHistory(currentBill.getRrNumber());
			if (history != null) {
				modelMap.addAttribute("billHistoryDetails", history);
			}else {
				modelMap.addAttribute("errMsg", "No previous Bill present.");
			}
			return "employeeHome";
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "employeeLogin";
		}
		
	}//End of getBillhistory()
	

	@GetMapping("/displayRequests")
	public String getAllRequests(HttpSession session,@SessionAttribute(name = "loggedinEmpInfo",required = false)EmployeeMaster employeeMaster,ModelMap modelMap) {
		if (employeeMaster != null) {
			EmployeeMaster master=(EmployeeMaster) session.getAttribute("loggedinEmpInfo");
			List<ConsumerSupportRequest> consumerSupportRequest=service.getAllRequests(master.getRegion());
			if (consumerSupportRequest != null) {
				modelMap.addAttribute("consumerRequestList", consumerSupportRequest);
			}else {
				modelMap.addAttribute("errMsg", "No Requests Found");
			}
			return "employeeHome";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "employeeLogin";
		}
	}
	
}//End of controller
