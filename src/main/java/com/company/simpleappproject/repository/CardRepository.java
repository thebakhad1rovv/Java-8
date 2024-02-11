package com.company.simpleappproject.repository;

import com.company.simpleappproject.module.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer cardId);

    List<Card> findAllByDeletedAtIsNull();

    Boolean existsByCardNumberAndDeletedAtIsNull(String cardNumber);


}
