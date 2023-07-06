package com.study.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
