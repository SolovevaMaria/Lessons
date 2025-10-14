//package com.example.workdb.repositories;
//
//import com.example.workdb.DTOs.TeacherDTO;
//import com.example.workdb.entities.Teacher;
//import jakarta.transaction.Transactional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
////import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
////Repository
////CrudRepository
////save
////saveAll
////findById
////existById
////findAll
////findAllById
////count
////deleteById
////delete
////deleteAll
//
//
//
//
//
//
//
////PagingAndSortingRepository
////findAll(Pageable pageable)
////findAll(Sort sort)
//
//
////JPARepository
//
//@Repository
//public interface TeacherRepository extends JpaRepository<Teacher,Long> {
//
////    SELECT * FROM teacher  WHERE age > 80
////    SELECT * FROM teacher  WHERE age < 80
////    List<Teacher> findAllByOrderByAgeAsc();
////    List<Teacher> findByAgeBetween(Integer x,Integer y);
////    List<Teacher> findByAgeGreaterThan(int age);
////    List<Teacher> findByAgeLessThan(int age);
//
//
////    @Query(value = " SELECT * FROM teacher WHERE age > :ok",nativeQuery = true)
////     List<Teacher> skubidu(@Param("ok") Integer age);
//
//
////    @Modifying
////    @Transactional
////    @Query(value = " delete from teacher WHERE age > :ok ",nativeQuery = true)
////    int skubidu(@Param("ok") Integer age);
//
////    Teacher findByFirstNameAndLastName(String firstName, String lastName);
//
////    @Query(value = " SELECT * FROM teacher",nativeQuery = true)
////    List<Teacher> skubidu();
//
////jpql
////    @Query(value = " SELECT new com.example.workdb.DTOs.TeacherDTO(t.id,t.firstName,t.lastName) FROM Teacher t",nativeQuery = false)
////    List<TeacherDTO> skubidu();
//
//
////    @Query(value = " SELECT * FROM Teacher  WHERE first_name like CONCAT('%',:name,'%') ",nativeQuery = true)
//    @Query(value = " exec getTeacherAbove30  ",nativeQuery = true)
//    List<Teacher> skubidu( );
//}
//
//
