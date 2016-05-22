import groovy.sql.Sql
db = Sql.newInstance(
        'jdbc:hsqldb:mem:GinA',
        'sa',
        '',
        'org.hsqldb.jdbcDriver')