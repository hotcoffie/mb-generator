package com.xieyu.mbgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author 小谢
 * Date: 2019/7/5 005上午 11:02
 */
@RestController
public class AppController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${spring.datasource.database}")
    private String database;

    @GetMapping("tables")
    public List<Map<String, Object>> tables() {
        return jdbcTemplate.queryForList("SELECT TABLE_NAME `name`,TABLE_COMMENT `comment` FROM information_schema.tables WHERE table_schema=? ", database);
    }

    @GetMapping("clos")
    public List<Map<String, Object>> clos(@RequestParam String tableName) {
        return jdbcTemplate.queryForList("SELECT\n" +
                "\tt1.COLUMN_NAME `name`,\n" +
                "\tt1.COLUMN_TYPE `type`,\n" +
                "\tt1.COLUMN_COMMENT `comment`,\n" +
                "\tIF(t2.COLUMN_NAME IS NULL, 0,1) `isPrimary`\n" +
                "FROM\n" +
                "\tINFORMATION_SCHEMA. COLUMNS t1\n" +
                "LEFT JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE t2 ON t1.TABLE_SCHEMA = t2.TABLE_SCHEMA\n" +
                "AND t1.TABLE_NAME = t2.TABLE_NAME\n" +
                "AND t2.CONSTRAINT_NAME = 'PRIMARY'\n" +
                "AND t1.COLUMN_NAME = t2.COLUMN_NAME\n" +
                "WHERE t1.TABLE_SCHEMA=? AND t1.TABLE_NAME=?", database, tableName);
    }

}
