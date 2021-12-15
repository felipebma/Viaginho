build:
	cd ./cliente-frontend && ./mvnw package; \
	cd ../conta-service && ./mvnw package; \
	cd ../hotel-service && ./mvnw package; \
	cd ../naming-service && ./mvnw package; \
	cd ../ && docker-compose build
	