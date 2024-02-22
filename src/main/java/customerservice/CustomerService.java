package customerservice;

import net.datafaker.Faker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@RestController
public class CustomerService {
    private static final Faker faker = new Faker(new Locale("RU"));
    final List<Customer> customers = new ArrayList<>();

    public CustomerService() {
        customers.addAll(IntStream.range(0, 25).mapToObj(i -> generateCustomer()).toList());
    }

    @GetMapping("/v1/names")
    public List<String> getAllCustomerNames() {
        return customers.stream().map(Customer::getName).sorted().toList();
    }

    @GetMapping("/v1/all")
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/v1/by_phone")
    public List<Customer> getCustomersByPhone(@RequestParam("phone") String phone) {
        return customers.stream().filter(customer -> phone.replaceAll("\\D", "").equals(customer.getPhone().replaceAll("\\D", ""))).toList();
    }

    @PostMapping("/v1/add")
    public boolean addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return true;
    }

    Customer generateCustomer() {
        return new Customer(
                randomUUID(),
                faker.name().nameWithMiddle(),
                faker.phoneNumber().phoneNumberInternational()
        );
    }
}
