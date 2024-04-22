package com.intern.chatproject.repositories.jpa;

//import com.intern.chatproject.dto.RenterEntityDto;
//import com.intern.chatproject.entities.RenterEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface RenterRepositoryJpa extends JpaRepository<RenterEntity, String> {
//    boolean existsRenterEntityByRenterId(String renterId);
//    @Query("select new com.intern.chatproject.dto.RenterEntityDto(" +
//            "r.renterId," +
//            "r.renterName" +
//            ") from RenterEntity r where r.renterId = :renterId")
//    Optional<RenterEntityDto> getRenterEntityDtoByRenterId(String renterId);
//}
