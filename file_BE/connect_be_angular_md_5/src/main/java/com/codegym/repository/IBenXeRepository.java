package com.codegym.repository;

import com.codegym.model.BenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBenXeRepository extends JpaRepository<BenXe, Integer> {
    @Query(value = "select * from ben_xe where flag_delete = false ",nativeQuery = true)
    Page<BenXe> getAll(Pageable pageable);

    @Query(value = "select  * from ben_xe where flag_delete = false ",nativeQuery = true)
    List<BenXe> getAllBenXe();

    @Query(value = "select * from ben_xe where flag_delete =false and id =:id",nativeQuery = true)
    BenXe findBenXeById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update ben_xe set flag_delete = true where id =:id",nativeQuery = true)
    void deleteBenXe(@Param("id") Integer id);
}
