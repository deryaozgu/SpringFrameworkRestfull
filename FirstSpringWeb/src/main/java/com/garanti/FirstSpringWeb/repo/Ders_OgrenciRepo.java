package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ders_Ogrenci;
import com.garanti.FirstSpringWeb.model.Ogrenci;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ders_OgrenciRepo {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<Ders_Ogrenci> getAll()
    {
        return jdbcTemplate.query("select * from BILGE.DERS_OGRENCİ", BeanPropertyRowMapper.newInstance(Ders_Ogrenci.class));

    }

    public Ders_Ogrenci getById(int id)
    {
        Ders_Ogrenci ders_ogrenci = null;
        String sql = "select * from BILGE.DERS_OGRENCİ where ID = :ABUZIDDIN";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ABUZIDDIN", id);
        ders_ogrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders_Ogrenci.class));
        return ders_ogrenci;
    }

    public boolean deleteById( int id){
        String sql = "delete from BILGE.DERS_OGRENCİ where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

    public boolean save ( Ders_Ogrenci ders_ogrenci)
    {
        String sql = "Insert into BILGE.DERS_OGRENCİ (DERS_ID, OGRENCI_ID,NOTE,DEVAMSIZLIK) values (:DERS_ID, :OGRENCI_ID,:NOTE,:DEVAMSIZLIK)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("NAME", ders_ogrenci.getDERS_ID());
        paramMap.put("NAME", ders_ogrenci.getOGRENCI_ID());
        paramMap.put("NAME", ders_ogrenci.getNOTE());
        paramMap.put("NAME", ders_ogrenci.getDEVAMSIZLIK());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }
    public List<Ders_Ogrenci> getAllLike(String name)
    {
        String sql = "select * from BILGE.DERS_OGRENCİ where NAME LIKE :NAME";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("NAME", "%" + name + "%");
        return namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders_Ogrenci.class));
    }
}