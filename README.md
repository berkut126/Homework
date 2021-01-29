# Homework-tracking site
This is a simple website that shows the timetable for the nearest two working days and the homework for all the subjects.
## Requirements
1. Web server
2. PHP 7.4+
3. MySQL
4. MySQL user with rights to create a database and tables in it (or an initialized schema and a user with permissions to read form and write to the table)
## Installation
1. Create a directory where served content will be held
2. Copy the files from github:
```bash
git pull https://gitlab.random-fqdn.ru/berkut126/homework.git
```
3. Initialize the database with SQL scripts from homework/schema
4. Copy all files, except api.yaml, LICENSE, README.md, and the schema directory to the created folder
5. Set up your web server to serve the content from the directory from step 1. The use of TLS 1.2+, CSP and HSTS is recommended.
