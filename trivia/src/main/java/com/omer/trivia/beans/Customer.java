package com.omer.trivia.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false, length = 30)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, name = "customer_name")
    private String customerName;

    @Column(nullable = false)
    private String country;

    /*@OneToMany (cascade = {CascadeType.ALL}, mappedBy = "creator", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private List<Question> questionList;*/

}
/*TODO: User:
        Id : string
        email : string
        phoneNumber : string
        name : string
        country: string
        –
        source: enum(internal, google)
        –
        getCustomRounds()
        getCustomerQuestions()
        getHostedGames()
        getPlayedGames()
        getStatistics()*/
