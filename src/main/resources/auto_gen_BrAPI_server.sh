#! /bin/bash


API_PATH=~/Documents/BrAPI/API
SERVER_CODE_PATH=~/Documents/BrAPI/brapi-Java-TestServer/

# Generate complete swagger definition file
python $API_PATH/Scripts/buildOpenAPI.py $API_PATH/

# Generate Java Spring MVC server stub
cd $SERVER_CODE_PATH
java -jar ~/Documents/scripts/swagger-codegen-cli.jar generate -i $API_PATH/brapi_openapi.yaml -l spring --library spring-mvc -o ./target/spring-gen-brapi/


SWAGGER_PACKAGE=src/main/java/io/swagger

# Keep *_dep deprecated files which will not get generated
mv ./$SWAGGER_PACKAGE/api/*_dep.java ./target/spring-gen-brapi/$SWAGGER_PACKAGE/api

# Remove old API Interface files
rm -rf ./$SWAGGER_PACKAGE/api/*.java
# Remove generated concrete controller classes
rm -rf ./target/spring-gen-brapi/$SWAGGER_PACKAGE/api/*Controller.java
# Move new interfaces files into correct package
mv ./target/spring-gen-brapi/$SWAGGER_PACKAGE/api/*.java ./$SWAGGER_PACKAGE/api/

# Remove old API model files
rm -rf ./$SWAGGER_PACKAGE/model/*.java
# Move new models into correct package
mv ./target/spring-gen-brapi/$SWAGGER_PACKAGE/model/*.java ./$SWAGGER_PACKAGE/model/

# Fix API interfaces
find ./$SWAGGER_PACKAGE/api/ -name "*Api.java" | xargs sed -i \
	-e "s/\(package io.swagger.api;\)/\1\nimport org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;/g" \
	-e "s/    ResponseEntity\(.*\);/    ResponseEntity\1 throws BrAPIServerException;/g" \
	-e "s/ResponseEntity<Void>/ResponseEntity<String>/g"\
	-e "s/ List</ ArrayList</g"\
	-e "s/import java.util.List;/import java.util.ArrayList;/g"\
	-e "s/ OffsetDateTime / String /g"
	
