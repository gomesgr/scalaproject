services:

  postgres:
    image: postgres
    container_name: psql
    restart: always
    environment:
      POSTGRES_PASSWORD: 123
      POSTGRES_USER: psql
    ports:
      - "5432:5432"

  pgadmin:
    image: dpage/pgadmin4
    container_name: pgadmin
    environment:
      - PGADMIN_DEFAULT_EMAIL=test@example.com
      - PGADMIN_DEFAULT_PASSWORD=123
      - PGADMIN_LISTEN_PORT=5050
    ports:
      - "5050:5050"

# host.docker.internal para usar no IP no pgadmin (mac/windows)