# Build log

What was added, step by step, and why. Newest steps go at the bottom.

---

## Step 0 — Starting codebase (given code, no feature yet)

**Files:** `build.gradle.kts`, `application.yml`, `data.sql`, packages `buyer`, `ad`, `location`, `courier/dhl`, `courier/hermes`, empty `checkout`, `docs/TICKET.md`

A **modular monolith**: one Spring Boot app, one package per module. Like a real codebase, the modules were built by different people and look different:

| Module | Main types | Location data | Quirk |
|---|---|---|---|
| `buyer` | `Buyer` entity, `Address` (embedded record) | `Double latitude/longitude` | can be **null** (Carla, buyer 3) |
| `ad` | `Ad` entity, `AdStatus` | none, only `sellerId` | ad 12 is SOLD |
| `location` | `SellerLocation` entity, key = `sellerId` | `double lat/lng` | seller 300 has **no row** |
| `courier/dhl` | `DhlLocationClient.findAll()` → `DhlPackstation` | `latitude/longitude` | returns all of Germany |
| `courier/hermes` | `HermesShopClient.searchByCity(city)` → `HermesParcelShop` | nested `GeoCoordinate(lat, lon)` | search by city only; real one can fail |

- H2 in memory; Hibernate creates tables from the entities (`ddl-auto: create-drop`), then `data.sql` inserts demo data (`defer-datasource-initialization`).
- `open-in-view: false`: no lazy loading after the service method returns.

**Concepts:** modular monolith, embedded value (`@Embeddable`), Spring Boot SQL init.

**Try it:** `./gradlew test` (smoke test), or `./gradlew bootRun` and open `http://localhost:8080/buyers/1`.

---

<!-- New steps go below this line -->

## Step 1 — CI pipeline (project setup, no module)

**Files:** `.github/workflows/ci.yml`

The repo now lives on GitHub (`khbaydoun/checkout-nearby-shops`, public). A GitHub Actions workflow builds the project and runs the tests on a clean Linux machine, so "works on my machine" is checked by someone else's machine.

- `on: push (main) / pull_request`: runs after every push to `main` and for every pull request.
- `permissions: contents: read`: the job can read the code and nothing else (least privilege).
- `concurrency ... cancel-in-progress`: a newer push cancels the older run of the same branch.
- `setup-java` with Temurin 21: same Java version as the Gradle toolchain in `build.gradle.kts`.
- `./gradlew build`: compiles, runs all tests and builds the jar; a failing test makes the run red.
- `upload-artifact` with `if: failure()`: keeps the HTML test report only when a run fails.

This is CI only. There is no CD (deployment) yet, because there is no place to deploy to.

**Concepts:** continuous integration, GitHub Actions workflow, least privilege.

**Try it:** `gh run list --limit 5` shows the runs; `gh run watch` follows the current one. Locally the same check is `./gradlew build`.
