import groovy.sql.Sql

def url = 'jdbc:derby:myDB;create=true;user=me;password=mine'
def user = 'me'
def password = 'mine'
def driver = 'org.apache.derby.jdbc.EmbeddedDriver'
def sql = Sql.newInstance(url, user, password, driver)

// use 'sql' instance ...
/*
sql.execute """
    CREATE TABLE Athlete (
                  athleteId   INTEGER NOT NULL PRIMARY KEY,
                  firstname   VARCHAR(64),
                  lastname    VARCHAR(64),
                  dateOfBirth DATE
)
"""

def athletes = [
        [id: 1, first: 'Paul', last: 'Tergat', birth: '1969-06-17'],
        [id: 2, first: 'Khalid', last: 'Khannouchi', birth: '1971-12-22'],
        [id: 3, first: 'Ronaldo', last: 'da Costa', birth: '1970-06-07']
]

athletes.each { athlete ->
    sql.execute """
        INSERT INTO Athlete (athleteId, firstname, lastname, dateOfBirth)
        VALUES (${athlete.id}, ${athlete.first}, ${athlete.last}, ${athlete.birth})
    """
}

sql.query('SELECT firstname, lastname from Athlete') { resultSet ->
    while (resultSet.next()) {
        def first = resultSet.getString(1)
        def last = resultSet.getString('lastname')
        println "$first $last"
    }
}

*/


def fmt = new java.text.SimpleDateFormat('dd. MMM yyyy (E)', Locale.US)

sql.eachRow('SELECT * from Athlete') {  athlete ->
    println "$athlete.firstname $athlete.lastname"
    println 'born on' + fmt.format(athlete.dateOfBirth)
}

sql.close()