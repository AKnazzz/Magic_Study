package com.roks.realpostgres.services;


import com.roks.realpostgres.repository.Repository;
import com.roks.realpostgres.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class DogsAppServices {

    @Autowired
    private EntireProjectRepo entireProjectRepo;

    @Autowired
    private Repository repository;

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

    @PostMapping("/createUser/{login}")
    public String createUser(
            @PathVariable(value = "login") String login
    ) {
        final double longitude = rndDouble();
        final double latitude = rndDouble();

        if (login == null) {
            throw new IllegalArgumentException("login is null");
        }

        repository.createUser(login, longitude, latitude);
        return repository.getUser(login).toString();
    }

    @PostMapping("/createDog/{name}")
    public String createDog(
            @PathVariable(value = "name") String name
    ) {
        repository.createDog(name, rndDouble(), rndDouble());
        return repository.getDog(name).toString();
    }

    @PostMapping("/createWalk/{userLogin}/{dogName}")
    public String createWalk(
            @PathVariable(value = "userLogin") String userLogin,
            @PathVariable(value = "dogName") String dogName
    ) {
        final Date startDate = rndDate();
        repository.createWalk(userLogin, dogName, rndDouble(), rndDouble(), startDate, 10, 10.0, false);
        return repository.getWalk(userLogin, dogName, startDate).toString();
    }

    @PostMapping("/increaseUserBalance/{login}/{amount}")
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public String increaseUserBalance(
            @PathVariable(value = "login") String login,
            @PathVariable(value = "amount") double amount
    ) {
        final User user = repository.getUser(login);
        final double newBalance = user.getBalance() + amount;
        repository.updateUserBalance(login, newBalance);
        return repository.getUser(login).toString();
    }

    @GetMapping("/max_walks")
    public List<String> maxWalks() {
        return entireProjectRepo.getTop10WalkingUsersFromDb();
    }

    private double rndDouble() {
        return Math.random() * 100;
    }

    private Date rndDate() {
        final String dateInString = "1-Dec-2030";
        try {
            final int plusSec = ThreadLocalRandom.current().nextInt(400000, 512643);
            final Instant startInstant = formatter.parse(dateInString).toInstant().plus(plusSec, ChronoUnit.SECONDS);
            return Date.from(startInstant);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



}
