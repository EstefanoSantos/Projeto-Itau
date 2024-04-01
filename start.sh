docker-compose down

docker build -t backend-desafioitau:latest .

docker-compose up --build --force-recreate --remove-orphans