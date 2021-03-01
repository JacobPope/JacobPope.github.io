# Artifact Enhancement 1 - Software Design and Engineering
The artifact I selected was my final project from CS-340, the version I am using for the modification is my improved version from the second enhancement. The original artifact only served to be a proof-of-concept project in which CRUD operations occurred through curl requests. The intent of this enhancement is to provide a web interface to allow a user to execute CRUD operations for a MongoDB database.

Converting the original artifact from Python to Java allows me to show my abilities to learn and adapt to a new stack and conform to the restrictions and differences in different languages. Python is vastly different to Java, it is interpreted during runtime, variables do not maintain specific types, and the overall structure is different. Data Structures and Algorithms are a huge part of designing and engineering software, due to the differences in languages, I had to restructure the program to accommodate Java variable types. This enhancement showcases my ability to adapt and research a new language. The specific REST API that I used in Python does not exist in Java, so I had to research an alternative and learn how it worked. 

The process of converting this artifact was both fun and frustrating, however I feel the challenges are what make designing software fun. As I previously mentioned, I had to research and learn how a Java RESTful API worked and implement it. This brought numerous challenges as with python, data types are not as relevant, but with Java data types are very rigid. I ran into issues converting the raw JSON string data into a JSON object. Another issue I ran into is reading the file data for DocumentCreate, as file readers are not as straight forward as they are in Python. In terms of design, I had to ultimately decide how to handle the file data, as there are many ways to load file data. The biggest lesson that I constantly encounter and learn from is that no problem is too big to solve. You may hit an obstacle, but there is always a way around it.


## Framework Code
- [DocumentCreate.java](./src/code_views/DocumentCreate.md)
- [DocumentRead.java](./src/code_views/DocumentRead.md)
- [DocumentUpdate.java](./src/code_views/DocumentUpdate.md)
- [DocumentDelete.java](./src/code_views/DocumentDelete.md)

## RESTFul API Implementation
- [FunctionalityTestApp.java](./src/code_views/FunctionalityTestApp.md)
- [RESTController.java](./src/code_views/RESTController.md)
- [SpringRESTApplication.java](./src/code_views/SpringRESTApplication.md)

## Links
- [Home](../index.md)
- [Code Review](https://youtu.be/ApvjrFq6wMU)
- [Artifact Enhancement 2](../enhancement_2/enhancement2.md)
- [Artifact Enhancement 3](../enhancement_3/enhancement3.md)
