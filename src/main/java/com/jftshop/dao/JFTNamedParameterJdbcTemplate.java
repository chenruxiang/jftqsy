package com.jftshop.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by ThinkPad on 2017/6/20.
 */


public class JFTNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {

    public JFTNamedParameterJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public JFTNamedParameterJdbcTemplate(JdbcOperations classicJdbcTemplate) {
        super(classicJdbcTemplate);
    }

    public <T> List<T> query(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper , Pagination pagination ) throws DataAccessException {

        if ( pagination != null && pagination.getDraw() != -1 ){
            Integer count = this.queryForObject( " select count(*) as count from ( " + sql + " ) as total  " , paramMap , Integer.class );
            pagination.setRecordsFiltered( count );
            pagination.setRecordsTotal( count );

            sql = sql + " LIMIT " + pagination.getStart() + " , " + pagination.getLength() ;
        }

        return this.query( sql ,  paramMap , rowMapper );
    }



}
