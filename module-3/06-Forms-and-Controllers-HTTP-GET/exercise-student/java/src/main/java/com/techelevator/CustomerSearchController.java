package com.techelevator;

import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.model.Customer;
import com.techelevator.dao.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerSearchController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value="/customerList", method = RequestMethod.GET)
    public String showCustomerSearchForm() {
        return "customerList";
    }

    @RequestMapping(value="/customerList/search", method = RequestMethod.GET)
    public String searchCustomers(@RequestParam String name, @RequestParam String order, ModelMap modelHolder) {
        List<Customer> customers = customerDao.searchAndSortCustomers(name, order);
        modelHolder.put("customers", customers);
        return "customerList";
    }
}