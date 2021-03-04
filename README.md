# BasicArticleExample

1. Dwonload from Github
2. open Eclipse and then --> Import Maven Projects --> Select Folder which will bring the pom.xml itself --> Click finish
3. open ArticleApplication.java --> Run as SpringBoot App.
4. opne http://localhost:8080/swagger-ui.html
5. Database link http://localhost:8080/h2-ui/login.do

Notes : 
1. Make sure maven/eclipse have permission to download the jar files.
2. I have included the swagger to test the application; link for same have been given.
3. If application through error about port number in use please add --> server.port=8081 --> in application.properties file
4. Have used Spring JPA it will create the table itself.
5. Have used H2 as database link for the same has been provided.


Save --> as mentioned in the use case.
Get --> can get by slug as per use case
Delete --> delete by slug as per use case (return type was not very clear so not returning anything)
update --> It was not very clear in use case so provide slug as Title and it will update the same slug record where slug will also be updated as per title provided but title will not be updated.
