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


public interface IBenXeRepository extends JpaRepository<BenXe, Integer> {
    @Query(value = "select * from ben_xe where flag_delete = false ",nativeQuery = true)
    Page<BenXe> getAll(Pageable pageable);

    @Query(value = "select  * from ben_xe where flag_delete = false ",nativeQuery = true)
    List<BenXe> getAllBenXe();

    @Query(value = "select * from ben_xe where flag_delete =false and id =:id",nativeQuery = true)
    BenXe findBenXeById(@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(value = "update ben_xe set flag_delete = true where id =:id",nativeQuery = true)
    void deleteBenXe(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update ben_xe set " +
            "ma_xe =:#{#benXe.maXe}, " +
            "phone =:#{#benXe.phone}, " +
            "email =:#{#benXe.email}, " +
            "gio_di =:#{#benXe.gioDi}, " +
            "gio_den =:#{#benXe.gioDen}, " +
            "diem_den_id =:#{#benXe.diemDen.id}, " +
            "diem_di_id =:#{#benXe.diemDi.id}, " +
            "loai_xe_id =:#{#benXe.loaiXe.id}, " +
            "nha_xe_id =:#{#benXe.nhaXe.id} " +
            "where id =:#{#benXe.id} " +
            "and flag_delete = false ",nativeQuery = true)
    void editBenXe(@Param("benXe") BenXe benXe);

    @Transactional
    @Modifying
    @Query(value = "insert into ben_xe" +
            "(ma_xe," +
            "phone," +
            "email," +
            "gio_di," +
            "gio_den," +
            "diem_den_id," +
            "diem_di_id," +
            "loai_xe_id," +
            "nha_xe_id," +
            "flag_delete) " +
            "values " +
            "(:#{#benXe.maXe}, " +
            ":#{#benXe.phone}, " +
            ":#{#benXe.email}, " +
            ":#{#benXe.gioDi}, " +
            ":#{#benXe.gioDen}, " +
            ":#{#benXe.diemDen.id}, " +
            ":#{#benXe.diemDi.id}, " +
            ":#{#benXe.loaiXe.id}, " +
            ":#{#benXe.nhaXe.id}, " +
            ":#{#benXe.flagDelete})",nativeQuery = true)
    void addBenXe(@Param("benXe") BenXe benXe);
}
