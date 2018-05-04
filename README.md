# Hadoop based Credit Card managment system

1 Core Java

Java Eclipse Project 


2.1.3	RDBMS/mySQL data transformation
  
  RDBMS/
•	updated_cdw_data.zip – updated database
•	sql.txt - SQL server database, updated with LAST_UPDATED TIMESTAMP column added to cdw_sapp_customer and cdw_sapp_brunch tables, so it can have updated timestamps every time data is modified or added to these tables. 


2.2.1 Data Extraction and Transportation with Sqoop
       
            Hadoop/HDFS/
•	Hadoop.txt – Sqoop statement for Importing data from SQL server into HDFS 


2.2.2 Data Loading with Hive
            
            Hive/
•	Hive.txt -  script with Hive statements to create and populate (with data extracted in previous step) hive tables in Hadoop Filesystem.


2.2.3 Automating Sqoop and Hive processes from steps 2.2.1 and 2.2.2 with Oozie Workflow.

Oozie_1/
•	workflow.xml – oozie xml script for extracting and modifying  data based on requirements with Sqoop, creating and populating tables with Hive using scripts.  
•	external_creditcard.txt – script with hive statements to drop, create and populate cdw_sapp_creditcard with extracted data.
•	external_branch.txt - script with hive statements to drop, create and populate cdw_sapp_branch with extracted data.
•	external_customer.txt - script with hive statements to drop, create and populate cdw_sapp_customer with extracted data.
•	external_time.txt - script with hive statements to drop, create cdw_sapp_time.
•	insert_time.txt - script with hive statements to populate cdw_sapp_time with modified data from cdw_sapp_creditcard table. 
•	job.properties - configuration file, containing all parameters needed to run Oozie workflow.
•	coordinator.xml – Oozie workflow scheduler.


2.2.4 Process Optimization Module  Oozie (Sqoop and Hive optimized) 

Oozie_2/ 
•	workflow_2.xml – updated Oozie workflow script for extracting only new data using Sqoop Job and updating original tables with new data using Hive.  
•	sqoop_jobs.txt – script with Sqoop statements that needs to be run from terminal before running Oozie Workflow.
•	create_base_tables.txt - script with hive statements to drop if exists and create cdw_sapp_branch, cdw_sapp_customer, cdw_sapp_creditcard, cdw_sapp_time. cdw_sapp_creditcard, cdw_sapp_time tables will also be populated during this step, as this tables/data will remain as it is (no unique keys available for creditcard tables, not possible to update). This script will only run once, when oozie job executes first time. Then this step will be skipped based on the <decision> action. 
•	insert_into_incremental_tables.txt - script with hive statements to create and populate incremental tables for cdw_sapp_branch, cdw_sapp_customer with new data.
•	merge_with_new_data.txt- script with hive statements to update originals cdw_sapp_branch and cdw_sapp_customer tables with new data.
•	job.properties - configuration file, containing all parameters needed to run Oozie workflow.
•	coordinator.xml – Oozie workflow scheduler.
 
2.2.5 Data Visualization


Hive_visualization.docx - hive queries  and screen shots of the graphs.

