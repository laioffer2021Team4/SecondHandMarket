package com.laioffer.secondhandmarket.repository;

import com.laioffer.secondhandmarket.entity.SaleList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleListRepository extends JpaRepository<SaleList, Long> {

}
