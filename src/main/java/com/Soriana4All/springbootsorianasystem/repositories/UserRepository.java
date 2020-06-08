package com.Soriana4All.springbootsorianasystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Soriana4All.springbootsorianasystem.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
