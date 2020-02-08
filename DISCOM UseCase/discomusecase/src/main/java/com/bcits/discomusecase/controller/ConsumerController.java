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
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.PaymentDetails;
import com.bcits.discomusecase.service.ConsumerService;



@Controller
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	 private ConsumerService service;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);	
	}//End of initBinder()
	
	@GetMapping("/homePage")
	public String displayHomePage() {
		
		return "homePage";
		
	}//End of homePage()
	
	@GetMapping("/consumerLogin")
	public String displayForm() {
		
		return "consumerLogin";
		
	}//End of displayForm()
	
	
	
	@GetMapping("/consumerSignup")
	public String displayConsumerSignup() {
		
		return "consumerSignup";
		
	}//End of homePage()
	
	@GetMapping("/paymentPage")
	public String displayPaymentPage() {
		
		return "paymentPage";
		
	}//End of paymentPage()
	
	@GetMapping("/paymentSuccessPage")
	public String displayPaymentSuccessPage() {
		
		return "paymentSuccessPage";
		
	}//End of paymentPage()
	
	@GetMapping("/updateConsumerForm")
	public String displayUpdateForm() {
		return "updateConsumer";
	}//End of displayUpdateEmployee()
	
	@GetMapping("/consumerQueriesForm")
	public String displayconsumerQueriesForm() {
		return "commentsForm";
	}//End of displayUpdateEmployee()

	
	@PostMapping("/login")
	public String authenticate(String rrNumber, String password,HttpServletRequest req, ModelMap modelMap) {

		ConsumersMasterBean consumersMasterBean=service.authenticate(rrNumber, password);
		ConsumersMasterBean masterBean=service.getConsumer(consumersMasterBean.getRrNumber());
		if (consumersMasterBean != null) {
			//Valid credentials
			HttpSession session= req.getSession(true);
			session.setAttribute("loggedinEmpInfo", consumersMasterBean);
//			session.setAttribute("consumerDetails", masterBean);
			return "consumerHome";	
		}else {
			//Invalid credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials");
			return "consumerLogin";
		}
	}//End of authenticate()
	
	
	@GetMapping("/getConsumer")
	public String getConsumer(@SessionAttribute(name = "loggedinEmpInfo", required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap) {
		if (consumersMasterBean != null) {
			
			ConsumersMasterBean masterBean=service.getConsumer(consumersMasterBean.getRrNumber());
			if (masterBean != null) {
				modelMap.addAttribute("consumerDetails", masterBean);
			}else {
				modelMap.addAttribute("msg", "Consumer Details Not Found");
			}
			return "consumerHome";
		}else {
			modelMap.addAttribute("errMsg", "Please Login first");
			
			return "consumerLogin";
		}
	}
	
	@PostMapping("/addConsumer")
	public String addConsumer(@SessionAttribute(name = "loggedinEmpInfo",required = false) ConsumersMasterBean consumersMasterBean,ModelMap modelMap, ConsumersMasterBean consumersBean2) {

			
			if(service.addConsumer(consumersBean2)){
				modelMap.addAttribute("msg", "SignUp Successfully (: Please Login now");
			}else {
				modelMap.addAttribute("errSignupMsg", "Already exist Signin Please:>");
			}
			return "consumerLogin";	
	

	}//End of addConsumer()
	
	@PostMapping("/updateConsumer")
//	@RequestMapping(name = "/updateConsumer", method = RequestMethod.POST)
	public String updateEmp(String rrNumber, @SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap,HttpSession session,ConsumersMasterBean consumersMasterBean2) {
		
		if(consumersMasterBean != null) {
			 if(service.updateConsumer(consumersMasterBean2)) {
				 modelMap.addAttribute("msg", "Consumer is Updated successfully!!!");
			 }else {
				modelMap.addAttribute("errMsg", "Consumer Details Not Found");
			}
			return "consumerHome";
		}else {
			modelMap.addAttribute("errMsg", "Please login first ...");
			return "updateConsumer";
		}
		
	}//End of updateEmp()
	
	@GetMapping("/delete")
	public String  deleteConsumer(int rrNumber,
			@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap) {
		
		if(consumersMasterBean != null) {
		   // valid
			if(service.deleteConsumer(rrNumber)) {
				modelMap.addAttribute("msg", "Consumer Record is Deleted Successfully!");
			}else {
				modelMap.addAttribute("errMsg", "Consumer Id not Found!");
			}
			
			return "consumerLogin";
		}else {
			modelMap.addAttribute("errMsg", "Please Login first");
			return "consumerLogin";
		}
	}// End of DeleteConsumer()
	
	
	
	
	
	
	@GetMapping("/getAllConsumers")
	public String getAllConsumers(@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,HttpSession session, ModelMap modelMap) {
		
		if (consumersMasterBean != null) {
			//valid session
			List<ConsumersMasterBean> consumersMasterBeans1=service.getAllConsumers();
			if (consumersMasterBeans1 != null) {
				modelMap.addAttribute("employeeDetails", consumersMasterBeans1);
				
				
				return "getAllConsumers";			
			}else {
				modelMap.addAttribute("errMsg", "Consumer details Not found!");
				
				return "getAllConsumers";
			}
			  
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First...");
			
			return "consumerLogin";
		}
	}//End of getAllConsumers
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap  ) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "you are logged out successfully!!");
		
		return "consumerLogin";
	}//End of logged out

	
	
	@GetMapping("/getCurrentBill")
	public String getBill(HttpSession session,@SessionAttribute(name = "loggedinEmpInfo" ,required = false)ConsumersMasterBean bill,ModelMap modelMap) {
		
		if(bill != null) {
			ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean)session.getAttribute("loggedinEmpInfo");
		 CurrentBill currentBill= service.getBill(consumersMasterBean.getRrNumber());
		ConsumersMasterBean consumersMasterBean2=service.getConsumer(bill.getRrNumber());	
			if (currentBill != null) {
				modelMap.addAttribute("currentBillDetails", currentBill);
//				modelMap.addAttribute("consumerMasterBean", consumersMasterBean2);
				return "consumerHome";
			}else {
				modelMap.addAttribute("errMsg", "New User Bill is Not yet  generated");
			}
			return "consumerHome";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
		}//End of getBill
	
	@GetMapping("/getBillHistory")
	public String getBillHistory(HttpSession session,@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean history,ModelMap modelMap) {
	   
		if(history != null) {
			ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean) session.getAttribute("loggedinEmpInfo");
		List<BillHistory> billHistory= service.getBillHistory(consumersMasterBean.getRrNumber());
	   
		if (billHistory != null) {	
			modelMap.addAttribute("billHistory", billHistory);
			return "consumerHome";
		}else {
			modelMap.addAttribute("errMsg", "New Consumer no prevous bills present");
			return "consumerHome";
		}
		}else {
			modelMap.addAttribute("errMsg", "Please Login First");
			return "consumerLogin";
		}
	}//End of getBillHistory()
	
	@GetMapping("/paymentDetails")
	public String paymentDetails(String rrNumber,ModelMap modelMap) {
	   PaymentDetails paymentDetails=service.getPaymentDetails(rrNumber);
	   
		if (paymentDetails != null) {	
			modelMap.addAttribute("paymentInfo", paymentDetails);
			
			return "PaymentDetails";
		}else {
			modelMap.addAttribute("errMsg", "Payment Not SuccessFull");
			return "paymentPage";
		}
	}//End of consumptionHistory()
	
	@GetMapping("/getMontlyConsumptionList")
	public String getMonthlyComsumptionList(@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumption,ModelMap modelMap) {
		if (consumption != null) {
			//Valid Session
			List<MonthlyConsumption> consumptions=service.getMonthlyConsuption();
			if (consumptions != null) {
				modelMap.addAttribute("monthlyConsumptionList", consumptions);
			}else {
				modelMap.addAttribute("msg", "No Monthly Consumptions present");
			}
			return "consumerHome";
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First");
			
			return "consumerLogin";
		}
		
	}
	
	@PostMapping("/addPaymentDetails")
  public String getPaymentDetails(String rrNumber,Date date,Double amtPaid,@SessionAttribute(name = "loggedinEmpInfo",required = false)ConsumersMasterBean consumersMasterBean,ModelMap modelMap) {
	  if (consumersMasterBean != null) {
		  
		  Date date1=new Date();
		 boolean isAdd= service.billPaymentPage(consumersMasterBean.getRrNumber(), date1, amtPaid);
		 if (isAdd) {
			 
			 return "paymentSuccessPage";
		}else {
			modelMap.addAttribute("errMsg", "Payment failed");
		}
		return "paymentPage";
	}else {
		modelMap.addAttribute("errMsg", "Please Login First");
		
		return "consumerLogin";
	}
  }//End of getPaymentDetails()
	
	
	@PostMapping("/addComments")
	public String addComments(HttpSession session,ConsumerSupportRequest consumerSupportRequest,@SessionAttribute(name = "loggedinEmpInfo" ,required = false) ConsumersMasterBean consumersMasterBean ,ModelMap modelMap) {
		
		if (consumersMasterBean != null) {
		    ConsumersMasterBean consumersMasterBean2=(ConsumersMasterBean) session.getAttribute("loggedinEmpInfo");
		    String rrNumber=consumersMasterBean2.getRrNumber();
		    String region=consumersMasterBean2.getRegion();
			if (service.addComments(rrNumber, region, consumerSupportRequest)) {
				modelMap.addAttribute("msg", "Request is posted Successfully!!!");
			}else {
				modelMap.addAttribute("errMsg", "Failed to add the Request");
			}
			return "commentsForm";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First");
			
			return "consumerLogin";
			
		}
	}//End of addComments()
	
}//End of Class
