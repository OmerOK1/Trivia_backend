package com.omer.trivia.tests;

import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.Customer;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.repository.QuestionRepository;
import com.omer.trivia.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@RequiredArgsConstructor
public class EntityTest implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final CustomerRepository customerRepository;
    private void createDataTest() throws Exception {
        //////////  Users    ///////////////////////////////////////////

        Customer customer1 = Customer.builder()
                .country("israel")
                .email("moshe@moshe.moshe")
                .phoneNumber("12345678")
                .customerName("Moshe")
                .build();


        /////////////////////////////////////////////////////////////////
        ////////////    Questions    /////////////////////////////////////
        /////////////////////////////////////////////////////////////////


        Question question1 = Question.builder()
                .questionBody("which of the following isn't a primary color?")
                .option1("red")
                .option3("green")
                .option2("yellow")
                .option4("blue")
                .correctAnswer("green")
                .category(Category.general)
                .difficulty(Difficulty.easy)
                .sourceAPI("mine")
                .build();

        //////////////////////////////////////////////////////////////////
        /////////   printing to console //////////////////////////////////


        System.out.println("Before repository: ");
        System.out.println("customer: " + customer1.toString() + "");
        System.out.println("question: " + question1.toString() + "");


        customerRepository.save(customer1);
        questionRepository.save(question1);

        System.out.println("After repository: " +
                "");

        System.out.println("customers: ");
        customerRepository.findAll().forEach(System.out::println);
        System.out.println("" + "questions: " + "");
        questionRepository.findAll().forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {
        createDataTest();
    }
}
