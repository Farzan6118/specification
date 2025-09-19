package com.example.specification.config;

import com.example.specification.enums.AddressType;
import com.example.specification.model.Address;
import com.example.specification.model.Employee;
import com.example.specification.repository.AddressRepository;
import com.example.specification.repository.EmployeeRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final Faker faker = new Faker();
    @Value("${system.default.uuid}")
    private String systemUuid;

    public DataLoader(EmployeeRepository employeeRepository,
                      AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) {
        loadEmployeesWithAddresses();
    }

    private void loadEmployeesWithAddresses() {
        long count = employeeRepository.count();
        long maxEmployeeSize = 20;

        if (count >= maxEmployeeSize) return; // اگر تعداد >= 20 بود، کاری انجام نمی‌دهد

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < Math.max(maxEmployeeSize - count, 0); i++) {
            Employee e = new Employee();
            e.setFirstname(faker.name().firstName());
            e.setLastname(faker.name().lastName());
            e.setUsername(faker.idNumber().valid());
            e.setEmail(faker.internet().emailAddress());
            e.setPhoneNumber(faker.phoneNumber().cellPhone());
            e.setNationalCode(faker.idNumber().valid());
            e.setSalary(BigDecimal.valueOf(faker.number().numberBetween(3000, 10000)));
            e.setEmploymentDate(LocalDateTime.now().minusDays(faker.number().numberBetween(0, 365 * 5)));
            e.setCreatedBy(UUID.fromString(systemUuid));
            e.setLastModifiedBy(UUID.fromString(systemUuid));

            // ایجاد بین 1 تا 5 Address برای هر Employee
            int addressCount = faker.number().numberBetween(1, 6);
            List<Address> addresses = new ArrayList<>();
            for (int j = 0; j < addressCount; j++) {
                Address a = new Address();
                a.setName(faker.name().fullName());
                a.setTitle(faker.company().name());
                a.setCountry(faker.country().name());
                a.setProvince(faker.address().state());
                a.setCity(faker.address().city());
                a.setStreet(faker.address().streetAddress());
                a.setFloor(faker.number().numberBetween(1, 10));
                a.setBuildingNumber(faker.number().numberBetween(1, 200));
                a.setUnitNumber(faker.number().numberBetween(1, 20));
                a.setPostalCode(faker.address().zipCode());
                a.setAddressType(faker.options().option(AddressType.class));
                a.setIsDefault(faker.bool().bool());
                a.setCreatedBy(UUID.fromString(systemUuid));
                a.setLastModifiedBy(UUID.fromString(systemUuid));
                addresses.add(a);
            }

            e.setAddress(addresses); // اضافه کردن لیست Address به Employee
            employees.add(e);
        }

        // با Cascade.ALL، Address ها همراه Employee ذخیره می‌شوند
        employeeRepository.saveAll(employees);
    }
}
