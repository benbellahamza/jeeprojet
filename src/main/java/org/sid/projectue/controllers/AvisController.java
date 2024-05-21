package org.sid.projectue.controllers;

import jakarta.validation.Valid;
import org.sid.projectue.entities.Customer;
import org.sid.projectue.enums.CustomerState;
import org.sid.projectue.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AvisController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/createCustomer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "CreateCustomer";
    }

    @RequestMapping("/saveCustomer")
    public String saveCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "CreateCustomer";
        customer.setCustomerState(CustomerState.Active);
        Customer saveCustomer = customerService.saveCustomer(customer);
        return "CreateCustomer";
    }

    @RequestMapping("/customersList")
    public String customersList(ModelMap modelMap,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "6") int size) {
        Page<Customer> customers = customerService.getAllCustomersByPage(page, size);
        modelMap.addAttribute("customers", customers);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[customers.getTotalPages()]);
        return "CustomersList";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "3") int size) {
        customerService.deleteCustomerById(id);
        Page<Customer> customers = customerService.getAllCustomersByPage(page, size);
        modelMap.addAttribute("customers", customers);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[customers.getTotalPages()]);
        return "CustomersList";
    }

    @RequestMapping("/editCustomer")
    public String editCustomer(@RequestParam("id") Long id, ModelMap modelMap) {
        Customer customer = customerService.getCustomerById(id);
        modelMap.addAttribute("customer", customer);
        return "EditCustomer";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customersList"; // Redirige vers la liste des clients après la mise à jour
    }
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome"; // Cela renvoie vers le fichier welcome.html
    }
}
