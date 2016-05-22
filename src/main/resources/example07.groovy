import groovy.sql.Sql
source = new org.hsqldb.jdbc.jdbcDataSource()
source.database = 'jdbc:hsqldb:mem:GinA'
source.user = 'sa'
source.password = ''
db = new groovy.sql.Sql(source)

db.execute '''
DROP INDEX athleteIdx IF EXISTS; DROP TABLE Athlete IF EXISTS; CREATE TABLE Athlete (
                  athleteId   INTEGER GENERATED BY DEFAULT AS IDENTITY,
                  firstname   VARCHAR(64),
                  lastname    VARCHAR(64),
                  dateOfBirth DATE
);
              CREATE INDEX athleteIdx ON Athlete (athleteId);
'''

def athletes = [
        [first: 'Paul',    last: 'Tergat',     birth: '1969-06-17'],
        [first: 'Khalid',  last: 'Khannouchi', birth: '1971-12-22'],
        [first: 'Ronaldo', last: 'da Costa',   birth: '1970-06-07']
]
athletes.each { athlete ->
    db.execute """
INSERT INTO Athlete (firstname, lastname, dateOfBirth)
VALUES (${athlete.first}, ${athlete.last}, ${athlete.birth}); """
}