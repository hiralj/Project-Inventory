# Project-Inventory

Perform credit, debit and manage inventory

Use following command to create runnable jar:
// Current directory - 'out' - where you see 'inventory' and 'org' folder with all the class files.
// Move mysql-connector.jar to the same directory
// Move the Manifest.mf file to the same directory

jar cfm Project.jar Manifest.mf org/ inventory/ mysql-connector.jar

// To run file
java -jar Project.jar
