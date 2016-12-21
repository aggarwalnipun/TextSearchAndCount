TextSearchAndCount
==================
The objective is to perform search and count operations using curl command. The input will be JSON.
The implementation uses Spring Framework and two different services are implemented using RESTful Services which are protected by Spring Security.

Operating Instructions
==========================

#Building the project (Alternatively, you can use existing war file in \\TextSearchAndCount\target\ folder)
1. Copy project to your local drive
2. Open location in command prompt: cd workspace/TextSearchAndCount
3. Run command: mvn clean install
4. This creates TextSearchAndCount.war file in \\TextSearchAndCount\target\ folder

#Running the project
1. Deploy TextSearchAndCount.war on server. In case of tomcat, this can be done manually by copying war file to webapps directory of Tomcat.
2. Make sure server is started up and run curl commands from command prompt

Test Run
========
# Search and Count Text 
# curl cmd:
curl http://localhost:8080/TextSearchAndCount/counter-api/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H"Content-Type: application/json" -d "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\",\"Augue\",\"Pellentesque\",\"123\"]}" -X POST

OR

curl http://localhost:8080/TextSearchAndCount/counter-api/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H"Content-Type: application/json" -d '{"searchText":["Duis", "Sed", "Donec","Augue","Pellentesque","123"]}' -X POST

*Please note: The 1st version of above command has been modified to escape characters which give an issue when running from command prompt in windows. If you running on windows platform you might need to do this

#Result
{"counts":[{"duis":11},{"sed":16},{"donec":8},{"augue":7},{"pellentesque":6},{"123":0}]}


# Top N Text(where N is passed as path variable) 
# curl cmd:
curl http://localhost:8080/TextSearchAndCount/counter-api/top/20 -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H"Accept: text/csv"

#Result
17|vel
17|eget
16|sed
15|in
14|et
13|eu
13|ut
12|sit
12|nulla
12|metus
12|id
12|amet
12|ac
11|ipsum
11|duis
11|at
11|vitae
11|nec
10|nunc
10|non

# curl cmd:
curl http://localhost:8080/TextSearchAndCount/counter-api/top/5 -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H"Accept: text/csv"

#Result
17|vel
17|eget
16|sed
15|in
14|et
