# Homework-tracking site
This is a simple website that shows the timetable for the nearest two working days and the homework for all 
the subjects.
## Requirements
1. Web server
2. PHP 7.4+
3. MySQL
## Installation
### Manual
1. Create a directory where served content will be held.
2. Copy the files from github:
```bash
git pull https://gitlab.random-fqdn.ru/berkut126/homework.git
```
3. Set environmental variables ```SqlDatabase```, ```SqlUser```, ```SqlPassword```, ```AdminLogin```, 
   and ```AdminPass```.
3. Initialize the database with SQL scripts from homework/schema and add initial data (timetable to lessons table).
4. Copy all files, except ```api.yaml```, ```LICENSE```, ```README.md```, ```addUser.php``` and 
   the ```schema``` directory to the created folder.
5. Set up your web server to serve the content from the directory from step 1. The use of 
   TLS 1.2+, CSP and HSTS is recommended.
### Docker
Not available yet.
## Notes
The logins and passwords used in the code (can be found in history) have never been used in production.
The default admin login and pass are set by environmental variables ```AdminLogin``` and ```AdminPass``` respectively.
Working SQL database, login, and password are set by environmental variables ```SqlDatabase```, 
```SqlUser```, ```SqlPassword``` respectively. The default permissions for user ```SqlUser``` on database 
```SqlDatabase``` are `SELECT, INSERT, UPDATE, DELETE`{:.language-sql}. To change them, please edit 
```schema/Database.sql```
