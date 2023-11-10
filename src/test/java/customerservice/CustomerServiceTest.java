package customerservice;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("cs")
@DisplayName("Тесты на кастомерсервис")
public class CustomerServiceTest {

    @BeforeEach
    void setup() {
        customerService.customers.clear();
    }

    CustomerService customerService = new CustomerService();


    @Test
    @Tag("2")
    @Tag("1")
    @DisplayName("Должно быть 1 имя")
    void shouldBeOneName() {
        //arrange
        Customer customer = customerService.generateCustomer();
        customerService.customers.add(customer);

        //act
        List<String> allCustomerNames = customerService.getAllCustomerNames();

        //assert
        assertEquals(1, allCustomerNames.size());
        assertEquals(customer.getName(), allCustomerNames.get(0));
    }

    @Test
    @Disabled
    @Tag("3")
    @DisplayName("Должен быть отсортирован")
    void shouldBeSorted() {
        //arrange
        for (int i = 0; i < 1000; i++) {
            customerService.customers.add(customerService.generateCustomer());
        }

        //act
        List<String> allCustomerNames = customerService.getAllCustomerNames();

        //assert
        assertEquals(allCustomerNames.stream().sorted().toList(), allCustomerNames);
    }

    @Test
    @Tag("4")
    void shouldFindByPhone() {
        //arrange
        Customer customer = customerService.generateCustomer();
        customerService.customers.add(customer);

        //act
        List<Customer> customersByPhone = customerService.getCustomersByPhone(customer.getPhone());

        //assert
        assertEquals(List.of(customer), customersByPhone);
    }

    @Test
    @Tag("4")
    void shouldNotFindByPhone(){
        //arrange
        Customer customer = customerService.generateCustomer();
        customerService.customers.add(customer);

        Customer customer2 = customerService.generateCustomer();

        //act
        List<Customer> customersByPhone = customerService.getCustomersByPhone(customer2.getPhone());

        //assert
        assertEquals(0, customersByPhone.size());
    }
}
