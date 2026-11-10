# checkout-nearby-shops

Practice re-run of a live-coding interview: build "nearby pickup shops" for checkout. See [docs/TICKET.md](docs/TICKET.md).

One Spring Boot service, H2 in memory (no Docker):

```bash
./gradlew test
./gradlew bootRun     # http://localhost:8080, H2 console at /h2-console (JDBC URL jdbc:h2:mem:marketplace)
```
