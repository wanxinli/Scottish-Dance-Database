# cisc475-DanceDB
Project repo for Advanced Software Engineering
It is an application for Scottish Dance. scddata.db is the database file. There are five packages having files written in Java. Object package is for all category in the database such as Dance, Recording, and Album. GUI is for classes implement the user interface. Database is for classes connect to database and make query. Main has the main method. Testing package has TestQuery class to use Junit test to test the SqlConnection class and SqlQuery class. 

To run the code, download all the packges and the database file. You need to download sqlite.jdbc.Then, run the eclipse. Add the packages under the src folder. Add sqlit.jdbc library to the build path configuration. Then, run the MainClass.java. It shows a search text filed. Enter "Lazy" that is a dance's name in database. Then, you will see 4 in the console window that is number of data retrieved from the database. Entering other values will not show any number, as there is no data retrieved from database.


http://sqlitebrowser.org/
